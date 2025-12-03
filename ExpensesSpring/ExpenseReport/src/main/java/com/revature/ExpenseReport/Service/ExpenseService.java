package com.revature.ExpenseReport.Service;

import com.revature.ExpenseReport.Controller.ExpenseDTO;
import com.revature.ExpenseReport.Controller.ExpenseWOIDDTO;
import com.revature.ExpenseReport.Model.Expense;
import com.revature.ExpenseReport.Repository.ExpenseRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService (ExpenseRepository repository){
        this.repository = repository;
    }

    public List<ExpenseDTO> getAllExpenses() {
        return repository.findAll().stream().map(this::ExpenseToDto).toList();
    }

    public List<ExpenseDTO> searchByExpenseMerchant(String merchant) {
        return repository.findByExpenseMerchant(merchant).stream().map(this::ExpenseToDto).toList();
    }

    public ExpenseDTO getById(String id){
        return ExpenseToDto(repository.findById(id).get());
    }

    public ExpenseDTO create(ExpenseWOIDDTO dto){
        Expense entity = new Expense(dto.expenseDate(), dto.expenseValue(), dto.expenseMerchant());
        return ExpenseToDto(repository.save(entity));
    }

    public ExpenseDTO update(String id, ExpenseDTO dto){
        Expense expense = repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        expense.setDate(dto.expenseDate());
        expense.setValue(dto.expenseValue());
        expense.setMerchant(dto.expenseMerchant());
        
        return ExpenseToDto(repository.save(expense));
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    private ExpenseDTO ExpenseToDto(Expense expense){
        return new ExpenseDTO(expense.getId(), expense.getDate(), expense.getValue(), expense.getMerchant());
    }
}
