package com.example.demo.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class PaymentController implements SceneSwitch {

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
    private AnchorPane fieldCashSum;

    @FXML
    private TextField fieldCcvPayment;

    @FXML
    private TextField fieldDataExpPayment;

    @FXML
    private TextField fieldPayPayment;

    @FXML
    private TextField fieldPayPlusTipsPayment;

    @FXML
    private AnchorPane fieldTextCard;

    @FXML
    private AnchorPane fieldCardTotal;

    @FXML
    private AnchorPane fieldCardTotalSum;

    @FXML
    private Text numberTablePayment;

    @FXML
    private Text textTotalPayment;

    @FXML
    private Text textTotalPayment1;

    private void cardVisible(){
        fieldCardNumberPayment.setVisible(true);
        fieldTextCard.setVisible(true);
        fieldCardNumberPayment.setVisible(true);
        fieldDataExpPayment.setVisible(true);
        fieldCcvPayment.setVisible(true);
        fieldPayPayment.setVisible(true);
        fieldPayPlusTipsPayment.setVisible(true);
        fieldCardTotal.setVisible(true);
        fieldCardTotalSum.setVisible(true);
        fieldCash.setVisible(false);
        fieldCashSum.setVisible(false);
    }
    private void cashVisible(){
        fieldCash.setVisible(true);
        fieldCashSum.setVisible(true);
        fieldCardNumberPayment.setVisible(false);
        fieldTextCard.setVisible(false);
        fieldCardNumberPayment.setVisible(false);
        fieldDataExpPayment.setVisible(false);
        fieldCcvPayment.setVisible(false);
        fieldPayPayment.setVisible(false);
        fieldPayPlusTipsPayment.setVisible(false);
        fieldCardTotal.setVisible(false);
        fieldCardTotalSum.setVisible(false);
    }





    @FXML
    void initialize() {


        buttonPaymentCash.setOnAction(actionEvent -> {

            cashVisible();
        });

        buttonPaymentCard.setOnAction(actionEvent -> {

            cardVisible();
        });

        buttonCancelPayment.setOnAction(actionEvent -> SwitchButtonSceneToMenu(buttonCancelPayment));
        buttonPayPayment.setOnAction(actionEvent -> SwitchButtonSceneToMenu(buttonPayPayment));
    }

}

