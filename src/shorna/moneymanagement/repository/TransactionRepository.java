/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.repository;

import java.util.List;
import shorna.moneymanagement.model.CategoryTotalModel;
import shorna.moneymanagement.model.MonthWiseSummary;
import shorna.moneymanagement.model.SummaryModel;
import shorna.moneymanagement.model.TransactionModel;
import shorna.moneymanagement.service.TransactionService;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class TransactionRepository {

    TransactionService transactionService = new TransactionService();

    public boolean insertTransaction(TransactionModel model) {
        return transactionService.insertTransaction(model);
    }

    public boolean updateTransaction(TransactionModel transaction) {
        return transactionService.updateTransaction(transaction);
    }

    public boolean deleteTransaction(TransactionModel transaction) {
        return transactionService.deleteTransaction(transaction);
    }

    public List<TransactionModel> getAllTransactionList(int userId) {
        return transactionService.getAllTransactionList(userId);
    }

    public List<TransactionModel> getAllIncomeTransactionList(int userId) {
        return transactionService.getAllIncomeTransactionList(userId);
    }

    public List<TransactionModel> getAllExpenseTransactionList(int userId) {
        return transactionService.getAllExpenseTransactionList(userId);
    }

    public SummaryModel getSummary(int userId) {
        return transactionService.getSummary(userId);
    }

    public List<MonthWiseSummary> getMonthWiseSummary(int userId, int type) {
        return transactionService.getMonthWiseSummary(userId, type);
    }

    public List<CategoryTotalModel> getCategoryTotalList(int userId, int type, String startDate, String endDate) {
        return transactionService.getCategoryTotalList(userId, type, startDate, endDate);
    }

}
