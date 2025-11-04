package org.example.Repository;

import org.example.Expense;
import java.util.List;

public interface IRepository {
    public List<Expense> loadExpenses();

    public void saveExpenses(List<Expense> expenses);
}
