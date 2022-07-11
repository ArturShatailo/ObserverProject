package com.exercise.observerproject;

import entity.Tech;
import entity.User;
import entity.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController extends ViewController {

    @FXML
    public Label messageValue;

    @FXML
    public TextField name;

    @FXML
    public TextField email;

    @FXML
    public PasswordField password;

    public void registerButton(ActionEvent actionEvent) {

        if (checkEmailDataBase(email.getText()) != null) {
            errorMessageShow();
        } else {
            currentUser = createUser();
            nextWindow(getCurrentStage(actionEvent), "Home.fxml", "Home Page");
        }
    }

    private User createUser() {
        User user = new User(name.getText(), email.getText(), password.getText());
        users.add(user);
        return user;
    }

    public void toLoginPageButton(ActionEvent actionEvent) {
        nextWindow(getCurrentStage(actionEvent), "Login.fxml", "Login");
    }

    @Override
    protected void errorMessageShow() {
        messageValue.setText("This email has been already registered");
    }

    @Override
    protected void nextWindow(Stage stage, String source, String title) {
        Tech.nextWindow(getClass().getResource(source), title, stage, 500, 600);
    }

}
