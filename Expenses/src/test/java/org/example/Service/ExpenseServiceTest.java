package org.example.Service;

import org.example.Expense;
import org.example.Repository.IRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTest {
    @Mock
    IRepository mockRepo;

    @InjectMocks
    Service service;

    @Test
    public void testSummingExpeses(){
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(1, new Date(), 300, "Walmart"));
        expenses.add(new Expense(2, new Date(), 100, "HEB"));
        expenses.add(new Expense(3, new Date(), 450, "Amazon"));
        when(mockRepo.loadExpenses()).thenReturn(expenses);
        verify(mockRepo, times(1)).loadExpenses();
    }
}
