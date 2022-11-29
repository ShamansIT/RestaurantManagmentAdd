package com.example.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class PaymentController {

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
    private TextField fieldCcvPayment;

    @FXML
    private TextField fieldDataExpPayment;

    @FXML
    private TextField fieldPayPayment;

    @FXML
    private TextField fieldPayPlusTipsPayment;

    @FXML
    private Text numberTablePayment;

    @FXML
    private Text textTotalPayment;

    @FXML
    void initialize() {



        SceneSwitchController switchController = new SceneSwitchController();
        buttonCancelPayment.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuBreakfast(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        buttonPayPayment.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuBreakfast(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

}

