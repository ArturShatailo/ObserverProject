package controllers;

import service.Tech;
import service.User;
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
        if (fieldsValidator()){
            if (checkEmailDataBase(email.getText()) != null) {
                errorMessageShow("This email has been already registered");
            } else {
                currentUser = createUser();
                nextWindow(getCurrentStage(actionEvent), "/view/Home.fxml", "Home Page");
            }
        }
    }

    private boolean fieldsValidator() {
        String n = name.getText().trim();
        String e = email.getText().trim();
        String p = password.getText().trim();

        if(n.isEmpty() || e.isEmpty() || p.isEmpty()){
            errorMessageShow("Empty field is not allowed");
            return false;
        }

        if(p.length() < 6){
            errorMessageShow("Password should contain more than 6 characters");
            return false;
        }

        return true;

    }

    private User createUser() {
        User user = new User(name.getText(), email.getText(), password.getText());
        users.add(user);
        return user;
    }

    public void toLoginPageButton(ActionEvent actionEvent) {
        nextWindow(getCurrentStage(actionEvent), "/view/Login.fxml", "Login");
    }

    @Override
    protected void errorMessageShow(String m) {
        messageValue.setText(m);
    }

    @Override
    protected void nextWindow(Stage stage, String source, String title) {
        Tech.nextWindow(getClass().getResource(source), title, stage, 500, 600);
    }

}
