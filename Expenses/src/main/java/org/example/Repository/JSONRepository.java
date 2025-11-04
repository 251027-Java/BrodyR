package org.example.Repository;

import com.google.gson.reflect.TypeToken;
import org.example.Expense;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class JSONRepository implements IRepository{
    private String filename = "expenses.json";
    private Gson gson = new Gson();

    public JSONRepository(){};

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
        System.out.println("Loading expenses from \"expenses.json\"");
        try {
            FileReader reader = new FileReader(filename);
            Type listExpenseType = new TypeToken<List<Expense>>(){}.getType();
            List<Expense> expenses = gson.fromJson(reader, listExpenseType);
            System.out.println("Successfully loaded expenses from \"expenses.json\"");
            return (expenses != null) ? expenses : new ArrayList<>();
        } catch ( Exception e ) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    @Override
    public void saveExpenses(List<Expense> expenses){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            gson.toJson(expenses, writer);
            writer.close();
            System.out.println("Created \"expenses.json\" file");
        } catch (Exception e) { System.out.println(e); }
    }

    @Override
    public void clearRepo(){
        saveExpenses(new ArrayList<Expense>());
    }
}
