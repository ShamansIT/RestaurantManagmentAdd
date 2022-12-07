package com.example.demo.data;

import com.example.demo.model.MenuDish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.demo.data.Const.*;



public class DataBaseHandler extends Configs{
    private boolean globalIsManager;
    public boolean getGlobalIsManager() {
        return globalIsManager;
    }
    public void setGlobalIsManager(boolean globalIsManager) {
        this.globalIsManager = globalIsManager;
    }

    public int checkUserPin(int loginPin) throws SQLException{
        int checkPin = 0;

        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);

        String select = "SELECT * FROM demodata.userdata";
        PreparedStatement preparedStatement = connection.prepareStatement(select);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int pin = resultSet.getInt(1);
            String isManager = resultSet.getString(11);
            if (pin == loginPin){
                checkPin = 1;
                setGlobalIsManager(Boolean.parseBoolean(isManager));
            }
        }
        preparedStatement.close();
        connection.close();
        return checkPin;
    }


    public MenuDish addDish(int buttonGet, String groupDish) throws SQLException{
        MenuDish menuDish = new MenuDish();
        String dishName = "";
        double dishPrice = 0;

        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);
        String select = "SELECT * FROM demodata.dish WHERE id = "+ buttonGet +" AND typedish = " + "\'"+ groupDish + "\'";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            dishName = resultSet.getString(2);
            dishPrice = resultSet.getDouble(3);
        }
        
        menuDish.setDishName(dishName);
        menuDish.setDishPrise(dishPrice);
        preparedStatement.close();
        connection.close();
        return menuDish;
    }


    public void loadOrderDataSQL() throws SQLException {//rebuild
        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(ORDER_QUERY);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt(ORDER_NUMBER) +  " " +
                    resultSet.getString(ORDER_DISH));
        }
        preparedStatement.close();
        connection.close();
    }

    public void dumpOrderDataSQL(int orders_id, int orders_number, short orders_table, String orders_dish,
                        double orders_prise, short orders_amount) throws SQLException {
        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);

        String orderQuery = "INSERT INTO " + Const.ORDER_ID + "("
                + Const.ORDER_ID + ","
                + Const.ORDER_NUMBER + ","
                + Const.ORDER_TABLE + ","
                + Const.ORDER_DISH + ","
                + Const.ORDER_PRICE + ","
                + Const.ORDER_AMOUNT + ")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(orderQuery);
            ResultSet resultSet = preparedStatement.executeQuery(orderQuery);
            preparedStatement.setInt(2, 50);
            preparedStatement.setInt(3,55);
            preparedStatement.setString(4,"Wash dish");
            preparedStatement.setDouble(5,55.5);
            preparedStatement.setInt(6,60);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        connection.close();
    }












//        while(resultSet.next()){
//
//            int id = resultSet.getInt("Id");
//            String name = resultSet.getString("ProductName");
//            int price = resultSet.getInt("Price");
//
//            System.out.printf("%d. %s - %d \n", id, name, price);
//        }


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

