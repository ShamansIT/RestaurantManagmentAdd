package com.example.demo.data;

import java.sql.*;


public class DataBaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString  = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }
    public void signUpUser(String pin, String firstname, String lastname, String age, String gender,
                           String email, String phone, String address, String city, String country,
                           String ismanager, String pps){
        String insert = "INSERT INTO " + Const.USER_TABLE + "("
                + Const.USER_PIN + ","
                + Const.USER_FIRSTNAME + ","
                + Const.USER_LASTNAME + ","
                + Const.USER_AGE + ","
                + Const.USER_GENDER + ","
                + Const.USER_EMAIL + ","
                + Const.USER_PHONE + ","
                + Const.USER_ADDRESS + ","
                + Const.USER_CITY + ","
                + Const.USER_COUNTRY + ","
                + Const.USER_ISMANAGER + ","
                + Const.USER_PPS + ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,pin);
            prSt.setString(2,firstname);
            prSt.setString(3,lastname);
            prSt.setString(4,age);
            prSt.setString(5,gender);
            prSt.setString(6,email);
            prSt.setString(7,phone);
            prSt.setString(8,address);
            prSt.setString(9,city);
            prSt.setString(10,country);
            prSt.setString(11,ismanager);
            prSt.setString(12,pps);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}

