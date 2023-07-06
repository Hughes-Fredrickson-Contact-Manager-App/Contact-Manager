import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



public class ContactManager {
	static Contact contact = new Contact();
	static Scanner scanner = new Scanner(System.in);
	
	
    public static void main(String[] args) throws IOException {
    	
    	
//    	Create data directory and Contacts.txt if user does not have one
    
        contact.createFileAndDir();
        
//      Main logic to run program - continuously displays menu until user types anything other than 1-4
       
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
