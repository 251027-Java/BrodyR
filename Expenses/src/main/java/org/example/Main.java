package org.example;

import org.example.Repository.CSVRepository;
import org.example.Repository.IRepository;
import org.example.Repository.JSONRepository;
import org.example.Repository.TextRepository;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        System.out.println("org.example.Expense Tracker Starting...");
        System.out.println("Creating test expenses:");
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(1, new Date(), 99.95, "Walmart"));
        expenses.add(new Expense(2, new Date(), 85.75, "Costco"));
        expenses.add(new Expense(3, new Date(), 10000, "Private Jet"));


        IRepository repo = new TextRepository();
        //IRepository repo = new CSVRepository();
        //IRepository repo = new JSONRepository();
        expenses = repo.loadExpenses();
        System.out.println(expenses);
        repo.saveExpenses(expenses);

        System.out.println("Expensive Tracker Closing...");
    }
}