package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.model.Text.initText;

public class RestaurantMainServesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        initText();
        FXMLLoader fxmlLoader = new FXMLLoader(RestaurantMainServesApplication.class.getResource("PIN.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 750);
        stage.setTitle("RESTAURANT MANAGE APP");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}