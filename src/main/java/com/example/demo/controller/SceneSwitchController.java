package com.example.demo.controller;

import com.example.demo.RestaurantMainServesApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class SceneSwitchController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSceneMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull
                (RestaurantMainServesApplication.class.getResource("Menu.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneDayList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull
                (RestaurantMainServesApplication.class.getResource("DailyReport.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScenePayment(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull
                (RestaurantMainServesApplication.class.getResource("Payment.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneCreateEmployee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull
                (RestaurantMainServesApplication.class.getResource("CreateEmployee.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneManager(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull
                (RestaurantMainServesApplication.class.getResource("Manager.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
