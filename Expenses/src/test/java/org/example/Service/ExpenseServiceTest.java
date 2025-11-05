package org.example.Service;
import org.example.Expense;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Date;
import org.mockito.Mockito;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseServiceTest {

    @Test
    public void loadingExpenses(){
        Service service = new Service();
        assertEquals(1, service.getExpenses().getFirst().getID());
    }

    @Test
    public void createExpense(){
        Service service = new Service();
        Date constantDate = new Date(0);
        Expense testExpense = new Expense(5, constantDate, 40.5, "Amazon");
        service.createExpense(testExpense);
        Expense actualExpense = service.getExpenses().getLast();
        assertEquals(5, actualExpense.getID());
        assertEquals(constantDate, actualExpense.getDate());
        assertEquals(40.5, actualExpense.getValue());
        assertEquals("Amazon", actualExpense.getMerchant());
    }
}
