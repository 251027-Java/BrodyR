package org.example.Service;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseServiceTest {

    @Test
    public void loadingExpenses(){
        InputStream is = new StringBufferInputStream("exit\n");
        System.setIn(is);
        Service service = new Service();
        assertEquals(1, service.getExpenses().getFirst().getID());
    }

    @Test
    public void createExpense(){
        Service service = new Service();
        InputStream is = new StringBufferInputStream("create expense\n40.5\nAmazon\n");
        System.setIn(is);
        service.createExpense();
        assertEquals(5, service.getExpenses().getLast().getID());
    }
}
