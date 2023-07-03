import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
        if (userInput.equals("1")) {
            System.out.println("Open contacts");
        } else if (userInput.equals("2")) {
            System.out.println("Add contact Method");
        } else if (userInput.equals("3")) {
            System.out.println("Search Contact Method");
        } else if (userInput.equals("4")) {
            System.out.println("Delete contact method");
        } else if (userInput.equals("5")) {
            System.out.println("Exit");
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