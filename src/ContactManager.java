import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class ContactManager {

    static void menu() {
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1-5) then press Enter:");


    }

    static void createTempFile() throws IOException {
        try {
            String directory = "data";
            String tempFile = "Temp.txt";
            Path tempDataFile = Paths.get(directory, tempFile);

            Files.createFile(tempDataFile);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void deleteContact(String ContactName) throws IOException {
        try {


            Path contactPath = Paths.get("data", "Contacts.txt");
            Path tempPath = Paths.get("data", "Temp.txt");
            List<String> contactListFromFile = Files.readAllLines(contactPath);
            for (int i = 0; i < contactListFromFile.size(); i += 1) {
                if (!contactListFromFile.get(i).contains(ContactName)){
                Files.write(
                        tempPath,
                        Collections.singletonList(String.format(contactListFromFile.get(i))),
                        StandardOpenOption.APPEND
                );

            }}
            Files.delete(contactPath);
            Files.move(tempPath, tempPath.resolveSibling("Contacts.txt"));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        String directory = "data";
        String filename = "Contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);


        if (Files.notExists(dataDirectory)) {
            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        menu();

        Contact newContact = new Contact();




        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();


        switch (userInput) {
            case "1" -> {
                Path contactPath = Paths.get("data", "Contacts.txt");
                List<String> contactListFromFile = Files.readAllLines(contactPath);
                for (int i = 0; i < contactListFromFile.size(); i += 1) {

                    System.out.println(contactListFromFile.get(i));
                }
                List<String> lines = Files.readAllLines(Paths.get("data", "Contacts.txt"));
            }
            case "2" -> {
                System.out.println("What is your Contacts name?");
                newContact.name = scanner.next();
                System.out.println("What is your Contacts phone number?");
                newContact.phoneNumber = scanner.next();

                Files.write(
                        Paths.get("data", "Contacts.txt"),
                        Collections.singletonList(String.format("%-15s | %-15s%n", newContact.name, newContact.phoneNumber)),
                        StandardOpenOption.APPEND
                );
            }
            case "3" -> {
                System.out.println("Enter the Contact you're looking for:");
                Path contactPath = Paths.get("data", "Contacts.txt");
                List<String> contactListFromFile = Files.readAllLines(contactPath);

                String name = scanner.next();

                try {
                    scanner = new Scanner(contactPath).useDelimiter(",");

                    while (scanner.hasNext()) {
                        final String lineFromFile = scanner.nextLine();
                        if (lineFromFile.contains(name)) {
                            System.out.println(lineFromFile);
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println(" cannot write to file " + contactPath);
                }
            }
            case "4" -> {
                createTempFile();
                System.out.println("Who would you like to delete from your contacts?");
                String deletedContact = scanner.next();
                deleteContact(deletedContact);
            }
            case "5" -> {
                System.out.println("Thank you and have a great day!");
                System.exit(0);
            }
        }
    }
}
