package com.revature.ExpenseReport.Controller;

import com.revature.ExpenseReport.Service.ExpenseService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<ExpenseDTO> getAllExpenses() {
        return service.getAllExpenses();
    }

    @GetMapping("/search")
    public List<ExpenseDTO> search(@RequestParam String merchant) {
        return service.searchByExpenseMerchant(merchant);
    }

    @PostMapping
    public ExpenseDTO create(@RequestBody ExpenseWOIDDTO expensedto){
        return service.create(expensedto);
    }

    @GetMapping("/{id}")
    public ExpenseDTO getById(@PathVariable String id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ExpenseDTO update(@PathVariable String id, @RequestBody ExpenseDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
