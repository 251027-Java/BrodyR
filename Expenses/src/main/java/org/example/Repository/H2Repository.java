package org.example.Repository;

import org.example.Expense;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;

public class H2Repository implements IRepository{
    private static final String H2_URL = "jdbc:h2:mem:expenses;DB_CLOSE_DELAY=-1";
    private Connection connection;

    public H2Repository() throws SQLException{
        try{
            connection = DriverManager.getConnection(H2_URL);
            try (Statement stmt = connection.createStatement()) {
                String sql =
                        "CREATE SCHEMA IF NOT EXISTS ExpenseReport;" +
                        "CREATE TABLE IF NOT EXISTS ExpenseReport.Expenses (" +
                        "id INT PRIMARY KEY," +
                        "date TIMESTAMP NOT NULL," +
                        "price FLOAT CHECK (price > 0)," +
                        "merchant VARCHAR(50) NOT NULL" +
                        ");";
                stmt.execute(sql);
                System.out.println("Successful creation of H2 database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createExpense(Expense expense) {
        String sql =
                "INSERT INTO ExpenseReport.Expenses (id, date, price, merchant)" +
                "VALUES ( ?, ?, ?, ?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, expense.getID());
            stmt.setTimestamp(2, new java.sql.Timestamp(expense.getDate().getTime()));
            stmt.setDouble(3, expense.getValue());
            stmt.setString(4, expense.getMerchant());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Expense readExpense(int id) {
        String sql =
                "SELECT * FROM ExpenseReport.Expenses WHERE Expenses.id = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Expense expense = new Expense(
                        rs.getInt("id"),
                        new java.util.Date(rs.getTimestamp("date").getTime()),
                        rs.getDouble("price"),
                        rs.getString("merchant")
                );
                return expense;
            }
            System.out.println("No expense with that ID");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateExpense(Expense expense) {

    }

    @Override
    public void deleteExpense(int id) {
        if (readExpense(id) == null){ return; }
        String sql =
                "DELETE FROM ExpenseReport.Expenses WHERE Expenses.id = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Expense> loadExpenses() {
        List<Expense> ret = new ArrayList<>();
        String sql = "SELECT * FROM ExpenseReport.Expenses";
        try (Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()){
                Expense expense = new Expense(
                        rs.getInt("id"),
                        new java.util.Date(rs.getTimestamp("date").getTime()),
                        rs.getDouble("price"),
                        rs.getString("merchant")
                );
                ret.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public void saveExpenses(List<Expense> expenses) {

    }

    @Override
    public void clearRepo() {
        try (Statement stmt = connection.createStatement()) {
            String sql = "TRUNCATE TABLE ExpenseReport.Expenses";
            stmt.execute(sql);
        } catch (SQLException e) {e.printStackTrace();}
    }
}
