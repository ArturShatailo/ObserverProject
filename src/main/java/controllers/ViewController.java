package controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import service.Statics;
import service.User;

abstract public class ViewController implements Statics {

    protected static User currentUser;

    protected void errorMessageShow(String m){}

    protected Stage getCurrentStage(ActionEvent a){
        Node node = (Node) a.getSource();
        return (Stage) node.getScene().getWindow();
    }

    protected void nextWindow(Stage stage, String s, String t){}

    protected User checkEmailDataBase(String email) {
        return users.stream().filter(u -> u.getEmail().equals(email)).findAny().orElse(null);
    }

    protected boolean checkPasswordDataBase(User u, String p) {
        return u != null && u.getPassword().equals(p);
    }

}
