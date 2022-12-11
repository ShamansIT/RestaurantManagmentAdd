package com.example.demo.controller;

import com.example.demo.data.Configs;
import com.example.demo.data.Const;
import com.example.demo.data.DataBaseProcessor;
import com.example.demo.data.DataBaseService;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;

public class DishHeadController extends Configs {
    public DishHeadController() {}
    private int id;
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

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public double getTipsOver() { return tipsOver; }
    public void setTipsOver(double tipsOver) { this.tipsOver = tipsOver; }
    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public boolean isManager() {
        return isManager;
    }
    public void setManager(boolean manager) {
        isManager = manager;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPrice() { return this.price; }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOrderWindowText() { return orderWindowText; }
    public void setOrderWindowText(String orderWindowText) { this.orderWindowText = orderWindowText; }
    public int getNumberAmount() { return numberAmount; }
    public void setNumberAmount(int numberAmount) {
        this.numberAmount = numberAmount;
    }
    public String getAmountDish() { return amountDish; }
    public void setAmountDish(String amountDish) {
        this.amountDish = amountDish;
    }

    @Override
    public String toString() {
        return "DishHeadController{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", tableNumber=" + tableNumber +
                ", totalPrice=" + totalPrice +
                '}';
    }

    DataBaseService dataBaseService = new DataBaseService();
    DecimalFormat dF = new DecimalFormat( "##.##" );

    public double countTotalPrice(){

        double count = 0;
        count = Double.parseDouble(dF.format(Double.parseDouble(String.valueOf(getTotalPrice())) +
                (Double.parseDouble(String.valueOf(getPrice()))*getTipsOver())));
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
        preparedStatement.close();
        connection.close();
    }

    ArrayList<String> orderString= new ArrayList<>();
    public void prepareStringToList(){
        String format = prepareListToExport();
        orderString.add(format);
    }

    public String prepareListToExport(){
        DecimalFormat dF = new DecimalFormat( "##.##" );
        return "INSERT INTO "
                + Const.ORDER_NAME + " ("
                + Const.ORDER_ID + ", "
                + Const.ORDER_TABLE + ", "
                + Const.ORDER_DISH + ", "
                + Const.ORDER_PRICE + ", "
                + Const.ORDER_AMOUNT + ", "
                + Const.ORDER_COUNT + ", "
                + Const.ORDER_SERVICE + ") VALUES (" + "'"
                + orderId + "', '"
                + tableNumber + "', '"
                + name + "', '"
                + price + "', '"
                + amountDish + "', '"
                + dF.format( Double.parseDouble(getAmountDish()) * getPrice()) + "' ,'"
                + dF.format(Double.parseDouble(String.valueOf(getTotalPrice()))*getTipsOver()) + "');";
    }

    public void exportOrderToSQL() throws SQLException {
        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);

        connection.close();
    }

//    public void dumpOrderDataSQL(int orders_id, int orders_number, short orders_table, String orders_dish,
//                                 double orders_prise, short orders_amount) throws SQLException {
//        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
//        Connection connection = dataBaseProcessor.getConnection(URL,USERNAME,PASSWORD);
//
//        String orderQuery = "INSERT INTO "
//                + Const.ORDER_ID + "("
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
