package org.example;

import org.example.Service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.Repository.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    static void main() throws SQLException {
        System.out.println("Expense Tracker Starting...");
        log.info("Started the Expense Tracker");
        IRepository repo = new MongoRepository();
        log.info("Created Repository");
        Service service = new Service(repo);
        log.info("Created Service");
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

        System.out.println("Expense Tracker Closing...");
        log.info("Closing the Expense Tracker");
    }
}