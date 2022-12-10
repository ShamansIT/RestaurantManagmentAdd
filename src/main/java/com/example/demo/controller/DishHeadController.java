package com.example.demo.controller;

import com.example.demo.data.Configs;
import com.example.demo.data.DataBaseProcessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DishHeadController extends Configs {
    private int id;
    private double price;
    private String name;
    private boolean isManager;
    private int tableNumber;
    public boolean isManager() {
        return isManager;
    }
    public void setManager(boolean manager) {
        isManager = manager;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }


    public DishHeadController() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Dish{id=" + this.id + ", price=" + this.price + ", name='" + this.name + '\'' + '}';
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
        setName(dishName);;
        setPrice(dishPrice);
        preparedStatement.close();
        connection.close();
    }

    public void listToOrder(){

        List<Integer> orderTo= new LinkedList<>();
        orderTo.add(11111);
        orderTo.add(22222);
        orderTo.add(33333);
        orderTo.add(44444);
        orderTo.add(55555);

        System.out.println(orderTo);




//        addFirst() / offerFirst(): добавляет элемент в начало списка
//
//        addLast() / offerLast(): добавляет элемент в конец списка
//
//        removeFirst() / pollFirst(): удаляет первый элемент из начала списка
//
//        removeLast() / pollLast(): удаляет последний элемент из конца списка
//
//        getFirst() / peekFirst(): получает первый элемент
//
//        getLast() / peekLast(): получает последний элемент


    }

}
