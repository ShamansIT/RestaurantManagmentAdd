package com.example.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CreateEmployeeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCancelCreateEmployee;

    @FXML
    private Button buttonCreate;

    @FXML
    private TextField fieldAddress;

    @FXML
    private TextField fieldAge;

    @FXML
    private TextField fieldCity;

    @FXML
    private TextField fieldCountry;

    @FXML
    private TextField fieldEmail;

    @FXML
    private AnchorPane fieldErrorCreateEmployee;

    @FXML
    private TextField fieldFirstName;

    @FXML
    private TextField fieldLastName;

    @FXML
    private TextField fieldPPS;

    @FXML
    private TextField fieldPhone;

    @FXML
    private TextField fieldPin;

    @FXML
    private RadioButton radioButtonFemale;

    @FXML
    private RadioButton radioButtonMale;

    @FXML
    private Text textErrorCreateEmployee;

    @FXML
    void initialize() {





        SceneSwitchController switchController = new SceneSwitchController();
        buttonCreate.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneManager(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });



        buttonCancelCreateEmployee.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneManager(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
