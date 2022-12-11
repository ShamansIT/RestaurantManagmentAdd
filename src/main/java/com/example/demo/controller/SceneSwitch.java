package com.example.demo.controller;

import javafx.scene.control.Button;
import java.io.IOException;

public interface SceneSwitch {
    default public void SwitchButtonSceneManager(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneManager(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    default void SwitchButtonSceneBreakfast(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuBreakfast(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    default void SwitchButtonSceneLunch(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuLunch(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    default void  SwitchButtonSceneDinner(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuDinner(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    default void  SwitchButtonSceneDrinks(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenuDrinks(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    default void SwitchButtonSceneCloseTable(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToScenePayment(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
