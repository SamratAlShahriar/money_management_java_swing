/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import shorna.moneymanagement.connection.DbConnection;
import shorna.moneymanagement.model.SummaryModel;
import shorna.moneymanagement.model.TransactionModel;
import shorna.moneymanagement.model.UserModel;
import shorna.moneymanagement.utils.AppConstant;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class TransactionService {

    Connection conn = DbConnection.getConnection();

    public boolean insertTransaction(TransactionModel transaction) {
        try {
            if (transaction != null) {
                String query = "INSERT INTO " + AppConstant.tblTransaction + "("
                        + AppConstant.colUserId + ", " + AppConstant.colDate + ", "
                        + AppConstant.colTransactionType + ", " + AppConstant.colAmount + ", "
                        + AppConstant.colNote + ", " + AppConstant.colInsertTime + ") "
                        + "values(?,?,?,?,?,?)";

                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, transaction.getUserId());
                stmt.setString(2, transaction.getDate());
                stmt.setInt(3, transaction.getTransactionType());
                stmt.setDouble(4, transaction.getAmount());
                stmt.setString(5, transaction.getNote());
                stmt.setString(6, transaction.getInsertTime());

                int i = stmt.executeUpdate();
                System.out.println(i + " record inserted");
                if (i > 0) {
                    return true;
                }
            }
            // con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<TransactionModel> getAllTransactionList(int userId) {

        List<TransactionModel> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + AppConstant.tblTransaction
                    + " WHERE " + AppConstant.colUserId + " = ?  "
                    +" ORDER BY "+AppConstant.colDate +" DESC "
                    +" , "+AppConstant.colInsertTime + " DESC ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);

            ResultSet resultSet = stmt.executeQuery();
            TransactionModel tm;
            while (resultSet.next()) {
                tm = new TransactionModel();
                tm.setId(resultSet.getInt(AppConstant.colId));
                tm.setUserId(resultSet.getInt(AppConstant.colUserId));
                tm.setTransactionType(resultSet.getInt(AppConstant.colTransactionType));
                tm.setAmount(resultSet.getDouble(AppConstant.colAmount));
                tm.setNote(resultSet.getString(AppConstant.colNote));
                tm.setDate(resultSet.getString(AppConstant.colDate));
                tm.setInsertTime(resultSet.getString(AppConstant.colInsertTime));
                list.add(tm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public SummaryModel getSummary(int userId) {
        SummaryModel model = new SummaryModel(0, 0);
        try {

            String query = " SELECT "
                    + " sum(case when " + AppConstant.colTransactionType + " = ? then " + AppConstant.colAmount + " else 0 end) as total_income, "
                    + " sum(case when " + AppConstant.colTransactionType + " = ? then " + AppConstant.colAmount + " else 0 end) as total_expense "
                    + " FROM " + AppConstant.tblTransaction + " WHERE " + AppConstant.colUserId + " = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, 1);
            stmt.setInt(2, 2);
            stmt.setInt(3, userId);

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                model.setTotalIncome(resultSet.getDouble(1));
                model.setTotalExpense(resultSet.getDouble(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  model;
    }
}
