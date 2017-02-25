package com.twu.biblioteca.entity;

/**
 * Created by Qiaoying Zhao on 2017/2/24.
 */
public class UserEntity {
    private Integer id;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;

    private UserEntity(Integer id,String userName,String password,String phoneNumber,String email){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public UserEntity(Integer id,String userName,String password){
        this(id,userName,password,null,null);
    }

    public UserEntity(String userName,String password){
        this(null,userName,password,null,null);
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
