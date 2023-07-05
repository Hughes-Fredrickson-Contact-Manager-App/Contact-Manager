
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ContactManager {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1-5) then press Enter:");

        String userInput = scanner.next();
        switch (userInput) {
            case "1" -> System.out.println("Here is a list of our contacts: \n");
            case "2" -> System.out.println("Add contact Method");
            case "3" -> System.out.println("Search Contact Method");
            case "4" -> System.out.println("Delete contact method");
            case "5" -> System.out.println("Exit");
        }
        String name;
        String phoneNumber;

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
    }
}
