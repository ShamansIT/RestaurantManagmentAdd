package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuBreakfastController extends DishHeadController implements SceneSwitch {

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
    private CheckBox checkLessFivePerson;

    @FXML
    private Button clearList;

    @FXML
    private AnchorPane leftFieldOrder;

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
    private Text textOrderLeft;

    @FXML
    private Text textTableNumber;

    @FXML
    private Text textTotalPrice;

    @FXML
    private Text tipsService;

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

    private void showLineText(){
        menuPreviewOrder.setVisible(true);
    }
    private void showOffLineText(){
        menuPreviewOrder.setVisible(false);
    }

    private void setAmountRefresh(){
        setAmountDish(Integer.toString(1));
        menuFieldAmountDish.setText("1");
    }

    private void setAmountDishPlus(){
        setNumberAmount(Integer.parseInt(menuFieldAmountDish.getText()));
        setNumberAmount(getNumberAmount()+1);
        setAmountDish(Integer.toString(getNumberAmount()));
        menuFieldAmountDish.setText(String.valueOf(getNumberAmount()));
    }

   private void setAmountDishMinus(){
        setNumberAmount(Integer.parseInt(menuFieldAmountDish.getText()));
        if (getNumberAmount() > 1)
            setNumberAmount(getNumberAmount()-1);
        setAmountDish(Integer.toString(getNumberAmount()));
        menuFieldAmountDish.setText(String.valueOf(getNumberAmount()));
    }

    private void refreshTipsInfo(){
        if(getTotalPrice() == 0){
            tipsService.setVisible(false);
        }
        else {
            if (checkLessFivePerson.isSelected()) {
                setIsService(true);
                setTipsOver(0.1);
                tipsService.setText(setTips());
                tipsService.setVisible(true);
                textTotalPrice.setText(setTotalPricePlusTips());
            } else {
                setIsService(false);
                setTipsOver(0);
                tipsService.setVisible(false);
                textTotalPrice.setText(setTotalPriceText());
            }
        }
    }


//    private double menuTotalPrice = getTotalPrice();
//    private void initFieldOnStart(){
//        if(getOrderWindowText() != null){
//            textTotalPrice.setText(setTotalPriceText());
//            textOrderLeft.setText(getOrderWindowText());
//            refreshTipsInfo();
//            setAmountRefresh();
//            textTotalPrice.setVisible(true);
//            textOrderLeft.setVisible(true);
//        }
//    }

    @FXML
    void initialize() {

        // view list order if it exists

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

        // add toggle select light

        toggleTable11.setOnAction(actionEvent ->{ setTableNumber(11); });
        toggleTable12.setOnAction(actionEvent ->{ setTableNumber(12); });
        toggleTable13.setOnAction(actionEvent ->{ setTableNumber(13); });
        toggleTable14.setOnAction(actionEvent ->{ setTableNumber(14); });
        toggleTable15.setOnAction(actionEvent ->{ setTableNumber(15); });
        toggleTable16.setOnAction(actionEvent ->{ setTableNumber(16); });
        toggleTable20.setOnAction(actionEvent ->{ setTableNumber(20); });
        toggleTable36.setOnAction(actionEvent ->{ setTableNumber(36); });
        toggleTable37.setOnAction(actionEvent ->{ setTableNumber(37); });
        toggleTable38.setOnAction(actionEvent ->{ setTableNumber(38); });
        toggleTable39.setOnAction(actionEvent ->{ setTableNumber(39); });

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
            try { loadDishLine(1,"breakfast"); } catch (SQLException e) {
                throw new RuntimeException(e); }
            buttonCheckOrderField.setVisible(false);
            menuPreviewOrder.setText(setPreviewOrderText());
            showLineText();
        });

        addDish2.setOnAction(actionEvent ->{
            setAmountRefresh();
            try { loadDishLine(2,"breakfast"); } catch (SQLException e) {
                throw new RuntimeException(e); }
            buttonCheckOrderField.setVisible(false);
            menuPreviewOrder.setText(setPreviewOrderText());
            showLineText();
        });

        addDish3.setOnAction(actionEvent ->{
            setAmountRefresh();
            try { loadDishLine(3,"breakfast"); } catch (SQLException e) {
                throw new RuntimeException(e); }
            buttonCheckOrderField.setVisible(false);
            menuPreviewOrder.setText(setPreviewOrderText());
            showLineText();
        });

        addDish4.setOnAction(actionEvent ->{
            setAmountRefresh();
            try { loadDishLine(4,"breakfast"); } catch (SQLException e) {
                throw new RuntimeException(e); }
            buttonCheckOrderField.setVisible(false);
            menuPreviewOrder.setText(setPreviewOrderText());
            showLineText();
        });

        buttonAddToOrder.setOnAction(actionEvent ->{
            if(getName() == null) {
                buttonCheckOrderField.setText("PICK DISH");
                buttonCheckOrderField.setVisible(true);
            }
            else{
                    setOrderWindowText(getOrderWindowText() + setPreviewWindowText());
                    textOrderLeft.setText(getOrderWindowText());
                    showOffLineText();
                    if(getNumberAmount()>10) {
                        buttonCheckOrderField.setText("CHECK QUANTITY");
                        buttonCheckOrderField.setVisible(true);
                    }
                    setTotalPrice(countTotalPrice());
                    refreshTipsInfo();
                    textTotalPrice.setVisible(true);
                    textTotalPrice.setText(setTotalPriceText());
                    addDishGroup.selectToggle(null);
                    setAmountRefresh();
                    prepareOrderStringToList();
                }
        });

        checkLessFivePerson.setOnAction(actionEvent -> {
            refreshTipsInfo();
        });

        buttonCheckOrderField.setOnAction(actionEvent ->{
            buttonCheckOrderField.setVisible(false);
        });

        clearList.setOnAction(actionEvent -> {
            setOrderWindowText("");
            setTotalPrice(0);
            textTotalPrice.setText("");
            textOrderLeft.setText(getOrderWindowText());
            tipsService.setVisible(false);
            buttonCheckOrderField.setVisible(false);
            setAmountRefresh();
            clearOrderStringToList();
        });

        buttonCompleteOrder.setOnAction(actionEvent -> {
            prepareOrderEndStringToList();
            try {
                exportReportToSQL();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try { exportOrderToSQL();
            } catch (SQLException e) { throw new RuntimeException(e);
            }
            clearOrderStringToList();
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
        buttonManager.setOnAction(actionEvent -> SwitchButtonSceneManager(buttonManager));
        switchToBreakfast.setOnAction(actionEvent -> SwitchButtonSceneBreakfast(switchToBreakfast));
        switchToLunch.setOnAction(actionEvent -> SwitchButtonSceneLunch(switchToLunch));
        switchToDinner.setOnAction(actionEvent -> SwitchButtonSceneDinner(switchToDinner));
        switchToDrinks.setOnAction(actionEvent -> SwitchButtonSceneDrinks(switchToDrinks));
    }
}

