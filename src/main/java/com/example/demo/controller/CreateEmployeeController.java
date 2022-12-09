package com.example.demo.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import com.example.demo.data.DataBaseHandler;
import com.example.demo.exeption.ModelException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CreateEmployeeController implements SceneSwitch {

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
    private AnchorPane panelBack;

    private void showError(String error){
        fieldErrorCreateEmployee.setVisible(true);
        textErrorCreateEmployee.setText(error);
        textErrorCreateEmployee.setVisible(true);
    }
    private void hideError(){
        fieldErrorCreateEmployee.setVisible(false);
        textErrorCreateEmployee.setVisible(false);
    }

    @FXML
    void initialize() throws SQLException {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        //dataBaseHandler.loadOrderDataSQL();

        panelBack.addEventHandler(MouseEvent.MOUSE_MOVED, actionEvent -> hideError());

        ToggleGroup buttonGender = new ToggleGroup();
        radioButtonFemale.setToggleGroup(buttonGender);
        radioButtonMale.setToggleGroup(buttonGender);
        radioButtonMale.setUserData("male");
        radioButtonFemale.setUserData("female");

        buttonCreate.setOnAction(event -> {
            try {
                Integer.parseInt(fieldPin.getText());
            } catch (NumberFormatException e) {
                try {
                    throw new ModelException(ModelException.INCORRECT_PIN);
                } catch (ModelException ex) {
                    showError("Error enter PIN\t Please try again");
                    throw new RuntimeException(ex);
                }
            }

            if (fieldPin.getText().length() == 0 || fieldPin.getText().length() != 4) try {
                throw new ModelException(ModelException.INCORRECT_PIN);
            } catch (ModelException e) {
                showError("Error enter PIN\t Please try again");
                throw new RuntimeException(e);
            }

            try {
                fieldFirstName.getText();
            } catch (InputMismatchException ignored) {
                showError("Error enter firstname\t Please try again");
            } try {
                fieldFirstName.getText();
                showError("Error enter firstname\t Please try again");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                fieldLastName.getText();
            } catch (InputMismatchException ignored) {
                showError("Error enter lastname\t Please try again");
            } try {
                fieldLastName.getText();
                showError("Error enter lastname\t Please try again");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (fieldEmail.getText().trim().length() == 0){
                try {
                    throw new ModelException(ModelException.EMPTY_FIELD);
                } catch (ModelException e) {
                    showError("Empty email field\t Please try again");
                    throw new RuntimeException(e);
                }
            }

            if (fieldPhone.getText().trim().length() == 0){
                try {
                    throw new ModelException(ModelException.EMPTY_FIELD);
                } catch (ModelException e) {
                    showError("Empty phone field\t Please try again");
                    throw new RuntimeException(e);
                }
            }

            if (fieldAddress.getText().trim().length() == 0){
                try {
                    throw new ModelException(ModelException.EMPTY_FIELD);
                } catch (ModelException e) {
                    showError("Empty address field\t Please try again");
                    throw new RuntimeException(e);
                }
            }

            if (fieldCity.getText().trim().length() == 0){
                try {
                    throw new ModelException(ModelException.EMPTY_FIELD);
                } catch (ModelException e) {
                    showError("Empty address field\t Please try again");
                    throw new RuntimeException(e);
                }
            }

            if (fieldCountry.getText().trim().length() == 0){
                try {
                    throw new ModelException(ModelException.EMPTY_FIELD);
                } catch (ModelException e) {
                    showError("Empty address field\t Please try again");
                    throw new RuntimeException(e);
                }
            }

            if (fieldPPS.getText().trim().length() == 0 && fieldPPS.getText().trim().length() != 8){
                try {
                    throw new ModelException(ModelException.EMPTY_FIELD);
                } catch (ModelException e) {
                    showError("Empty address field\t Please try again");
                    throw new RuntimeException(e);
                }
            }
        });


        buttonCreate.setOnAction(actionEvent -> SwitchButtonSceneManager(buttonCreate));
        //set export to SQL table
        buttonCancelCreateEmployee.setOnAction(actionEvent -> SwitchButtonSceneManager( buttonCancelCreateEmployee));

    }

}
