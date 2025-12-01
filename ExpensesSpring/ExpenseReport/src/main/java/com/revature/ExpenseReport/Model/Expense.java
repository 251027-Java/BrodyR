package com.revature.ExpenseReport.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Expense {
    @Id
    @GeneratedValue
    String id;

    private Date date;
    private double value;
    private String merchant;

    public Expense(){}

    public Expense(Date date, double value, String merchant){
        this.date = date;
        this.value = value;
        this.merchant = merchant;
    }

}
