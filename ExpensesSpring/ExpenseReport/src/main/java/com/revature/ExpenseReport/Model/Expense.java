package com.revature.ExpenseReport.Model;

import jakarta.persistence.*;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id @GeneratedValue private String expenseId;
    @Column(name = "expenseMerchant") private String expenseMerchant;
    private LocalDate expenseDate;
    private BigDecimal expenseValue;

    @ManyToOne()
    @JoinColumn(name = "reportId")
    @ToString.Exclude
    private Report report;

    public Expense() {}

    public Expense(LocalDate date, BigDecimal value, String merchant){
        this.expenseDate = date;
        this.expenseValue = value;
        this.expenseMerchant = merchant;
    }

    public String getId() { return expenseId; }
    public LocalDate getDate() { return expenseDate; }
    public BigDecimal getValue() { return expenseValue; }
    public String getMerchant() { return expenseMerchant; }

    public void setId(String id) { this.expenseId = id; }
    public void setDate(LocalDate date) { this.expenseDate = date; }
    public void setValue(BigDecimal value) { this.expenseValue = value; }
    public void setMerchant(String merchant) { this.expenseMerchant = merchant; }
}
