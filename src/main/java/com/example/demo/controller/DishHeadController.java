package com.example.demo.controller;

import com.example.demo.data.Configs;
import com.example.demo.data.Const;
import com.example.demo.data.DataBaseProcessor;
import com.example.demo.data.DataBaseService;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;

public class DishHeadController extends Configs {

    private double price;
    private String name;
    private boolean isManager;
    private int tableNumber;
    private double totalPrice = 0.0;
    private int numberAmount=1;
    private String amountDish = "1";
    private String orderWindowText = "";
    private double tipsOver = 0;
    private int orderId = 1;
    private boolean isService = false;
    public DishHeadController() {}
    public boolean getIsService() {
        return isService;
    }
    public void setIsService(boolean service) {
        isService = service;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean getIsManager() {
        return isManager;
    }
    public void setIsManager(boolean manager) {
        isManager = manager;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getNumberAmount() {
        return numberAmount;
    }
    public void setNumberAmount(int numberAmount) {
        this.numberAmount = numberAmount;
    }
    public String getAmountDish() {
        return amountDish;
    }
    public void setAmountDish(String amountDish) {
        this.amountDish = amountDish;
    }
    public String getOrderWindowText() {
        return orderWindowText;
    }
    public void setOrderWindowText(String orderWindowText) {
        this.orderWindowText = orderWindowText;
    }
    public double getTipsOver() {
        return tipsOver;
    }
    public void setTipsOver(double tipsOver) {
        this.tipsOver = tipsOver;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "DishHeadController{" +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", isManager=" + isManager +
                ", tableNumber=" + tableNumber +
                ", totalPrice=" + totalPrice +
                ", numberAmount=" + numberAmount +
                ", amountDish='" + amountDish + '\'' +
                ", orderWindowText='" + orderWindowText + '\'' +
                ", tipsOver=" + tipsOver +
                ", orderId=" + orderId +
                ", isService=" + isService +
                '}';
    }

    DataBaseService dataBaseService = new DataBaseService();
    DecimalFormat dF = new DecimalFormat( "##.##" );

    public double countTotalPrice(){
        double count = 0;
        count = getTotalPrice() + getPrice()*getNumberAmount() + getPrice()*getNumberAmount()*getTipsOver();
        return count;
    }

    public String setPreviewOrderText(){
        String text = "";
        text = getName() +  "   >>>   " + getPrice() + " €" + " x " +getAmountDish()
                + " qt.   >>>   Total: " + dF.format(Double.parseDouble(getAmountDish()) * getPrice()) + " €";
        return text;
    }

    public String setPreviewWindowText(){
        String text = "";
        text =  getName() + "\n"
                + getPrice() + " €" + "  x  " +getAmountDish() + " qt.   ->   "
                + dF.format(Double.parseDouble(getAmountDish()) * getPrice()) + " €" + "\n\n";
        return text;
    }

    public String setTotalPriceText(){
        String text = "";
        text = "TOTAL PRICE: " +  dF.format(Double.parseDouble(String.valueOf(getTotalPrice())))+ " €";
        return text;
    }

    public String setTotalPricePlusTips(){
        String text = "";
        text = "TOTAL PRICE: " +  dF.format(Double.parseDouble(String.valueOf(getTotalPrice()))+
                (Double.parseDouble(String.valueOf(getTotalPrice()))*getTipsOver())) + " €";
        return text;
    }

    public String setTips(){
        String text = "";
        text = "SERVICE: " +  dF.format(Double.parseDouble(String.valueOf(getTotalPrice()))
                        * getTipsOver()) + " €";
        return text;
    }

    public void loadDishLine(int dishNum, String groupDish) throws SQLException {
        String dishName = "";
        double dishPrice = 0;
        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);
        String select = "SELECT * FROM demodata.dish WHERE id = "+ dishNum +
                " AND typedish = " + "\'"+ groupDish + "\'";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            dishName = resultSet.getString(2);
            dishPrice = resultSet.getDouble(3);
        }
        setName(dishName);
        setPrice(dishPrice);
        System.out.println(dishName);
        preparedStatement.close();
        connection.close();
    }

    ArrayList<String> orderString= new ArrayList<>();
    public void prepareOrderStringToList(){
        String format = prepareOrderListToExport();
        orderString.add(format);
    }

    public void prepareOrderEndStringToList(){
        String format = prepareOrderLineCloseOrder();
        orderString.add(format);
    }

    public void clearOrderStringToList(){
        orderString.clear();
    }

    public String prepareOrderListToExport(){
        return  "("+ "'"
                + orderId + "', '"
                + tableNumber + "', '"
                + name + "', '"
                + price + "', '"
                + amountDish + "', '"
                + dF.format( Double.parseDouble(getAmountDish()) * getPrice()) + "', '"
                + "null" + "');";
    }

