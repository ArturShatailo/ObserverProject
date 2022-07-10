package com.exercise.observerproject;

import entity.Statics;
import entity.Tech;
import entity.User;
import entity.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends ViewController implements Statics {

    @FXML
    public Label messageValue;

    @FXML
    public TextField email;

    @FXML
    public PasswordField password;

    public void loginButton(ActionEvent actionEvent) {

        User user = checkEmailDataBase(email.getText());

        if(!checkPasswordDataBase(user, password.getText()))
            errorMessageShow();
        else{
            currentUser = user;
            nextWindow(getCurrentStage(actionEvent), "Home.fxml", "Home Page");
        }

    }

    public void toRegisterPageButton(ActionEvent actionEvent) {

        Node node = (Node) actionEvent.getSource();
        Stage currentStage = (Stage) node.getScene().getWindow();

        Tech.newWindow(getClass().getResource("Register.fxml"), "Register", currentStage, 500, 600);

    }

    @Override
    protected void nextWindow(Stage stage, String source, String title) {
        Tech.newWindow(getClass().getResource(source), title, stage, 500, 600);
    }

    @Override
    protected void errorMessageShow() {
        messageValue.setText("There is no such emails registered");
    }

}
