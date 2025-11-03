import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {
    static void main() {
        System.out.println("Expense Tracker Starting...");
        System.out.println("Creating test expenses:");
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(1, new Date(), 99.95, "Walmart"));
        expenses.add(new Expense(2, new Date(), 85.75, "Costco"));
        expenses.add(new Expense(3, new Date(), 10000, "Private Jet"));
        System.out.println(expenses);
        try {
            makeCSV(expenses);
            makeJSON(expenses);
        } catch ( Exception e ){ System.out.println("Error writing one or more files."); }
        System.out.println("Expensive Tracker Closing...");
    }

    static void makeCSV(List<Expense> expenses) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.csv"));
        writer.write("id, date, value, merchant");
        writer.newLine();
        for(Expense expense : expenses){
            writer.write(expense.toCSV());
            writer.newLine();
        }
        writer.close();
        System.out.println("Created \"expenses.csv\" file");
    }

    static void makeJSON(List<Expense> expenses) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.json"));
        Gson gson = new Gson();
        gson.toJson(expenses, writer);
        /*
        writer.write("[");
        writer.newLine();
        for(int i = 0; i < expenses.size()-1; i++){
            writer.write(expenses.get(i).toJSON() + ",");
            writer.newLine();
        }
        writer.write(expenses.getLast().toJSON());
        writer.newLine();
        writer.write("]");
        */
        writer.close();
        System.out.println("Created \"expenses.json\" file");
    }
}