package org.example.Repository;

import org.example.Expense;

import java.util.List;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoRepository implements IRepository{
    private static final String connectionString = "mongodb://mongoadmin:secret@localhost:27017";
    private final MongoCollection<Document> expensesCollection;

    public MongoRepository(){
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("expensesdb");
        this.expensesCollection = database.getCollection("expenses");
        System.out.println("Connected to MongoDB");
    }

    private Expense documentToExpense(Document doc){
        return new Expense(doc.getInteger("_id"),
            doc.getDate("date"),
            doc.getDouble("value"),
            doc.getString("merchant"));
    }

    private Document expenseToDocument(Expense expense){
        return new Document("_id", expense.getID())
            .append("date", expense.getDate())
            .append("value", expense.getValue())
            .append("merchant", expense.getMerchant());
    }

    @Override
    public void createExpense(Expense expense) {
        Document insert = expenseToDocument(expense);
        expensesCollection.insertOne(insert);
    }

    @Override
    public Expense readExpense(int id) {
        Document document = expensesCollection.find(Filters.eq("_id", id)).first();
        return (document != null) ? documentToExpense(document) : null;
    }

    @Override
    public void updateExpense(Expense expense) {
        Document document = expenseToDocument(expense);
        if(this.readExpense(expense.getID()) == null){
            this.createExpense(expense);
        } else {
            expensesCollection.updateOne(Filters.eq("_id", expense.getID()), document);
        }  
    }

    @Override
    public void deleteExpense(int id) {
        expensesCollection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        for(Document current : expensesCollection.find()){
            expenses.add(documentToExpense(current));
        }
        return expenses;
    }

    @Override
    public void saveExpenses(List<Expense> expenses) {
        for(Expense e : expenses){
            this.updateExpense(e);
        }
    }

    @Override
    public void clearRepo() {
        expensesCollection.deleteMany(new Document());
    }
}
