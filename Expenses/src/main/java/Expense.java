import java.util.Date;

public class Expense {
    private int id;
    private Date date;
    private double value;
    private String merchant;

    public Expense(int id, Date date, double value, String merchant){
        this.id = id;
        this.date = date;
        this.value = value;
        this.merchant = merchant;
    }

    @Override
    public String toString(){
        return "Expense [id=" + this.id + ", date=" + this.date + ", value=" + this.value + ", merchant=" + this.merchant + "]";
    }
}
