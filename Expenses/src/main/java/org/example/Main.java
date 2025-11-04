package org.example;

import org.example.Repository.CSVRepository;
import org.example.Repository.IRepository;
import org.example.Repository.JSONRepository;
import org.example.Repository.TextRepository;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        System.out.println("Expense Tracker Starting...");
        Service service = new Service();
        System.out.println("Expensive Tracker Closing...");
    }
}