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


}
