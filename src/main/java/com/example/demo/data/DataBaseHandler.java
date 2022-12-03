package com.example.demo.data;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;


public class DataBaseHandler extends Configs{

    public void DataBaseOrderConnection() {
        Connection connection = null;
        Statement statement;
        Driver driver;

        try {
            driver = new Driver() {
                @Override
                public Connection connect(String url, Properties info) throws SQLException {
                    return null;
                }
                @Override
                public boolean acceptsURL(String url) throws SQLException {
                    return false;
                }
                @Override
                public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                    return new DriverPropertyInfo[0];
                }
                @Override
                public int getMajorVersion() {
                    return 0;
                }
                @Override
                public int getMinorVersion() {
                    return 0;
                }
                @Override
                public boolean jdbcCompliant() {
                    return false;
                }
                @Override
                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    return null;
                }
            };
        } catch (Exception e) {
            System.out.println("DRIVER ERROR");
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            {
                statement.execute("INSERT INTO `demodata`.orders (orders_number, orders_table, orders_dish, orders_prise, orders_amount) VALUES ('2','2', 'dish', 2 , 2);");
            }
            System.out.println("code........");

        } catch (SQLException e) {
            System.out.println("SQL ERROR");
            throw new RuntimeException(e);
        }
//        finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    System.out.println("connection = null");
//                    throw new RuntimeException(e);
//                }
//            }
//        }
    }










//    public void signUpUser(String pin, String firstname, String lastname, String age, String gender,
//                           String email, String phone, String address, String city, String country,
//                           String ismanager, String pps){
//        String insert = "INSERT INTO " + Const.USER_TABLE + "("
//                + Const.USER_PIN + ","
//                + Const.USER_FIRSTNAME + ","
//                + Const.USER_LASTNAME + ","
//                + Const.USER_AGE + ","
//                + Const.USER_GENDER + ","
//                + Const.USER_EMAIL + ","
//                + Const.USER_PHONE + ","
//                + Const.USER_ADDRESS + ","
//                + Const.USER_CITY + ","
//                + Const.USER_COUNTRY + ","
//                + Const.USER_ISMANAGER + ","
//                + Const.USER_PPS + ")" +
//                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
//
//        try {
//            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
//            prSt.setString(1,pin);
//            prSt.setString(2,firstname);
//            prSt.setString(3,lastname);
//            prSt.setString(4,age);
//            prSt.setString(5,gender);
//            prSt.setString(6,email);
//            prSt.setString(7,phone);
//            prSt.setString(8,address);
//            prSt.setString(9,city);
//            prSt.setString(10,country);
//            prSt.setString(11,ismanager);
//            prSt.setString(12,pps);
//            prSt.executeUpdate();
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void orderUp(String number, String table, String dish, String prise, String amount){
//        String insert = "INSERT INTO " + Const.USER_ORDERS + "("
//                + Const.ORDER_NUMBER + ","
//                + Const.ORDER_TABLE + ","
//                + Const.ORDER_DISH + ","
//                + Const.ORDER_PRICE + ","
//                + Const.ORDER_AMOUNT + ")" +
//                "VALUES(?,?,?,?,?)";
//        try {
//            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
//            prSt.setString(1,number);
//            prSt.setString(2,table);
//            prSt.setString(3,dish);
//            prSt.setString(4,prise);
//            prSt.setString(5,amount);
//            prSt.executeUpdate();
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }


}

