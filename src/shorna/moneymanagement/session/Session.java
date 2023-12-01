/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.session;

import shorna.moneymanagement.model.UserModel;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class Session {

    static boolean isLoggedIn = false;

    private static UserModel userModel = null;

    public Session() {
         Session.userModel = null;
        isLoggedIn = false;
    }

     public Session(UserModel userModel) {
        Session.userModel = userModel;
        isLoggedIn = true;
    }

    static  public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    static  public UserModel getUserModel() {
        return userModel;
    }

}
