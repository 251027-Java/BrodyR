package com.revature.ExpenseReport.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.ExpenseReport.Model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, String> {
    List<Expense> findByMerchant(String merchant);
}