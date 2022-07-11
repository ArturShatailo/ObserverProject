package controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import service.Statics;
import service.User;

abstract public class ViewController implements Statics {

    protected static User currentUser;

    /*
    * Fills messageValue Label object with received in @param 'm' String value
    */
    protected void errorMessageShow(String m){}

    /*
    Creates new Node object as a source of ActionEvent received from parameter 'a'
    Returns Stage object as Window of Scene of created Node.
    */
    protected Stage getCurrentStage(ActionEvent a){
        Node node = (Node) a.getSource();
        return (Stage) node.getScene().getWindow();
    }

    /*
     * Receives Stage, String and String objects as parameters.
     * The method is created to call static method nextWindow() from Tech class with set parameters
     * as received from @param 'stage', @param s, @param t.
     */
    protected void nextWindow(Stage stage, String s, String t){}

    /*
    * Checks if 'users' collection implemented from Statics interface has User object with 'email' field that is equals to
    * received String @param 'email'. Returns User if exists ot null.
    */
    protected User checkEmailDataBase(String email) {
        return users.stream().filter(u -> u.getEmail().equals(email)).findAny().orElse(null);
    }

    /*
    * Checks @param User 'u' for 'password' field. If it's not null AND equals to @param String 'p' that is entered into the
    * TextArea and sent to this method.
    */
    protected boolean checkPasswordDataBase(User u, String p) {
        return u != null && u.getPassword().equals(p);
    }

}
