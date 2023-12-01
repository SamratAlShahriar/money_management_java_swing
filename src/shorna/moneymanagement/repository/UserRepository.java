/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.repository;

import shorna.moneymanagement.model.UserModel;
import shorna.moneymanagement.service.UserService;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class UserRepository {
    UserService userService = new UserService();

    public boolean signup(UserModel model) {
        return userService.signup(model);
    }
    
    public UserModel login(String email, String password) {
        return userService.login(email, password);
    }

    public boolean  isUserAlreadyExist(String email){
        return  userService.isUserAlreadyExist(email);
    }
}
