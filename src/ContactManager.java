
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ContactManager {

    static void menu() {
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1-5) then press Enter:");


    };

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
                        Arrays.asList(String.format("%-15s | %-15s%n", newContact.name, newContact.phoneNumber)),
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
            case "4" -> System.out.println("Delete contact method");
            case "5" -> {
                System.out.println("Thank you and have a great day!");
                System.exit(0);
            }
        }
    }
}
