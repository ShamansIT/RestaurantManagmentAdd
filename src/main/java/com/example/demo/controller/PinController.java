package com.example.demo.controller;

import com.example.demo.data.DataBaseHandler;
import com.example.demo.exeption.ModelException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PinController implements SceneSwitch{

    @FXML
    private AnchorPane panelBack;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonPinAuthorization0;

    @FXML
    private Button buttonPinAuthorization1;

    @FXML
    private Button buttonPinAuthorization2;

    @FXML
    private Button buttonPinAuthorization3;

    @FXML
    private Button buttonPinAuthorization4;

    @FXML
    private Button buttonPinAuthorization5;

    @FXML
    private Button buttonPinAuthorization6;

    @FXML
    private Button buttonPinAuthorization7;

    @FXML
    private Button buttonPinAuthorization8;

    @FXML
    private Button buttonPinAuthorization9;

    @FXML
    private Button buttonPinAuthorizationClear;

    @FXML
    private Button buttonPinAuthorizationEnter;

    @FXML
    private PasswordField passwordPinField;

    @FXML
    private AnchorPane textErrorFiledPinAuthorization;

    @FXML
    private Text textErrorPinAuthorization;

    @FXML
    private Text textPinAuthorization;

    @FXML
    private AnchorPane textPinFieldAuthorization;

    private void showError(){
        textErrorFiledPinAuthorization.setVisible(true);
        textErrorPinAuthorization.setVisible(true);
    }
    private void hideError(){
        textErrorFiledPinAuthorization.setVisible(false);
        textErrorPinAuthorization.setVisible(false);
    }

    @FXML
    void initialize() {

        panelBack.addEventHandler(MouseEvent.MOUSE_MOVED, actionEvent -> hideError());

        //need enter button to action too
        buttonPinAuthorizationEnter.setOnAction(actionEvent -> {
            try {
                Integer.parseInt(passwordPinField.getText());
            } catch (NumberFormatException e) {
                try {
                    throw new ModelException(ModelException.INCORRECT_PIN);
                } catch (ModelException ex) {
                    showError();
                    throw new RuntimeException(ex);
                }
            }

            if((passwordPinField.getText().length() != 4) || (passwordPinField.getText().length() == 0)) {
                try {
                    throw new ModelException(ModelException.INCORRECT_PIN);
                } catch (ModelException e) {
                    showError();
                    throw new RuntimeException(e);}
                }

            //check PIN access. Change it to boolean
            String loginPIN = passwordPinField.getText().trim();
            int loginSendPin;
            DataBaseHandler dataBaseHandler = new DataBaseHandler();
            try {
                loginSendPin = dataBaseHandler.checkUserPin(Integer.parseInt(loginPIN));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(loginSendPin == 0) {
                try {
                    throw new ModelException(ModelException.INCORRECT_PIN);
                } catch (ModelException e) {
                    showError();
                    throw new RuntimeException(e);}
            }
            //set isManager in DataBaseHandler.checkUserPin

            //point enter in program
            SceneSwitchController switchController = new SceneSwitchController();
            try {
                switchController.switchToSceneMenuBreakfast(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        buttonPinAuthorization1.setOnAction(actionEvent -> passwordPinField.appendText("1"));
        buttonPinAuthorization2.setOnAction(actionEvent -> passwordPinField.appendText("2"));
        buttonPinAuthorization3.setOnAction(actionEvent -> passwordPinField.appendText("3"));
        buttonPinAuthorization4.setOnAction(actionEvent -> passwordPinField.appendText("4"));
        buttonPinAuthorization5.setOnAction(actionEvent -> passwordPinField.appendText("5"));
        buttonPinAuthorization6.setOnAction(actionEvent -> passwordPinField.appendText("6"));
        buttonPinAuthorization7.setOnAction(actionEvent -> passwordPinField.appendText("7"));
        buttonPinAuthorization8.setOnAction(actionEvent -> passwordPinField.appendText("8"));
        buttonPinAuthorization9.setOnAction(actionEvent -> passwordPinField.appendText("9"));
        buttonPinAuthorization0.setOnAction(actionEvent -> passwordPinField.appendText("0"));
        buttonPinAuthorizationClear.setOnAction(actionEvent -> passwordPinField.setText(""));
    }
}
