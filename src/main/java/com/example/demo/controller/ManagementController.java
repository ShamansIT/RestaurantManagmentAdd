package com.example.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManagementController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCloseManagment;

    @FXML
    private Button buttonDayliReport;

    @FXML
    private Button buttonGoToCreateNewEmployeer;

    @FXML
    void initialize() {





        SceneSwitchController switchController = new SceneSwitchController();
        buttonCloseManagment.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuBreakfast(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        buttonDayliReport.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneDayList(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

       buttonGoToCreateNewEmployeer.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneCreateEmployee(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
