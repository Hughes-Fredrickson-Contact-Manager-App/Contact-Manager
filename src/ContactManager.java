import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



public class ContactManager {
	static Contact contact = new Contact();
	static Scanner scanner = new Scanner(System.in);
	
	
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

        if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }
      
       
        String userInput = "0";
        	
       
	do {
    	   contact.menu();
    	    userInput = scanner.next();
    	   if(Integer.parseInt(userInput) == 1) {
    		 contact.showContacts();  
    	   } else if (Integer.parseInt(userInput) == 2) {
    		 contact.addContact();
    	   }else if (Integer.parseInt(userInput) == 3) {
    		 contact.searchContact();
    	   }else if (Integer.parseInt(userInput) == 4) {
    		 contact.createTempFile();
             System.out.println("Who would you like to delete from your contacts?");
             String deletedContact = scanner.next();
             contact.deleteContact(deletedContact);
    	   }
       } 
	
		while (Integer.parseInt(userInput) != 5);
        
      
    }
}
