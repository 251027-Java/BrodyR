package com.revature.ExpenseReport.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
public class Report {
    @Id @GeneratedValue private String reportId;
    private String reportTitle;
    private String reportStatus;

    @OneToMany
    private List<Expense> reportExpenses = new ArrayList<>();

    public Report(String title, String status){
        this.reportTitle = title;
        this.reportStatus = status;
    }

}
