import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Contact {
	Scanner scanner = new Scanner(System.in);
    String name;
    String phoneNumber;
    
   public void menu() {
    	 System.out.println("1. View contacts.");
         System.out.println("2. Add a new contact.");
         System.out.println("3. Search a contact by name.");
         System.out.println("4. Delete an existing contact.");
         System.out.println("5. Exit.");
         System.out.println("Enter an option (1-5) then press Enter:");
         

    }
   
   public void showContacts() throws IOException {
	   Path contactPath = Paths.get("data", "Contacts.txt");
       List<String> contactListFromFile = Files.readAllLines(contactPath);
       for (int i = 0; i < contactListFromFile.size(); i += 1) {

           System.out.println(contactListFromFile.get(i));
       }
   }
   
   public void addContact() throws IOException {
	   System.out.println("What is your Contacts name?");
       name = scanner.next();
       System.out.println("What is your Contacts phone number?");
       phoneNumber = scanner.next();

       Files.write(
               Paths.get("data", "Contacts.txt"),
               Collections.singletonList(String.format("%-15s | %-15s%n", name, phoneNumber)),
               StandardOpenOption.APPEND
       );
   }
   
   public void searchContact() throws IOException{
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
   
   public void createTempFile() throws IOException {
       try {
           String directory = "data";
           String tempFile = "Temp.txt";
           Path tempDataFile = Paths.get(directory, tempFile);

           Files.createFile(tempDataFile);

       } catch (IOException e) {
           throw new RuntimeException(e);
       }

   }

   public void deleteContact(String ContactName) throws IOException {
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

}
