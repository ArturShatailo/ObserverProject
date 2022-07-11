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

    /*
     * Validate fields entered and implements Login action.
     *
     * Calls checkEmailDataBase() method and send 'email' field value as a parameter
     * The User object is creating and sending as the first parameter of the method checkPasswordDataBase().
     * The second parameter of this method is 'password' field value.
     *
     * If checkPasswordDataBase() returns true, 'currentUser' field extended from ViewController abstract class is set as
     * created User object. Then nextWindow() method is called to transfer to Home view.
     * If checkPasswordDataBase() returns false, the errorMessageShow() method is called with message "There is no such emails registered"
     */
    public void loginButton(ActionEvent actionEvent) {

        User user = checkEmailDataBase(email.getText());

        if(!checkPasswordDataBase(user, password.getText())) {
            errorMessageShow("There is no such emails registered");
        } else {
            currentUser = user;
            nextWindow(getCurrentStage(actionEvent), "/view/Home.fxml", "Home Page");
        }

    }


    //The "register instead" button click handler that will transfer view to Register page.
    @FXML
    public void toRegisterPageButton(ActionEvent actionEvent) {
        nextWindow(getCurrentStage(actionEvent), "/view/Register.fxml", "Register");
    }


    /*
    * Overridden method from ViewController abstract class.
    * Starts new scene with next specified in parameters view page.
    */
    @Override
    protected void nextWindow(Stage stage, String source, String title) {
        Tech.nextWindow(getClass().getResource(source), title, stage, 500, 600);
    }

    /*
     * Overridden method from ViewController abstract class.
     * Fills messageValue Label object with received in @param 'm' String value
     */
    @Override
    protected void errorMessageShow(String m) {
        messageValue.setText(m);
    }

}
