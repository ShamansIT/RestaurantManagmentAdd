package com.example.demo.model;


import com.example.demo.controller.SceneSwitchController;
import javafx.scene.control.Button;

import java.io.IOException;

public class MenuDish {

    private short tableNumber;
    private short dishNumber;
    private double dishPrise;
    private double totalCountTable;

    public String getAmountDish() {
        return amountDish;
    }

    public void setAmountDish(String amountDish) {
        this.amountDish = amountDish;
    }

    public int getNumberAmount() {
        return numberAmount;
    }

    public void setNumberAmount(int numberAmount) {
        this.numberAmount = numberAmount;
    }

    private String amountDish;
    private int numberAmount;


    public short getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(short tableNumber) {
        this.tableNumber = tableNumber;
    }

    public short getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(short dishNumber) {
        this.dishNumber = dishNumber;
    }

    private void totalOrderCount(){ }
    public void addDishToArray(short dishNumber){
        System.out.println(dishNumber);
    }

    public void removeLastDishFromArray(){}

    public void loadToList(){}

    public void loadTableInfo(){}

    public void addTipsOverSexPerson(){

    }

    public void closeTable(){}
    public void printOrderDetail(){}

    public void addToOrder(){

        setAmountDish("1");
    }

    public void setAmountDishPlus(String menuFieldAmountDish){
            numberAmount = Integer.parseInt(menuFieldAmountDish);
            numberAmount ++;
            amountDish = Integer.toString(numberAmount);
            setAmountDish(String.valueOf(numberAmount));
    }
    public void setAmountDishMinus(String menuFieldAmountDish){
        numberAmount = Integer.parseInt(menuFieldAmountDish);
        if (numberAmount > 1) numberAmount --;
        amountDish = Integer.toString(numberAmount);
        setAmountDish(String.valueOf(numberAmount));
    }


    public void SwitchButtonSceneManager(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneManager(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void SwitchButtonSceneBreakfast(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuBreakfast(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void SwitchButtonSceneLunch(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuLunch(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void SwitchButtonSceneDinner(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuDinner(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void SwitchButtonSceneDrinks(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuDrinks(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void SwitchButtonSceneCloseTable(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToScenePayment(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }









}
