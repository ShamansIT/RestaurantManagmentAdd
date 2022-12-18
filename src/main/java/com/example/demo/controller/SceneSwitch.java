package com.example.demo.controller;

import javafx.scene.control.Button;
import java.io.IOException;

public interface SceneSwitch {
    default void SwitchButtonSceneManager(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneManager(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    default void SwitchButtonSceneToMenu(Button button) {
        SceneSwitchController switchController = new SceneSwitchController();
        button.setOnAction(actionEvent -> {
            try {
                switchController.switchToSceneMenu(actionEvent);
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
