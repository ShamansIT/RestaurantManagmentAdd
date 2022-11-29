package com.example.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class DailyReportController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonDailyReportClose;

    @FXML
    private Text textDailyTotalProfit;

    @FXML
    void initialize() {


        SceneSwitchController switchController = new SceneSwitchController();
        buttonDailyReportClose.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneManager(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

}


