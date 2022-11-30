package com.example.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import com.example.demo.model.MenuDish;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
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
    private Button buttonAddToOrder;

    @FXML
    private Button buttonAmountMinus;

    @FXML
    private Button buttonAmountPlus;

    @FXML
    private Button buttonCheckOrderField;

    @FXML
    private Button buttonCloseTable;

    @FXML
    private Button buttonCompleteOrder;

    @FXML
    private Button buttonManager;

    @FXML
    private Button buttonRemoveLastFromList;

    @FXML
    private CheckBox checkLessFivePerson;

    @FXML
    private TextField menuFieldAmountDish;

    @FXML
    private Button switchToBreakfast;

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
    private ToggleButton toggleTable11;

    @FXML
    private ToggleButton toggleTable12;

    @FXML
    private ToggleButton toggleTable13;

    @FXML
    private ToggleButton toggleTable14;

    @FXML
    private ToggleButton toggleTable15;

    @FXML
    private ToggleButton toggleTable16;

    @FXML
    private ToggleButton toggleTable20;

    @FXML
    private ToggleButton toggleTable36;

    @FXML
    private ToggleButton toggleTable37;

    @FXML
    private ToggleButton toggleTable38;

    @FXML
    private ToggleButton toggleTable39;

    @FXML
    void initialize() {


        buttonAddDish1.setOnAction(actionEvent -> addDishToArray((short) 1));
        buttonAddDish2.setOnAction(actionEvent -> addDishToArray((short) 2));
        buttonAddDish3.setOnAction(actionEvent -> addDishToArray((short) 3));
        buttonAddDish4.setOnAction(actionEvent -> addDishToArray((short) 4));

        buttonAmountPlus.setOnAction(actionEvent -> {
            setAmountDishPlus(menuFieldAmountDish.getText());
            menuFieldAmountDish.setText(getAmountDish());
        });

        buttonAmountMinus.setOnAction(actionEvent -> {
            setAmountDishMinus(menuFieldAmountDish.getText());
            menuFieldAmountDish.setText(getAmountDish());
        });

        buttonAddToOrder.setOnAction(actionEvent ->{

            addToOrder();
            menuFieldAmountDish.setText(getAmountDish());
        });

//        buttonCompleteOrder.setOnAction();
//        buttonRadioMoreThanSixPerson.fire();
//        buttonRemoveLastFromList.setOnAction();





        MenuDish menuDish = new MenuDish();
        buttonCloseTable.setOnAction(actionEvent -> menuDish.SwitchButtonSceneCloseTable(buttonCloseTable));
        buttonManager.setOnAction(actionEvent -> menuDish.SwitchButtonSceneManager(buttonManager));
        switchToBreakfast.setOnAction(actionEvent -> menuDish. SwitchButtonSceneBreakfast(switchToBreakfast));
        switchToLunch.setOnAction(actionEvent -> menuDish.SwitchButtonSceneLunch(switchToLunch));
        switchToDinner.setOnAction(actionEvent -> menuDish.SwitchButtonSceneDinner(switchToDinner));
        switchToDrinks.setOnAction(actionEvent -> menuDish.SwitchButtonSceneDrinks(switchToDrinks));

    }
    //tips call like Service charge

}

