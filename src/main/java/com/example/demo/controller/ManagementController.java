package com.example.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManagementController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCloseManagement;

    @FXML
    private Button buttonDailyReport;

    @FXML
    private Button buttonGoToCreateNewEmployee;

    @FXML
    void initialize() {
        SceneSwitchController switchController = new SceneSwitchController();

        buttonCloseManagement.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenu(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        buttonDailyReport.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneDayList(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

       buttonGoToCreateNewEmployee.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneCreateEmployee(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
