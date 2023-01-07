package com.example.demo.controller;

import com.example.demo.data.Const;
import com.example.demo.data.DataBaseProcessor;
import com.example.demo.exeption.ModelException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class PaymentController extends DishHeadController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCancelPayment;

    @FXML
    private Button buttonPayPayment;

    @FXML
    private Button buttonPaymentCard;

    @FXML
    private Button buttonPaymentCash;

    @FXML
    private AnchorPane errorPaymentField;

    @FXML
    private Text errorPaymentText;

    @FXML
    private TextField fieldCardNumberPayment;

    @FXML
    private AnchorPane fieldCash;

    @FXML
    private TextField fieldCcvPayment;

    @FXML
    private TextField fieldDataExpPayment;

    @FXML
    private AnchorPane fieldTextCard;

    @FXML
    private Text numberTablePayment;

    @FXML
    private Text orderFieldText;

    @FXML
    private Text textTotalPayment;

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

    private void cardVisible(){
        payByCash = false;
        fieldCardNumberPayment.setVisible(true);
        fieldTextCard.setVisible(true);
        fieldCardNumberPayment.setVisible(true);
        fieldDataExpPayment.setVisible(true);
        fieldCcvPayment.setVisible(true);
    }

    private void cashVisible(){
        payByCash = true;
        fieldCardNumberPayment.setVisible(false);
        fieldTextCard.setVisible(false);
        fieldCardNumberPayment.setVisible(false);
        fieldDataExpPayment.setVisible(false);
        fieldCcvPayment.setVisible(false);
    }

    private String orderReport = "";
    private String orderTotal = "";
    private boolean payByCash = true;

    @Override
    public String toString() {
        return "PaymentController{" +
                "orderReport='" + orderReport + '\'' +
                ", orderTotal='" + orderTotal + '\'' +
                '}';
    }

    public void loadCloseTable(int table) throws SQLException { //
        DecimalFormat dF = new DecimalFormat( "####.##" );
        StringBuilder orderText = new StringBuilder("- - - - - - - - - - - - >>>   ORDER REPORT   <<< - - - - - - - - - - - -");
        String dishName = "";
        double price;
        int amount;
        double total = 0;
        boolean isService;
        String buffer;
        double serviceSingle = 0;

        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(Const.URL, Const.USERNAME,Const.PASSWORD);
        String select = Const.ORDER_QUERY + " WHERE " + Const.ORDER_TABLE +  " = "+ table;
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            dishName = resultSet.getString(3);
            price = resultSet.getDouble(4);
            amount = resultSet.getInt(5);
            total = resultSet.getDouble(6);
            isService = Boolean.parseBoolean(resultSet.getString(7));

            if(amount!=0){
                buffer = "\n" + dishName + "  - >  " +  dF.format(price) + " €" + " x "+ amount + " qt.  - - - - -  "
                        + dF.format(total)+ " €";
                orderTotal += total;
                orderText.append(buffer);
                buffer = "";
            }
            else {
                if(isService) {
                    double service = 0.1;
                    serviceSingle = total * service;
                    buffer = " \n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n"
                            + "\nOrder price: " + dF.format(total) + " €\t\t\t"
                            + "Service 10%: " + dF.format(serviceSingle) + " €";

                    orderText.append(buffer);
                    buffer = "";
                }
                else {
                    double service = 0;
                    serviceSingle = total * service;
                    buffer = " \n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n"
                            + "\nOrder price: " + dF.format(total) + " €\t\t\t"
                            + "Service 10%: " + "NONE" + "\t";
                    orderText.append(buffer);
                    buffer = "";
                }
            }
        }
        numberTablePayment.setText(String.valueOf(table));
        numberTablePayment.setText(String.valueOf(table));
        textTotalPayment.setText(("TOTAL: " + dF.format(total+serviceSingle) + " €"));
        orderFieldText.setText(String.valueOf(orderText));
        preparedStatement.close();
        connection.close();
    }
    private void showError(String error){
        errorPaymentField.setVisible(true);
        errorPaymentText.setText(error);
        errorPaymentText.setVisible(true);
    }
    private void hideError(){
        errorPaymentField.setVisible(false);
        errorPaymentText.setVisible(false);
    }

    private String orangeStyle(){
        return  "-fx-background-color:#FF6600;";
    }

    private String greenStyle(){
        return "-fx-background-color: linear-gradient(#76994E, #4D7025);";
    }

    private void pickTable(int table){
        if(table == 11){ toggleTable11.setStyle(orangeStyle()); } else { toggleTable11.setStyle(greenStyle()); }
        if(table == 12){ toggleTable12.setStyle(orangeStyle()); } else { toggleTable12.setStyle(greenStyle()); }
    }

    private void setTable(int table){
        { try { loadCloseTable(table); }
        catch (SQLException e) { throw new RuntimeException(e); } pickTable(table);}
    }

    @FXML
    void initialize() {
        SceneSwitchController switchController = new SceneSwitchController();

        toggleTable11.setOnAction(actionEvent -> setTable(11));
        toggleTable12.setOnAction(actionEvent -> setTable(12));
        toggleTable13.setOnAction(actionEvent -> setTable(13));
        toggleTable14.setOnAction(actionEvent -> setTable(14));
        toggleTable15.setOnAction(actionEvent -> setTable(15));
        toggleTable16.setOnAction(actionEvent -> setTable(16));
        toggleTable20.setOnAction(actionEvent -> setTable(20));
        toggleTable36.setOnAction(actionEvent -> setTable(36));
        toggleTable37.setOnAction(actionEvent -> setTable(37));
        toggleTable38.setOnAction(actionEvent -> setTable(38));
        toggleTable39.setOnAction(actionEvent -> setTable(39));

        buttonPaymentCash.setStyle(	"-fx-background-color:#3782bc;");

        buttonPaymentCash.setOnAction(actionEvent -> {
            payByCash = true;
            buttonPaymentCash.setStyle(	"-fx-background-color:#3782bc;");
            buttonPaymentCard.setStyle(	"-fx-background-color:#FF6600;");
            cashVisible();
        });

        buttonPaymentCard.setOnAction(actionEvent -> {
            payByCash = false;
            buttonPaymentCard.setStyle(	"-fx-background-color:#3782bc;");
            buttonPaymentCash.setStyle(	"-fx-background-color:#FF6600;");
            cardVisible();
        });

        buttonPayPayment.setOnAction(actionEvent -> {
            if(payByCash){
                System.out.println("Payment table " + getTableNumber() + " for the amount " + orderTotal + "€ ACCEPT");
            }
            else {
                if(fieldCardNumberPayment.getText().length() !=16 || fieldCardNumberPayment.getText().length() == 0){
                    try {
                        throw new ModelException(ModelException.INCORRECT_PIN);
                    } catch (ModelException e) {
                        showError("ERROR LENGTH CARD NUMBER");
                        throw new RuntimeException(e);}
                }
                try {
                   Long.parseLong(fieldCardNumberPayment.getText());
                } catch (NumberFormatException e) {
                    try {
                        throw new ModelException(ModelException.INCORRECT_PIN);
                    } catch (ModelException ex) {
                        showError("INVALID INPUT CARD NUMBER");
                        throw new RuntimeException(ex);
                    }
                }

                if(fieldDataExpPayment.getText().length() !=4 || fieldDataExpPayment.getText().length() == 0){
                    try {
                        throw new ModelException(ModelException.INCORRECT_PIN);
                    } catch (ModelException e) {
                        showError("ERROR LENGTH DATE EXP.");
                        throw new RuntimeException(e);}
                }
                try {
                    Integer.parseInt(fieldDataExpPayment.getText());
                } catch (NumberFormatException e) {
                    try {
                        throw new ModelException(ModelException.INCORRECT_PIN);
                    } catch (ModelException ex) {
                        showError("INVALID INPUT DATE EXP.");
                        throw new RuntimeException(ex);
                    }
                }

                if(fieldCcvPayment.getText().length() !=3 || fieldCcvPayment.getText().length() == 0){
                    try {
                        throw new ModelException(ModelException.INCORRECT_PIN);
                    } catch (ModelException e) {
                        showError("ERROR LENGTH CCV");
                        throw new RuntimeException(e);}
                }
                try {
                    Integer.parseInt(fieldCcvPayment.getText());
                } catch (NumberFormatException e) {
                    try {
                        throw new ModelException(ModelException.INCORRECT_PIN);
                    } catch (ModelException ex) {
                        showError("INVALID INPUT CCV");
                        throw new RuntimeException(ex);
                    }
                }
            System.out.println("Payment table " + getTableNumber() + " for the amount " + orderTotal + "€ ACCEPT");
            }

            try {
                switchController.switchToSceneMenu(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        buttonCancelPayment.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenu(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}

