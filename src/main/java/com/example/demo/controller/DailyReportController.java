package com.example.demo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class DailyReportController implements SceneSwitch {

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





        buttonDailyReportClose.setOnAction(actionEvent -> SwitchButtonSceneManager(buttonDailyReportClose));

    }

}


