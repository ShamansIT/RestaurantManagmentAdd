package com.example.demo.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseHandler {

    public int checkUserPin(int loginPin) throws SQLException{
        int checkPin = 0;

        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(Const.URL, Const.USERNAME,Const.PASSWORD);
        String select = "SELECT * FROM demodata.userdata";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            int pin = resultSet.getInt(1);
            String isManager = resultSet.getString(11);
            if (pin == loginPin){
                checkPin = 1;
                //setGlobalIsManager(Boolean.parseBoolean(isManager));
                //link to class
            }
        }
        preparedStatement.close();
        connection.close();
        return checkPin;
    }


//        public void checkIsManager( ) throws SQLException{
//
//        boolean isManager = false;
//        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
//        Connection connection = dataBaseProcessor.getConnection(Const.URL, Const.USERNAME,Const.PASSWORD);
//        String select = "SELECT * FROM demodata.userdata";
//        PreparedStatement preparedStatement = connection.prepareStatement(select);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        while(resultSet.next()){
//           isManager = Boolean.parseBoolean(resultSet.getString(11));
//        }
//        setIsManager(isManager);
//        preparedStatement.close();
//        connection.close();
//        return oc;
//    }
//
//
//    public void loadOrderDataSQL() throws SQLException {//rebuild
//        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
//        Connection connection = dataBaseProcessor.getConnection(Const.URL, Const.USERNAME,Const.PASSWORD);
//        PreparedStatement preparedStatement = connection.prepareStatement(ORDER_QUERY);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while(resultSet.next()){
//            System.out.println(resultSet.getInt(ORDER_NUMBER) +  " " +
//                    resultSet.getString(ORDER_DISH));
//        }
//        preparedStatement.close();
//        connection.close();
//    }
//
//    public void dumpOrderDataSQL(int orders_id, int orders_number, short orders_table, String orders_dish,
//                        double orders_prise, short orders_amount) throws SQLException {
//        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
//        Connection connection = dataBaseProcessor.getConnection(Const.URL, Const.USERNAME,Const.PASSWORD);
//
//        String orderQuery = "INSERT INTO " + Const.ORDER_ID + "("
//                + Const.ORDER_ID + ","
//                + Const.ORDER_NUMBER + ","
//                + Const.ORDER_TABLE + ","
//                + Const.ORDER_DISH + ","
//                + Const.ORDER_PRICE + ","
//                + Const.ORDER_AMOUNT + ")" +
//                "VALUES(?,?,?,?,?,?)";
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(orderQuery);
//            ResultSet resultSet = preparedStatement.executeQuery(orderQuery);
//            preparedStatement.setInt(2, 50);
//            preparedStatement.setInt(3,55);
//            preparedStatement.setString(4,"Wash dish");
//            preparedStatement.setDouble(5,55.5);
//            preparedStatement.setInt(6,60);
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        connection.close();
//    }



}

