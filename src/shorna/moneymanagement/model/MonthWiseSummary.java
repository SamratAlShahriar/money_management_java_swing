/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.model;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class MonthWiseSummary {

    String month;
    double total;

    public MonthWiseSummary() {
    }

    public MonthWiseSummary(String month, double total) {
        this.month = month;
        this.total = total;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
