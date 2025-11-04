package org.example;

import java.util.Date;

public class ExpenseTest {
    public static void main(String[] args){
        testExpenseCreation();
    }

    public static void testExpenseCreation() {
        Expense expense = new Expense(1, new Date(), 100, "DummyMerchant");

        int possibleID = expense.getID();
        double possibleValue = expense.getValue();

        if (possibleID != 1) { System.out.println("Failed id"); }
        else if (possibleValue != 100) { System.out.println("Failed value"); }
        else { System.out.println("Passed expense creation"); }
    }
}
