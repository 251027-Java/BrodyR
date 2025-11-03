package org.example.Repository;

import org.example.Expense;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class TextRepository implements IRepository{
    private String filename = "expenses.txt";
    
    public TextRepository(){};
    
    @Override
    public void saveExpenses(List<Expense> expenses){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (Expense expense : expenses) {
                writer.write(expense.toString());
                writer.newLine();
            }
            writer.close();
            System.out.println("Created \"expenses.txt\" file");
        } catch (Exception e) { System.out.println(e); }
    }
}