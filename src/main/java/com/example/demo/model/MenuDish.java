package com.example.demo.model;

import com.example.demo.controller.MenuBreakfastController;
import com.example.demo.controller.SceneSwitchController;
import com.example.demo.data.DataBaseHandler;
import javafx.scene.control.Button;
import java.io.IOException;
import java.sql.SQLException;

public class MenuDish {

    private String amountDish;
    private String dishName;
    private int numberAmount;
    private int tableNumber;
    private double dishPrise;
    private double countLineDishPrice;
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
    public void setDishPrise(double dishPrise) {
        this.dishPrise = dishPrise;
    }

    public double getCountLineDishPrice() { return countLineDishPrice;}
    public void setCountLineDishPrice(double countLineDishPrice) {
        this.countLineDishPrice = countLineDishPrice;
    }

    public void setTableNumber(int tableNumber){
        this.tableNumber = tableNumber;
    }



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
