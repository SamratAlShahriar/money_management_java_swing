/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class DbConnection {

    private static final String HOST = "jdbc:mysql://localhost:3306";
    private static final String DBNMAE = "money_management";
    private static final String URL = HOST + "/" + DBNMAE;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";


//    private static final String HOST = "jdbc:mysql://sql12.freesqldatabase.com:3306";
//    private static final String DBNMAE = "sql12219044";
//    private static final String URL = HOST + "/" + DBNMAE;
//    private static final String USERNAME = "sql12219044";
//    private static final String PASSWORD = "8G2WNrhrtz";
    
//    private static final String HOST = "jdbc:mysql://mrnax007.heliohost.org:3306";
//    private static final String DBNMAE = "mrnax007_lmsdb";
//    private static final String URL = HOST + "/" + DBNMAE;
//    private static final String USERNAME = "mrnax007_root";
//    private static final String PASSWORD = "00000";
    
//    private static final String HOST = "jdbc:mysql://sql12.freemysqlhosting.net:3306";
//    private static final String DBNMAE = "sql12219044";
//    private static final String URL = HOST + "/" + DBNMAE;
//    private static final String USERNAME = "sql12219044";
//    private static final String PASSWORD = "8G2WNrhrtz";
    
    
    
    
    private static Connection connection = null;
    
    
    public static Connection getConnection() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("::Connected::");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
