package com.revature.ExpenseReport.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ExpenseReport.Model.Expense;
import com.revature.ExpenseReport.Services.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;
    
    public ExpenseController(ExpenseService service){
        this.service = service;
    }

    @GetMapping
    public List<Expense> getAllExpenses(){
        return service.getAllExpenses();
    }

    @GetMapping("/search")
    public List<Expense> search(@RequestParam String merchant){
        return service.searchByMerchant(merchant);
    }

}
