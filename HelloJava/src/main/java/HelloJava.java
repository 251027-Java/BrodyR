import java.util.*;

public class HelloJava {
    // fields/properties


    // methods/behaviors


    // your application will start from the "entrypoint"
    public static void main(String[] args){
        // We have to begin with a hello world. It must be done.
        System.out.println("Hello Java!");
        IO.println("Hello Again!");

        // Numerical Types:
        // Declare a variable by type and name
        // Initialize a variable by assigning a variable

        // Assignment operator: =
        int myInt = 4;
        double myDouble;
        myDouble = 4.5;
        myInt = 5;

        // Operators (Mathematical : +, -, *, /, %)
        myInt = 34 - 35;

        // Logical/Comparison Operators: >, <, ==, >=, <=, !=
        boolean myBoolean = myDouble > myInt;
        // boolean can store true and false
        myBoolean = true;
        myBoolean = false;

        /*
        float
        long
        short
        byte

        // Non-Numerical Types
        char
        String
        boolean
        void
        null
        */

        // Control flow covers all the keywords and functionality that allow an application to make a decision and act on it
        // if, else
        // switch, case
        // for, while, do while
        // "exception handling" try, catch


        // pseudocode - describe the logic of your code without worrying about syntax

        // initialize a boolean
        myBoolean = false;
        // make a choice based on boolean
        // if it's true, do A
        if(myBoolean){
            IO.println("myBoolean was true");
        } else {
            // if it's false, do B
            IO.println("myBoolean was false");
        }

        String newString;
        newString = "Hello everyone!";
        IO.println(newString);
        for (int i = 0; i < newString.length(); i++){
            IO.println(newString.charAt(i));
        }
        Scanner in = new Scanner(System.in);
        //newString = in.nextLine();
    }
}
