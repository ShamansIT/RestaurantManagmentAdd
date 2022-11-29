package com.example.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.demo.model.MenuDish;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

public class MenuBreakfastController extends MenuDish{


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAddDish1;

    @FXML
    private Button buttonAddDish2;

    @FXML
    private Button buttonAddDish3;

    @FXML
    private Button buttonAddDish4;

    @FXML
    private Button buttonCheckOrderField;

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



        buttonAddDish1.setOnAction(actionEvent -> addDishToArray((short) 1));
        buttonAddDish2.setOnAction(actionEvent -> addDishToArray((short) 2));
        buttonAddDish3.setOnAction(actionEvent -> addDishToArray((short) 3));
        buttonAddDish4.setOnAction(actionEvent -> addDishToArray((short) 4));





//        buttonCloseTable.setOnAction();
//        buttonCompleteOrder.setOnAction();
//        buttonRadioMoreThanSixPerson.fire();
//        buttonRemoveLastFromList.setOnAction();


        SceneSwitchController switchController = new SceneSwitchController();
        buttonManager.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneManager(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        switchToDinner.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuDinner(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        switchToLunch.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuLunch(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        switchToDrinks.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuDrinks(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}

