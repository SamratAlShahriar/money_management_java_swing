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
import shorna.moneymanagement.model.CategoryTotalModel;
import shorna.moneymanagement.model.MonthWiseSummary;
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
                        + AppConstant.colTransactionCategory + ", "
                        + AppConstant.colNote + ", " + AppConstant.colInsertTime + ") "
                        + "values(?,?,?,?,?,?,?)";

                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, transaction.getUserId());
                stmt.setString(2, transaction.getDate());
                stmt.setInt(3, transaction.getTransactionType());
                stmt.setDouble(4, transaction.getAmount());
                stmt.setString(5, transaction.getCategory());
                stmt.setString(6, transaction.getNote());
                stmt.setString(7, transaction.getInsertTime());

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

    public boolean updateTransaction(TransactionModel transaction) {
        try {
            if (transaction != null) {
                String query = "UPDATE " + AppConstant.tblTransaction
                        + " SET "
                        + AppConstant.colUserId + " = ? , " + AppConstant.colDate + " = ?, "
                        + AppConstant.colTransactionType + " = ?, " + AppConstant.colAmount + " = ?, "
                        + AppConstant.colTransactionCategory + " = ?, "
                        + AppConstant.colNote + " = ?, " + AppConstant.colInsertTime + " = ? "
                        + " WHERE " + AppConstant.colId + " = ? ";

                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, transaction.getUserId());
                stmt.setString(2, transaction.getDate());
                stmt.setInt(3, transaction.getTransactionType());
                stmt.setDouble(4, transaction.getAmount());
                stmt.setString(5, transaction.getCategory());
                stmt.setString(6, transaction.getNote());
                stmt.setString(7, transaction.getInsertTime());

                stmt.setInt(8, transaction.getId());

                int i = stmt.executeUpdate();
                System.out.println(i + " record updated");
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

    public boolean deleteTransaction(TransactionModel transaction) {
        try {
            if (transaction != null) {
                String query = " DELETE FROM " + AppConstant.tblTransaction
                        + " WHERE " + AppConstant.colId + " = ? ";

                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, transaction.getId());

                int i = stmt.executeUpdate();
                System.out.println(i + " record deleted");
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
                    + " ORDER BY " + AppConstant.colDate + " DESC "
                    + " , " + AppConstant.colInsertTime + " DESC ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);

            ResultSet resultSet = stmt.executeQuery();
            TransactionModel tm;
            while (resultSet.next()) {
                tm = new TransactionModel();
                tm.setId(resultSet.getInt(AppConstant.colId));
                tm.setUserId(resultSet.getInt(AppConstant.colUserId));
                tm.setTransactionType(resultSet.getInt(AppConstant.colTransactionType));
                tm.setCategory(resultSet.getString(AppConstant.colTransactionCategory));
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

    public List<TransactionModel> getAllIncomeTransactionList(int userId) {

        List<TransactionModel> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + AppConstant.tblTransaction
                    + " WHERE " + AppConstant.colUserId + " = ?  "
                    + " AND " + AppConstant.colTransactionType + " = ? "
                    + " ORDER BY " + AppConstant.colDate + " DESC "
                    + " , " + AppConstant.colInsertTime + " DESC ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setInt(2, 1);

            ResultSet resultSet = stmt.executeQuery();
            TransactionModel tm;
            while (resultSet.next()) {
                tm = new TransactionModel();
                tm.setId(resultSet.getInt(AppConstant.colId));
                tm.setUserId(resultSet.getInt(AppConstant.colUserId));
                tm.setTransactionType(resultSet.getInt(AppConstant.colTransactionType));
                tm.setCategory(resultSet.getString(AppConstant.colTransactionCategory));
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

    public List<TransactionModel> getAllExpenseTransactionList(int userId) {

        List<TransactionModel> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + AppConstant.tblTransaction
                    + " WHERE " + AppConstant.colUserId + " = ?  "
                    + " AND " + AppConstant.colTransactionType + " = ? "
                    + " ORDER BY " + AppConstant.colDate + " DESC "
                    + " , " + AppConstant.colInsertTime + " DESC ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setInt(2, 2);

            ResultSet resultSet = stmt.executeQuery();
            TransactionModel tm;
            while (resultSet.next()) {
                tm = new TransactionModel();
                tm.setId(resultSet.getInt(AppConstant.colId));
                tm.setUserId(resultSet.getInt(AppConstant.colUserId));
                tm.setTransactionType(resultSet.getInt(AppConstant.colTransactionType));
                tm.setCategory(resultSet.getString(AppConstant.colTransactionCategory));
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
        return model;
    }

    public List<MonthWiseSummary> getMonthWiseSummary(int userId, int type) {
        List<MonthWiseSummary> list = new ArrayList<>();
        try {

            String query = " SELECT "
                    + " sum(case when " + AppConstant.colTransactionType + " = ? then " + AppConstant.colAmount + " else 0 end) as total, "
                    + " MONTHNAME(" + AppConstant.colDate + ") "
                    + " FROM " + AppConstant.tblTransaction + " WHERE " + AppConstant.colUserId + " = ? "
                    + " GROUP BY MONTH(" + AppConstant.colDate + ")";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, type);
            stmt.setInt(2, userId);

            ResultSet resultSet = stmt.executeQuery();
            MonthWiseSummary model;
            while (resultSet.next()) {
                model = new MonthWiseSummary();
                model.setTotal(resultSet.getDouble(1));
                model.setMonth(resultSet.getString(2));
                list.add(model);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<CategoryTotalModel> getCategoryTotalList(int userId, int type, String startDate, String endDate) {
        List<CategoryTotalModel> list = new ArrayList<>();
        try {
            String query = "SELECT " + AppConstant.colTransactionCategory + ", "
                    + "SUM(" + AppConstant.colAmount + ") AS " + AppConstant.colAmount
                    + " FROM " + AppConstant.tblTransaction
                    + " WHERE " + AppConstant.colUserId + " = ?  "
                    + " AND " + AppConstant.colDate + " >= ? "
                    + " AND " + AppConstant.colDate + " <= ? "
                    + " AND " + AppConstant.colTransactionType + " = ? "
                    + " GROUP BY " + AppConstant.colTransactionCategory;

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setString(2, startDate);
            stmt.setString(3, endDate);
            stmt.setInt(4, type);

            ResultSet resultSet = stmt.executeQuery();
            CategoryTotalModel ctm;
            while (resultSet.next()) {
                ctm = new CategoryTotalModel();
                ctm.setCategory(resultSet.getString(AppConstant.colTransactionCategory));
                ctm.setAmount(resultSet.getDouble(AppConstant.colAmount));
                list.add(ctm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
