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

    public void switchToSceneMenuBreakfast(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull
                (RestaurantMainServesApplication.class.getResource("MenuBreakfast.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSceneMenuLunch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull
                (RestaurantMainServesApplication.class.getResource("MenuLunch.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneMenuDinner(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull
                (RestaurantMainServesApplication.class.getResource("MenuDinner.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneMenuDrinks(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull
                (RestaurantMainServesApplication.class.getResource("MenuDrinks.fxml")));
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

//    public void switchScene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(RestaurantMainServesApplication.class.getResource("MenuBreakfast.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1200, 750);
//        stage.setTitle("RESTAURANT MANAGE APP");
//        stage.setScene(scene);
//        stage.show();
//    }

//    public void switchTo( ) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("MenuBreakfast.fxml"));
//        try {
//            loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Parent root = loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.showAndWait();
//    }


}
