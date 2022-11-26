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

    public void switchToSceneBreakfast(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(RestaurantMainServesApplication.class.getResource("Breakfast.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSceneLunch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(RestaurantMainServesApplication.class.getResource("Lunch.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneDinner(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(RestaurantMainServesApplication.class.getResource("Dinner.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneDrinks(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(RestaurantMainServesApplication.class.getResource("Drinks.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneDayList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(RestaurantMainServesApplication.class.getResource("DayList.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScenePayment(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(RestaurantMainServesApplication.class.getResource("Payment.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneCreateEmployee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(RestaurantMainServesApplication.class.getResource("CreateEmployee.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
