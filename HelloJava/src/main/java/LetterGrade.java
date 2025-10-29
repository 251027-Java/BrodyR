import java.util.Scanner;

public class LetterGrade {
    public static void main(String[] arge){
        Scanner in = new Scanner(System.in);
        double grade = 0;
        IO.print("Enter your numerical grade >>> ");
        try{
            grade = in.nextDouble();
        } catch (Exception e){
            IO.println("ERROR: Invalid Input");
            System.exit(1);
        }

        if (grade < 0 || grade > 100) { IO.println("That value isn't in range from 0 - 100"); }
        else if (grade < 60) { IO.println("F"); }
        else if (grade < 70) { IO.println("D"); }
        else if (grade < 80) { IO.println("C"); }
        else if (grade < 90) { IO.println("B"); }
        else { IO.println("A"); }
    }
}
