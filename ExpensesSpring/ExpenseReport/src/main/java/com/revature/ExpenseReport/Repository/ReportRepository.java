package com.revature.ExpenseReport.Repository;

import com.revature.ExpenseReport.Model.Report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, String> {
    List<Report> findByReportTitle(String title);
}