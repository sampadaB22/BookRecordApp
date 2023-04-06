package com.example.bookrecordapp;

public class UserModel {
    public String UserName,UserEmail,UserPhone;




    public UserModel(String userName, String userEmail, String userPhone) {
        UserName = userName;
        UserEmail = userEmail;
        UserPhone = userPhone;
    }

    public String getUserName() {

        return UserName;
    }

    public void setUserName(String userName) {

        UserName = userName;
    }

    public String getUserEmail() {

        return UserEmail;
    }

    public void setUserEmail(String userEmail) {

        UserEmail = userEmail;
    }

    public String getUserPhone() {

        return UserPhone;
    }

    public void setUserPhone(String userPhone) {

        UserPhone = userPhone;
    }



}


