package org.example;

import org.example.Service.Service;

import java.util.Scanner;

public class Main {
    static void main() {
        System.out.println("Expense Tracker Starting...");
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("What would you like to do? (Type help for options) >>> ");
            input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "help" -> service.help();
                case "set repository" -> service.setRepoInfo(scanner);
                case "create expense" -> service.createExpenseInfo(scanner);
                case "read expense" -> service.readExpenseInfo(scanner);
                case "list all expenses" -> service.listAllExpenses();
                case "update expense" -> service.updateExpenseInfo(scanner);
                case "delete expense" -> service.deleteExpenseInfo(scanner);
            }
        } while (!input.equalsIgnoreCase("exit"));

        System.out.println("Expensive Tracker Closing...");
    }
}