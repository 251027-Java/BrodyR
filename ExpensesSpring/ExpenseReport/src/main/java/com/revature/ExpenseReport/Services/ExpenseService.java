package com.revature.ExpenseReport.Services;

import java.util.List;

import com.revature.ExpenseReport.Model.Expense;
import com.revature.ExpenseReport.Repository.ExpenseRepository;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository){
        this.repository = repository;
    }

    public List<Expense> getAllExpenses(){
        return repository.findAll();
    }

    public List<Expense> searchByMerchant(String merchant){
        return repository.findByMerchant(merchant);
    }
}