    public String prepareOrderLineCloseOrder(){
        return  " (" + "'"
                + orderId + "', '"
                + tableNumber + "', '"
                + "END" + "', '"
                + "0"+ "', '"
                + "0" + "', '"
                + dF.format(totalPrice)  + "', '"
                + isService + "');";
    }

    public void exportOrderToSQL() throws SQLException {
        String orderQuery = "";
        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);
        for (String s : orderString) {
            orderQuery = "INSERT INTO "
                    + Const.ORDER_NAME +
                    "(" + Const.ORDER_ID + ", "
                    + Const.ORDER_TABLE + ", "
                    + Const.ORDER_DISH + ", "
                    + Const.ORDER_PRICE + ", "
                    + Const.ORDER_AMOUNT + ", "
                    + Const.ORDER_COUNT + ", "
                    + Const.ORDER_SERVICE + ") VALUES"  + s;
            PreparedStatement preparedStatement = connection.prepareStatement(orderQuery);
            preparedStatement.executeUpdate(orderQuery);
            preparedStatement.close();
        }
        connection.close();
        clearOrderStringToList();
        setOrderId(getOrderId()+1);
    }

    public void exportReportToSQL() throws SQLException {
        String orderQuery = "";
        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);
        for (String s : orderString) {
            orderQuery = "DROP TABLE IF EXISTS `transfer`; "
                    + "INSERT INTO "
                    + Const.REPORT_NAME +
                    "(" + Const.REPORT_ID + ", "
                    + Const.REPORT_TABLE + ", "
                    + Const.REPORT_DISH + ", "
                    + Const.REPORT_PRICE + ", "
                    + Const.REPORT_AMOUNT + ", "
                    + Const.REPORT_COUNT + ", "
                    + Const.REPORT_SERVICE + ") VALUES"  + s;
            PreparedStatement preparedStatement = connection.prepareStatement(orderQuery);
            preparedStatement.executeUpdate(orderQuery);
            preparedStatement.close();
        }
        connection.close();
    }


    public void loadTransferToSQL() throws SQLException {
        String orderQuery = "";
        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);
        for (String s : orderString) {
            orderQuery = "INSERT INTO "
                    + Const.TRANSFER_NAME
                    + " (" + Const.TRANSFER_ORDER_ID + ", "
                    + Const.TRANSFER_TABLE + ", "
                    + Const.TRANSFER_TOTAL_ORDER + ", "
                    + Const.TRANSFER_NUMBER + ", "
                    + Const.TRANSFER_IS_SERVICE + ", "
                    + Const.TRANSFER_ORDER_TEXT + ")"
                    + " VALUES"
                    + " (" + "'"
                    + orderId + "', '"
                    + tableNumber + "', '"
                    + dF.format(totalPrice)  + "', '"
                    + orderId + "', '"
                    + isService + "', '"
                    + orderWindowText + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(orderQuery);
            preparedStatement.executeUpdate(orderQuery);
            preparedStatement.close();
        }
        connection.close();
    }

    public void loadTransferOrder() throws SQLException {
        int id = 0;
        int table = 0;
        double totalOrder = 0;
        int number = 0;
        boolean isService = false;
        String orderText = "";

        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);

        String select = "SELECT * FROM " + Const.TRANSFER_NAME;

        PreparedStatement preparedStatement = connection.prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            id = resultSet.getInt(1);
            table = resultSet.getInt(2);
            totalOrder = resultSet.getDouble(3);
            number = resultSet.getInt(4);
            orderText = resultSet.getString(6);
        }
        setOrderId(id);
        setTableNumber(table);
        setTotalPrice(totalOrder);
        setOrderWindowText(orderText);
        preparedStatement.close();
        connection.close();

    }


    public void dropTransferSQL() throws SQLException {
        //redesign require
        String orderQuery = "DROP TABLE IF EXISTS `transfer`;\n" +
                "CREATE TABLE `demodata`.`transfer` \n" +
                "(\n" +
                "  `transfer_order_id` INT NOT NULL,\n" +
                "  `transfer_table` INT NOT NULL,  \n" +
                "  `transfer_total_order` DOUBLE NOT NULL,\n" +
                "  `transfer_number` INT NOT NULL,\n" +
                "  `transfer_is_service` VARCHAR(5) DEFAULT 'true',\n" +
                "  `transfer_order_text` VARCHAR(350),\n" +
                "  CONSTRAINT `transfer_is_service` CHECK ((`transfer_is_service` in ('true','false'))),\n" +
                "  PRIMARY KEY (`transfer_order_id`)\n" +
                " );";
        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(orderQuery);
        preparedStatement.executeUpdate(orderQuery);
        preparedStatement.close();
        connection.close();
        }

}
