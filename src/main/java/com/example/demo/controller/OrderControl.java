package com.example.demo.controller;

import com.example.demo.data.Configs;
import com.example.demo.data.DataBaseProcessor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderControl extends Configs {
    private String amountDish;
    private String dishName;
    private int numberAmount;
    private int tableNumber;
    private double dishPrise;
    private double countDishPrice;
    private boolean isManager;
    private String lineOrderText;

    public String getLineOrderText() { return lineOrderText; }
    public void setLineOrderText(String lineOrderText) { this.lineOrderText = lineOrderText; }
    public boolean getIsManager() {
        return isManager;
    }
    public void setIsManager(boolean manager) {
        this.isManager = manager;
    }
    public String getAmountDish() {
        return amountDish;
    }
    public void setAmountDish(String amountDish) {
        this.amountDish = amountDish;
    }
    public String getDishName() {
        return dishName;
    }
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    public int getNumberAmount() {
        return numberAmount;
    }
    public void setNumberAmount(int numberAmount) {
        this.numberAmount = numberAmount;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public double getDishPrise() {
        return dishPrise;
    }
    public void setDishPrise(double dishPrise) { this.dishPrise = dishPrise; }
    public double getCountDishPrice() { return countDishPrice;}
    public void setCountDishPrice(double countDishPrice) { this.countDishPrice = countDishPrice; }
    public void setTableNumber(int tableNumber){
        this.tableNumber = tableNumber;
    }






}
