package com.example.demo.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishLoader extends Configs {
    private int id;
    private double price;
    private String name;

    public DishLoader() {
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

}
