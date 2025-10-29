import java.util.Scanner;

public class LetterGrade {
    public static void main(String[] arge){
        Scanner in = new Scanner(System.in);
        double grade = -1;
        boolean invalidInput = true;
        IO.print("Enter your numerical grade >>> ");

        while (invalidInput) {
            try {
                grade = in.nextDouble();
                if (grade < 0 || grade > 100){
                    IO.print("That value isn't in range from 0 - 100. Try again >>> ");
                } else {
                    invalidInput = false;
                    in.close();
                }
            } catch (Exception e) {
                IO.print("ERROR: Invalid Input. Try again >>> ");
                in.nextLine();
            }
        }

        if (grade < 60) { IO.println("F"); }
        else if (grade < 70) { IO.println("D"); }
        else if (grade < 80) { IO.println("C"); }
        else if (grade < 90) { IO.println("B"); }
        else { IO.println("A"); }
    }
}
