package org.example.Repository;

import org.example.Expense;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import com.google.gson.Gson;

public class JSONRepository implements IRepository{
    private String filename = "expenses.json";
    private Gson gson = new Gson();

    public JSONRepository(){};

    @Override
    public void saveExpenses(List<Expense> expenses){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            gson.toJson(expenses, writer);
            writer.close();
            System.out.println("Created \"expenses.json\" file");
        } catch (Exception e) { System.out.println(e); }
    }
}
