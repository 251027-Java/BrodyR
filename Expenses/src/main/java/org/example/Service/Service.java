package org.example.Service;

import org.example.Expense;
import org.example.Repository.CSVRepository;
import org.example.Repository.IRepository;
import org.example.Repository.JSONRepository;
import org.example.Repository.TextRepository;
import java.util.Date;
import java.util.Scanner;
import java.util.List;

public class Service {
    private List<Expense> expenses;
    IRepository repo;

    public Service(){
        repo = new TextRepository();
        expenses = repo.loadExpenses();
    }

    public Service(IRepository repo){
        this.repo = repo;
        expenses = repo.loadExpenses();
    }

    /*
    public void getNextAction(){
        String input;
        do {
            System.out.print("What would you like to do? (Type help for options) >>> ");
            input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "help" -> help();
                case "set repository" -> setRepoInfo();
                case "create expense" -> createExpenseInfo();
                case "read expense" -> readExpenseInfo();
                case "list all expenses" -> listAllExpenses();
                case "update expense" -> updateExpenseInfo();
                case "delete expense" -> deleteExpenseInfo();
            }
        } while (!input.equalsIgnoreCase("exit"));
    }
    */

    public void createExpenseInfo(Scanner scanner){
        try{
            System.out.print("Please enter information for expense.\nValue:\t");
            double value = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Merchant:\t");
            String merchant = scanner.nextLine();
            Expense newExpense = new Expense(expenses.size()+1, new Date(), value, merchant);
            createExpense(newExpense);
            System.out.println("New expense created with id " + newExpense.getID() + ".\n" + newExpense);
        } catch(Exception e) { System.out.println("INVALID INPUT. CANCELLING EXPENSE CREATION"); }
    }

    public void createExpense(Expense expense){
        repo.createExpense(expense);
        expenses = repo.loadExpenses();
    }

    public void readExpenseInfo(Scanner scanner){
        System.out.print("What is the ID of the expense you would like to read? >>> ");
        int id;
        try{
            id = scanner.nextInt();
            scanner.nextLine();
            if(id < 1 || id > expenses.size()){
                System.out.println("No expense with that ID.");
                return;
            }
            readExpense(id);
        } catch (Exception e) { System.out.println("Not a valid id."); }
    }

    public void readExpense(int id){
        System.out.println(repo.readExpense(id));
    }

    public void listAllExpenses(){
        for (Expense e : expenses){
            System.out.println(e);
        }
    }

    public void updateExpenseInfo(Scanner scanner){
        int id;
        Date date;
        double value;
        String merchant;
        try{
            System.out.print("What is the ID of the expense you would like to update? >>> ");
            id = scanner.nextInt();
            scanner.nextLine();
            if(id < 1 || id > expenses.size()){
                System.out.println("No expense with that ID.");
                return;
            }
            System.out.print("What is the date of the expense? (Type \"now\" for current date) >>> ");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("now")){ date = new Date(); }
            else { date = new Date(input); }
            System.out.print("What is the value of the expense? >>> ");
            value = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Who was the merchant? >>> ");
            merchant = scanner.nextLine();
            Expense newExpense = new Expense(id, date, value, merchant);
            updateExpense(newExpense);
        } catch (Exception e) { System.out.println("INVALID INPUT"); }
    }

    public void updateExpense(Expense expense){
        repo.updateExpense(expense);
        expenses = repo.loadExpenses();
    }

    public void deleteExpenseInfo(Scanner scanner){
        System.out.print("What is the ID of the expense you would like to delete? >>> ");
        int id;
        try{
            id = scanner.nextInt();
            scanner.nextLine();
            if(id < 1 || id > expenses.size()){
                System.out.println("No expense with that ID.");
                return;
            }
            deleteExpense(id);
        } catch (Exception e) { System.out.println("Not a valid id."); }
    }

    public void deleteExpense(int id) {
        repo.deleteExpense(id);
    }

    public void setRepoInfo(Scanner scanner){
        System.out.print("Which repository would you like to utilize?\n\t\ttxt\tcsv\tjson\n>>> ");
        String input = scanner.nextLine();
        setRepo(input);
    }

    public void setRepo(String input){
        IRepository temp;
        switch (input.toLowerCase()) {
            case "txt" -> {
                temp = new TextRepository();
                temp.clearRepo();
                for (Expense expense : this.expenses) {
                    temp.createExpense(expense);
                }
                this.repo = temp;
                System.out.println("Set repository to txt");
            }
            case "csv" -> {
                temp = new CSVRepository();
                temp.clearRepo();
                for (Expense expense : this.expenses) {
                    temp.createExpense(expense);
                }
                this.repo = temp;
                System.out.println("Set repository to csv");
            }
            case "json" -> {
                temp = new JSONRepository();
                temp.clearRepo();
                for (Expense expense : this.expenses) {
                    temp.createExpense(expense);
                }
                this.repo = temp;
                System.out.println("Set repository to json");
            }
            default -> System.out.println("Not a valid repository.");
        }
    }

    public void help(){
        System.out.println("Actions:\nset repository\ncreate expense\nread expense\nlist all expenses\nupdate expense\ndelete expense");
    }

    public List<Expense> getExpenses(){
        return expenses;
    }
}
