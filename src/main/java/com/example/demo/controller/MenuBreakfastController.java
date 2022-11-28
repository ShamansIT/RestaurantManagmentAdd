package com.example.demo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.model.MenuDish;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MenuBreakfastController extends MenuDish{

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button buttonAddDishBreakfast1;
    @FXML
    private Button buttonAddDishBreakfast2;
    @FXML
    private Button buttonAddDishBreakfast3;
    @FXML
    private Button buttonAddDishBreakfast4;
    @FXML
    private Button buttonCloseTable;
    @FXML
    private Button buttonCompleteOrder;
    @FXML
    private Button buttonManager;
    @FXML
    private RadioButton buttonRadioMoreThanSixPerson;
    @FXML
    private Button buttonRemoveLastFromList;
    @FXML
    private AnchorPane checkOrderField;
    @FXML
    private Text checkOrderText;
    @FXML
    private Button radioButtonTable11;
    @FXML
    private Button radioButtonTable12;
    @FXML
    private Button radioButtonTable13;
    @FXML
    private Button radioButtonTable14;
    @FXML
    private Button radioButtonTable15;
    @FXML
    private Button radioButtonTable16;
    @FXML
    private Button radioButtonTable20;
    @FXML
    private Button radioButtonTable36;
    @FXML
    private Button radioButtonTable37;
    @FXML
    private Button radioButtonTable38;
    @FXML
    private Button radioButtonTable39;
    @FXML
    private Button switchToDinner;
    @FXML
    private Button switchToDrinks;
    @FXML
    private Button switchToLunch;
    @FXML
    private Text textNumOfClient;
    @FXML
    private Text textOrderInfo;
    @FXML
    private Text textTableNumber;

    @FXML
    void initialize() {



        buttonAddDishBreakfast1.setOnAction(actionEvent -> addDishToArray((short) 1));
        buttonAddDishBreakfast2.setOnAction(actionEvent -> addDishToArray((short) 2));
        buttonAddDishBreakfast3.setOnAction(actionEvent -> addDishToArray((short) 3));
        buttonAddDishBreakfast4.setOnAction(actionEvent -> addDishToArray((short) 4));




//        buttonManager.setOnAction(actionEvent -> );
//        buttonCloseTable.setOnAction();
//        buttonCompleteOrder.setOnAction();
//        buttonRadioMoreThanSixPerson.fire();
//        buttonRemoveLastFromList.setOnAction();





    }

}

