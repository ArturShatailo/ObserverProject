package controllers;

import service.Statics;
import service.Tech;
import service.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

        if(!checkPasswordDataBase(user, password.getText())) {
            errorMessageShow("There is no such emails registered");
        } else {
            currentUser = user;
            nextWindow(getCurrentStage(actionEvent), "/view/Home.fxml", "Home Page");
        }

    }

    public void toRegisterPageButton(ActionEvent actionEvent) {
        nextWindow(getCurrentStage(actionEvent), "/view/Register.fxml", "Register");
    }

    @Override
    protected void nextWindow(Stage stage, String source, String title) {
        Tech.nextWindow(getClass().getResource(source), title, stage, 500, 600);
    }

    @Override
    protected void errorMessageShow(String m) {
        messageValue.setText(m);
    }

}
