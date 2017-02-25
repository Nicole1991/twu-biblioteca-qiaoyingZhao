package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qiaoying Zhao on 2017/2/24.
 */
public class UserService {
    private static UserService userService = null;

    public static UserService getInstance(){
        if (userService == null){
            return new UserService();
        }
        return new UserService();
    }

    private static List<UserEntity> userList = new ArrayList<UserEntity>();

    public void init(){
        userList.add(new UserEntity(1,"Nicole Zhao","123456"));
        userList.add(new UserEntity(2,"Anand Beck","123456"));
        userList.add(new UserEntity(3,"Yaxuan Evans","123456"));
        userList.add(new UserEntity(4,"Judy Li","123456"));
        userList.add(new UserEntity(5,"Frank Smith","123456"));
    }

    public boolean checkUser(String userName,String password) {
        boolean checkFlag = false;
        String inputUserName;
        String inputPassword;
        inputUserName = userName == null?"":userName;
        inputPassword = password == null?null:password;
        for (UserEntity users:userList){
            if (inputUserName.equals(users.getUserName()) && inputPassword.equals(users.getPassword())) {
                checkFlag = true;
                break;
            }else
                checkFlag = false;
        }
        return checkFlag;
    }

    private UserService(){
        init();
    }
}
