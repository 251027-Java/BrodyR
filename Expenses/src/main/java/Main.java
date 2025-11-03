import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {


    static void main() {
        System.out.println("Expense Tracker Starting...");
        System.out.println("Creating a test expense:");
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(1, new Date(), 99.95, "Walmart"));
        expenses.add(new Expense(2, new Date(), 85.75, "Costco"));
        expenses.add(new Expense(3, new Date(), 10000, "Private Jet"));
        System.out.println(expenses);
        System.out.println("Expensive Tracker Closing...");
    }
}
