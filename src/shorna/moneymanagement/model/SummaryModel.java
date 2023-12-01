package shorna.moneymanagement.model;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */

public class SummaryModel {
    double totalIncome;
    double totalExpense;

    public SummaryModel() {
    }

    public SummaryModel(double totalIncome, double totalExpense) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }
}
