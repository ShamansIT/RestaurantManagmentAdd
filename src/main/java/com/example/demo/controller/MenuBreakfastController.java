package com.example.demo.controller;

import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import com.example.demo.data.DataBaseService;
import com.example.demo.data.DishLoader;
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

    private int numberAmount=1;
    private String amountDish = "1";
    public int getNumberAmount() {
        return numberAmount;
    }

    public void setNumberAmount(int numberAmount) {
        this.numberAmount = numberAmount;
    }

    public String getAmountDish() {
        return amountDish;
    }

    public void setAmountDish(String amountDish) {
        this.amountDish = amountDish;
    }



    private void showError(String error){
        buttonCheckOrderField.setVisible(true);
        buttonCheckOrderField.setText(error);
        buttonCheckOrderField.setVisible(true);
    }
    private void hideError(){
        buttonCheckOrderField.setVisible(false);
        buttonCheckOrderField.setVisible(false);
    }

    private void showLineText(){
        menuPreviewOrder.setVisible(true);
    }

    private void showOffLineText(){
        menuPreviewOrder.setVisible(false);
    }

    public String setPreviewOrderText(){
        DecimalFormat dF = new DecimalFormat( "##.##" );

        String text = "";
        text = dish.getName() +  "  - - >  " + dish.getPrice() + " €" + " x " +getAmountDish()
                + " qt. = " + dF.format(Double.parseDouble(getAmountDish()) * dish.getPrice()) + " €";
        return text;
    }

    public void setAmountRefresh(){
        setAmountDish(Integer.toString(1));
        menuFieldAmountDish.setText("1");
    }
    public void setAmountDishPlus(){
        setNumberAmount(Integer.parseInt(menuFieldAmountDish.getText()));
        setNumberAmount(getNumberAmount()+1);
        setAmountDish(Integer.toString(getNumberAmount()));
        menuFieldAmountDish.setText(String.valueOf(getNumberAmount()));
    }
    public void setAmountDishMinus(){
        setNumberAmount(Integer.parseInt(menuFieldAmountDish.getText()));
        if (getNumberAmount() > 1)
            setNumberAmount(getNumberAmount()-1);
        setAmountDish(Integer.toString(getNumberAmount()));
        menuFieldAmountDish.setText(String.valueOf(getNumberAmount()));
    }

    DataBaseService dataBaseService = new DataBaseService();
    DishLoader dish = dataBaseService.getDish();

    @FXML
    void initialize() {
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

//        toggleTable11.setOnAction(actionEvent ->{ orderControl.setTableNumber(11); });
//        toggleTable12.setOnAction(actionEvent ->{ orderControl.setTableNumber(12); });
//        toggleTable13.setOnAction(actionEvent ->{ orderControl.setTableNumber(13); });
//        toggleTable14.setOnAction(actionEvent ->{ orderControl.setTableNumber(14); });
//        toggleTable15.setOnAction(actionEvent ->{ orderControl.setTableNumber(15); });
//        toggleTable16.setOnAction(actionEvent ->{ orderControl.setTableNumber(16); });
//        toggleTable20.setOnAction(actionEvent ->{ orderControl.setTableNumber(20); });
//        toggleTable36.setOnAction(actionEvent ->{ orderControl.setTableNumber(36); });
//        toggleTable37.setOnAction(actionEvent ->{ orderControl.setTableNumber(37); });
//        toggleTable38.setOnAction(actionEvent ->{ orderControl.setTableNumber(38); });
//        toggleTable39.setOnAction(actionEvent ->{ orderControl.setTableNumber(39); });

        ToggleGroup addDishGroup = new ToggleGroup();
        addDish1.setToggleGroup(addDishGroup);
        addDish2.setToggleGroup(addDishGroup);
        addDish3.setToggleGroup(addDishGroup);
        addDish4.setToggleGroup(addDishGroup);
        addDish5.setToggleGroup(addDishGroup);
        addDish6.setToggleGroup(addDishGroup);
        addDish7.setToggleGroup(addDishGroup);
        addDish8.setToggleGroup(addDishGroup);

        addDish1.setOnAction(actionEvent ->{
            setAmountRefresh();
            try { dish.loadDishLine(1,"breakfast"); } catch (SQLException e) {
                throw new RuntimeException(e); }
            menuPreviewOrder.setText(setPreviewOrderText());
            showLineText();
        });

        addDish2.setOnAction(actionEvent ->{
            setAmountRefresh();
            try { dish.loadDishLine(2,"breakfast"); } catch (SQLException e) {
                throw new RuntimeException(e); }
            menuPreviewOrder.setText(setPreviewOrderText());
            showLineText();
        });

        addDish3.setOnAction(actionEvent ->{
            setAmountRefresh();
            try { dish.loadDishLine(3,"breakfast"); } catch (SQLException e) {
                throw new RuntimeException(e); }
            menuPreviewOrder.setText(setPreviewOrderText());
            showLineText();
        });

        addDish4.setOnAction(actionEvent ->{
            setAmountRefresh();
            try { dish.loadDishLine(4,"breakfast"); } catch (SQLException e) {
                throw new RuntimeException(e); }
            menuPreviewOrder.setText(setPreviewOrderText());
            showLineText();
        });


        buttonAddToOrder.setOnAction(actionEvent ->{
            setAmountRefresh();

            showOffLineText();
        });

        buttonAmountPlus.setOnAction(actionEvent -> {
            setAmountDishPlus();
            menuPreviewOrder.setText(setPreviewOrderText());
        });

        buttonAmountMinus.setOnAction(actionEvent -> {
            setAmountDishMinus();
            menuPreviewOrder.setText(setPreviewOrderText());
        });



        buttonCloseTable.setOnAction(actionEvent -> SwitchButtonSceneCloseTable(buttonCloseTable));
        buttonManager.setOnAction(actionEvent -> { SwitchButtonSceneManager(buttonManager); });
        switchToBreakfast.setOnAction(actionEvent -> SwitchButtonSceneBreakfast(switchToBreakfast));
        switchToLunch.setOnAction(actionEvent -> SwitchButtonSceneLunch(switchToLunch));
        switchToDinner.setOnAction(actionEvent -> SwitchButtonSceneDinner(switchToDinner));
        switchToDrinks.setOnAction(actionEvent -> SwitchButtonSceneDrinks(switchToDrinks));

//        buttonCompleteOrder.setOnAction();
//        buttonRadioMoreThanSixPerson.fire();
//        buttonRemoveLastFromList.setOnAction();

    }
    //tips call like Service charge








}

