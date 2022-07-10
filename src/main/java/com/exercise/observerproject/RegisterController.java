package com.exercise.observerproject;

import entity.Tech;
import entity.User;
import entity.Statics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController implements Statics {

    @FXML
    public Label notificationMessage;

    @FXML
    public Label messageValue;

    @FXML
    public TextField name;

    @FXML
    public TextField email;

    public void registerButton(ActionEvent event) {

        User user = new User(name.getText(), email.getText());
        users.add(user);

        Node node = (Node) event.getSource();
        Stage currentStage = (Stage) node.getScene().getWindow();

        Tech.newWindow(getClass().getResource("Channels.fxml"), "Channels", user, currentStage, 500, 600);

    }

    public void toLoginPageButton(ActionEvent actionEvent) {
    }
}
