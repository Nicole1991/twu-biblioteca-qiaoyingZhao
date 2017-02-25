package com.twu.biblioteca.controller;

import com.twu.biblioteca.service.UserService;
import com.twu.biblioteca.viewpage.View;

import java.util.Scanner;

/**
 * Created by Qiaoying Zhao on 2017/2/25.
 */
public class LoginController {
    public boolean login(String userName,String password){
        UserService userService = UserService.getInstance();
        boolean flag = userService.checkUser(userName,password);
        if (!flag){
            View.printPrompt("Sorry,Your username or password was wrong,please try again!");
        }
        return flag;
    }
}
