package org.example.Repository;

import org.example.Expense;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class CSVRepository implements IRepository{
    private String filename = "expenses.csv";

    public CSVRepository(){};

    @Override
    public void saveExpenses(List<Expense> expenses){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("id, date, value, merchant");
            writer.newLine();
            for (Expense expense : expenses) {
                writer.write(expense.toCSV());
                writer.newLine();
            }
            writer.close();
            System.out.println("Created \"expenses.csv\" file");
        } catch (Exception e) { System.out.println(e); }
    }
}
