package com.example.demo.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo.data.DataBaseHandler;
import com.example.demo.model.MenuDish;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class MenuBreakfastController implements SceneSwitch {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleButton addDish1;

    @FXML
    private ToggleButton addDish2;

    @FXML
    private ToggleButton addDish3;

    @FXML
    private ToggleButton addDish4;

    @FXML
    private ToggleButton addDish5;

    @FXML
    private ToggleButton addDish6;

    @FXML
    private ToggleButton addDish7;

    @FXML
    private ToggleButton addDish8;

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
    private TextField menuPreviewOrder;

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
    private void showError(String error){
        buttonCheckOrderField.setVisible(true);
        buttonCheckOrderField.setText(error);
        buttonCheckOrderField.setVisible(true);
    }
    private void hideError(){
        buttonCheckOrderField.setVisible(false);
        buttonCheckOrderField.setVisible(false);
    }

    public double getCountDishPrise() {
        return countDishPrise;
    }

    public void setCountDishPrise(double countDishPrise) {
        this.countDishPrise = countDishPrise;
    }

    private MenuDish menuDish;
    private double countDishPrise;
    protected String dishPreviewText = "";
    @Override
    public String toString() {
        return "MenuBreakfastController{" +
                "dishPreviewText='" + dishPreviewText + '\'' +
                ", countDishPrise=" + countDishPrise +
                '}';
    }

    @FXML
    void initialize() {

        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        ToggleGroup toggleTable = new ToggleGroup();
        toggleTable11.setToggleGroup(toggleTable);
        toggleTable12.setToggleGroup(toggleTable);
        toggleTable13.setToggleGroup(toggleTable);
        toggleTable14.setToggleGroup(toggleTable);
        toggleTable15.setToggleGroup(toggleTable);
        toggleTable16.setToggleGroup(toggleTable);
        toggleTable20.setToggleGroup(toggleTable);
        toggleTable36.setToggleGroup(toggleTable);
        toggleTable37.setToggleGroup(toggleTable);
        toggleTable38.setToggleGroup(toggleTable);
        toggleTable39.setToggleGroup(toggleTable);

        toggleTable11.setOnAction(actionEvent ->{ menuDish.setTableNumber(11); });
        toggleTable12.setOnAction(actionEvent ->{ menuDish.setTableNumber(12); });
        toggleTable13.setOnAction(actionEvent ->{ menuDish.setTableNumber(13); });
        toggleTable14.setOnAction(actionEvent ->{ menuDish.setTableNumber(14); });
        toggleTable15.setOnAction(actionEvent ->{ menuDish.setTableNumber(15); });
        toggleTable16.setOnAction(actionEvent ->{ menuDish.setTableNumber(16); });
        toggleTable20.setOnAction(actionEvent ->{ menuDish.setTableNumber(20); });
        toggleTable36.setOnAction(actionEvent ->{ menuDish.setTableNumber(36); });
        toggleTable37.setOnAction(actionEvent ->{ menuDish.setTableNumber(37); });
        toggleTable38.setOnAction(actionEvent ->{ menuDish.setTableNumber(38); });
        toggleTable39.setOnAction(actionEvent ->{ menuDish.setTableNumber(39); });

        ToggleGroup addDish = new ToggleGroup();
        addDish1.setToggleGroup(addDish);
        addDish2.setToggleGroup(addDish);
        addDish3.setToggleGroup(addDish);
        addDish4.setToggleGroup(addDish);
        addDish5.setToggleGroup(addDish);
        addDish6.setToggleGroup(addDish);
        addDish7.setToggleGroup(addDish);
        addDish8.setToggleGroup(addDish);

        addDish1.setOnAction(actionEvent ->{
            try { menuDish=dataBaseHandler.addDish(1,"breakfast");
            } catch (SQLException e) { throw new RuntimeException(e); }
            //showPreviewOrderText();
        });
        addDish2.setOnAction(actionEvent ->{

        });


        buttonAddToOrder.setOnAction(actionEvent ->{

//            menuPreviewOrder.setVisible(false);
//            menuFieldAmountDish.setText("1");
        });

//        buttonCompleteOrder.setOnAction();
//        buttonRadioMoreThanSixPerson.fire();
//        buttonRemoveLastFromList.setOnAction();







        buttonAmountPlus.setOnAction(actionEvent -> {
            menuDish.setAmountDishPlus(menuFieldAmountDish.getText());
            menuFieldAmountDish.setText(menuDish.getAmountDish());
        });

        buttonAmountMinus.setOnAction(actionEvent -> {
            menuDish.setAmountDishMinus(menuFieldAmountDish.getText());
            menuFieldAmountDish.setText(menuDish.getAmountDish());
        });

        buttonCloseTable.setOnAction(actionEvent -> SwitchButtonSceneCloseTable(buttonCloseTable));
        buttonManager.setOnAction(actionEvent -> { SwitchButtonSceneManager(buttonManager); });
        switchToBreakfast.setOnAction(actionEvent -> SwitchButtonSceneBreakfast(switchToBreakfast));
        switchToLunch.setOnAction(actionEvent -> SwitchButtonSceneLunch(switchToLunch));
        switchToDinner.setOnAction(actionEvent -> SwitchButtonSceneDinner(switchToDinner));
        switchToDrinks.setOnAction(actionEvent -> SwitchButtonSceneDrinks(switchToDrinks));
    }
    //tips call like Service charge



}

