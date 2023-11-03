/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.model;

import java.util.Date;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class TransactionModel {

    int id;
    int userId;
    int transactionType;
    String date;
    double amount;
    String note;
    String insertTime;

    public TransactionModel() {
    }

    public TransactionModel(int id, int userId, int transactionType, String date, double amount, String note, String insertTime) {
        this.id = id;
        this.userId = userId;
        this.transactionType = transactionType;
        this.date = date;
        this.amount = amount;
        this.note = note;
        this.insertTime = insertTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

}
