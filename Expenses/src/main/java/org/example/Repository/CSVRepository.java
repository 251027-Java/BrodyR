package org.example.Repository;

import org.example.Expense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVRepository implements IRepository{
    private String filename = "expenses.csv";

    public CSVRepository(){};

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
        System.out.println("Loading expenses from \"expenses.csv\"");
        List<Expense> expenses = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            line = reader.readLine();
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(", ");
                int id = Integer.parseInt(parts[0]);
                Date date = new Date(parts[1]);
                double value = Double.parseDouble(parts[2]);
                String merchant = parts[3];
                expenses.add(new Expense(id, date, value, merchant));
            }
        } catch ( Exception e ) { System.out.println(e); }
        System.out.println("Successfully loaded expenses from \"expenses.csv\"");
        return expenses;
    }

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

    @Override
    public void clearRepo(){
        saveExpenses(new ArrayList<Expense>());
    }
}
