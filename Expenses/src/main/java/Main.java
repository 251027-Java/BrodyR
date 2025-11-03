import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        System.out.println("Expense Tracker Starting...");
        System.out.println("Creating test expenses:");
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(1, new Date(), 99.95, "Walmart"));
        expenses.add(new Expense(2, new Date(), 85.75, "Costco"));
        expenses.add(new Expense(3, new Date(), 10000, "Private Jet"));
        System.out.println(expenses);
        String filename = "expenses.csv";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("id, date, value, merchant");
            writer.newLine();
            for(Expense expense : expenses){
                writer.write(expense.toCSV());
                writer.newLine();
            }
            writer.close();
            System.out.println("Created \"expenses.csv\" file");
        } catch ( Exception e ){ System.out.println("Error writing file."); }
        System.out.println("Expensive Tracker Closing...");
    }
}
