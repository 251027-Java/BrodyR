package org.example.Repository;

import org.example.Expense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TextRepository implements IRepository{
    private String filename = "src/main/expenses.txt";
    
    public TextRepository(){};

    public void createExpense(Expense expense){
        List<Expense> expenses = loadExpenses();
        expenses.add(expense);
        saveExpenses(expenses);
    }

    public Expense readExpense(int id){
        return loadExpenses().stream().filter(e -> e.getID() == id).findFirst().orElse(null);
    }

    public void updateExpense(Expense expense){
        List<Expense> expenses = loadExpenses();
        List<Expense> updatedExpenses = expenses.stream().map(e -> (e.getID() == expense.getID()) ? expense : e).toList();
        saveExpenses(updatedExpenses);
    }

    public void deleteExpense(int id){
        List<Expense> expenses = loadExpenses();
        expenses.removeIf(e -> e.getID() == id);
        saveExpenses(expenses);
    }

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
                System.out.println("Successfully loaded expenses from \"expenses.txt\"");
            }
        } catch ( Exception e ) { System.out.println(e); }
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

    @Override
    public void clearRepo(){
        saveExpenses(new ArrayList<Expense>());
    }
}