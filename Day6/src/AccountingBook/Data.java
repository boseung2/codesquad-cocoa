package AccountingBook;

public class Data {

    private String summary;
    private int income;
    private int expense;

    public String getSummary() {
        return summary;
    }

    public int getIncome() {
        return income;
    }

    public int getExpense() {
        return expense;
    }

    public Data(String summary, int income, int expense) {
        this.summary = summary;
        this.income = income;
        this.expense = expense;
    }

    public void print(){
        System.out.println("적요 : " + getSummary());
        System.out.println("수입 : " + getIncome());
        System.out.println("지출 : " + getExpense());
        System.out.println("==================");
    }





}


















