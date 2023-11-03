/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.repository;

import java.util.List;
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

    public List<TransactionModel> getAllTransactionList(int userId) {
        return transactionService.getAllTransactionList(userId);
    }

    public SummaryModel getSummary(int userId) {
        return transactionService.getSummary(userId);
    }

}
