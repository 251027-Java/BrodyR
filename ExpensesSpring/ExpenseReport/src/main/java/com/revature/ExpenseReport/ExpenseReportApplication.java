package com.revature.ExpenseReport;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.revature.ExpenseReport.Model.Expense;
import com.revature.ExpenseReport.Repository.ExpenseRepository;

@SpringBootApplication
public class ExpenseReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseReportApplication.class, args);
	}

	@Bean
	CommandLineRunner seedData (ExpenseRepository repository){
		return args -> {
			var e1 = new Expense(new Date(), 59.99, "Walmart");
			var e2 = new Expense(new Date(), 99.99, "Amazon");
			var e3 = new Expense(new Date(), 6.99, "Taco Bell");
		};
	}


}
