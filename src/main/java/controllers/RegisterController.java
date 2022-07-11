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

    /*
     * Validate fields entered and calls for adding new User into DB
     *
     * Calls fieldsValidator() method and if it returns true value:
     * Calls checkEmailDataBase() method;
     * send 'email' field value as a parameter. If the method returns null, calls createUser() method and set this User as
     * 'currentUser' field extended from ViewController class. Then nextWindow() method is called to transfer to Home view.
     *
     * If checkEmailDataBase() method returns not null, calls method errorMessageShow() with parameter "This email has been already registered".
     */
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

    /*
    * Deletes all spaces from 'name', 'email', 'password' fields values.
    * Checks if they are empty, if yes, returns false and shows error message.
    * Checks if 'password' field value has at least 6 characters, and it hasn't, returns false and shows error message.
    * Returns true.
    */
    private boolean fieldsValidator() {
        String n = name.getText().replaceAll(" ", "");
        String e = email.getText().replaceAll(" ", "");
        String p = password.getText().replaceAll(" ", "");

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

    /*
    * Creates new User object with 'name', 'email' and 'password' fields values.
    * Adds created user into 'users' collection field implemented from Statics interface through ViewController abstract class.
    * Returns created User object.
    */
    private User createUser() {
        User user = new User(name.getText(), email.getText(), password.getText());
        users.add(user);
        return user;
    }

    //The "login instead" button click handler that will transfer view to Login page.
    public void toLoginPageButton(ActionEvent actionEvent) {
        nextWindow(getCurrentStage(actionEvent), "/view/Login.fxml", "Login");
    }

    /*
    * Overridden method from ViewController abstract class.
    * Fills messageValue Label object with received in @param 'm' String value
    */
    @Override
    protected void errorMessageShow(String m) {
        messageValue.setText(m);
    }

    /*
    * Overridden method from ViewController abstract class.
    * Starts new scene with next specified in parameters view page.
    */
    @Override
    protected void nextWindow(Stage stage, String source, String title) {
        Tech.nextWindow(getClass().getResource(source), title, stage, 500, 600);
    }

}
