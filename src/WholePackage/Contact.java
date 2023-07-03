package WholePackage;

import java.util.ArrayList;

public class Contact {

    private String name;

    private ArrayList<Integer> numbers;

    public Contact(String name){
        this.name = name;
        this.numbers = new ArrayList<>();
    }

    public String getName() {return this.name;}

    public void addNumber(int number){
        numbers.add(number);
    }


    public static class ContactList {
        public static boolean list() {
            System.out.format("%-15s | %-15s%n", "Name", "Phone number");
            System.out.println("---------------------------");
            System.out.format("%-15s | %-15s%n", "Jack Blank", "210-567-8923");
            System.out.format("%-15s | %-15s%n", "Jane Doe", "789-8902");
            System.out.format("%-15s | %-15s%n", "Sam Space", "210-581-8123");
            return false;
        }
    }

}
