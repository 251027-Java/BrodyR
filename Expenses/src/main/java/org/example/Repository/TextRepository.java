package org.example.Repository;

import org.example.Expense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TextRepository implements IRepository{
    private String filename = "expenses.txt";
    
    public TextRepository(){};

    public List<Expense> loadExpenses(){
        System.out.println("Loading expenses from \"expenses.txt\"");
        List<Expense> expenses = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null){
                String[] parts = line.split("[,=\\]]");
                int id = Integer.parseInt(parts[1]);
                Date date = new Date(parts[3]);
                double value = Double.parseDouble(parts[5]);
                String merchant = parts[7];
                expenses.add(new Expense(id, date, value, merchant));
            }
        } catch ( Exception e ) { System.out.println(e); }
        System.out.println("Successfully loaded expenses from \"expenses.txt\"");
        return expenses;
    }
    
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