/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.service;

import shorna.moneymanagement.connection.DbConnection;
import shorna.moneymanagement.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import shorna.moneymanagement.model.TransactionModel;
import shorna.moneymanagement.utils.AppConstant;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class UserService {

    Connection conn = DbConnection.getConnection();

    public boolean signup(UserModel user) {
        try {
            if (user != null) {
                String query = "INSERT INTO " + AppConstant.tblUser + "("
                        + AppConstant.colName + ", " + AppConstant.colEmail + ", "
                        + AppConstant.colPhoneNo + ", " + AppConstant.colPassword + ", "
                        + AppConstant.colInsertTime + ", " + AppConstant.colUpdateTime + ") "
                        + "values(?,?,?,?,?,?)";

                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getEmail());
                stmt.setString(3, user.getPhoneNo());
                stmt.setString(4, user.getPassword());
                stmt.setString(5, user.getInsertTime());
                stmt.setString(6, user.getUpdateTime());

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

    public UserModel login(String email, String password) {
        try {

            String query = "SELECT * FROM " + AppConstant.tblUser
                    + " WHERE " + AppConstant.colEmail + " = ? AND " + AppConstant.colPassword + " = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.first()) {
                UserModel um = new UserModel();
                um.setId(resultSet.getInt(AppConstant.colId));
                um.setEmail(resultSet.getString(AppConstant.colEmail));
                um.setName(resultSet.getString(AppConstant.colName));
                um.setPhoneNo(resultSet.getString(AppConstant.colPhoneNo));
                um.setInsertTime(resultSet.getString(AppConstant.colInsertTime));
                return um;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isUserAlreadyExist(String email) {
        try {

            String query = "SELECT * FROM " + AppConstant.tblUser
                    + " WHERE " + AppConstant.colEmail + " = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
