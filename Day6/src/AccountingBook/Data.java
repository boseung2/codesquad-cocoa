package AccountingBook;

public class Data {

    private String summary;
    private int income;
    private int expense;

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public String getSummary() {
        return summary;
    }

    public int getIncome() {
        return income;
    }

    public int getExpense() {
        return expense;
    }

    static boolean checkMonthDay(int month, int day) {
        if (month >= 1 && month <= 12 && day >= 1 && day <= 31) {
            return true;
        }
        return false;
    }

    public Data(){

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


















