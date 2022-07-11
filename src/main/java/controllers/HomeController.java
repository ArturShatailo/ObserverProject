package controllers;

import service.Portal;
import service.Tech;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController extends ViewController {

    @FXML
    public Button news;
    @FXML
    public Button films;
    @FXML
    public Button onDashboard;
    @FXML
    public Button onBackClick;

    /*
    * Initialization of Home page view and checkPortal() methods calling. First one with 'newsPortal' static variable,
    * implemented from Statics interface through ViewController abstract class extending. The second one with 'firstPortal'
    * with the same implementation way.
    */
    @FXML
    public void initialize(){
        checkPortal(newsPortal, news);
        checkPortal(filmsPortal, films);
    }

    /*
     * The methods chain checkPortal -> follow -> unfollow realizes subscribe/unsubscribe button toggling
     *
     * Checks if 'currentUser' field has @param 'portal' in 'portals' field.
     * - If yes @param button receives method unfollow() as onAction attribute. unfollow() method receives
     * parameters 'portal' and 'button' as parameters;
     * - If not @param button receives method follow() as onAction attribute. follow() method receives
     * parameters 'portal' and 'button' as parameters.
     */
    private void checkPortal(Portal portal, Button button) {

        if(currentUser.getPortals().contains(portal)) {
            button.setOnAction(event -> unfollow(portal, button));
            button.setText("Unsubscribe");
        } else {
            button.setOnAction(event -> follow(portal, button));
            button.setText("Subscribe");
        }

    }

    /*
     * Calls subscribeRequest() method of User object from currentUser field and send @param portal as a parameter.
     * Sets text "Unsubscribe" for @param 'button'
     * Sets onAction attribute for @param 'button' as unfollow() method with @param 'portal' and @param 'button' as parameters.
     */
    private void follow(Portal portal, Button button) {
        currentUser.subscribeRequest(portal);
        button.setText("Unsubscribe");
        button.setOnAction(event -> unfollow(portal, button));
    }

    /*
     * Calls unsubscribeRequest() method of User object from currentUser field and send @param portal as a parameter.
     * Sets text "Subscribe" for @param 'button'
     * Sets onAction attribute for @param 'button' as follow() method with @param 'portal' and @param 'button' as parameters.
     */
    private void unfollow(Portal portal, Button button) {
        currentUser.unsubscribeRequest(portal);
        button.setText("Subscribe");
        button.setOnAction(event -> follow(portal, button));
    }

    /*
     * 'back' button click handler that calls nextWindow() method of Tech class with parameters:
     * - target URL, that is "Register" view;
     * - "Register" string as a 'title' parameter;
     * - as a 'stage' parameter sends result of getCurrentStage() method that receives @param 'actionEvent' as a parameter;
     * - 500 value as width;
     * - 600 value as height.
     */
    @FXML
    public void back(ActionEvent actionEvent) {
        Tech.nextWindow(getClass().getResource("/view/Register.fxml"), "Register", getCurrentStage(actionEvent), 500, 600);
    }

    /*
     * 'back' button click handler that calls nextWindow() method of Tech class with parameters:
     * - target URL, that is "Dashboard" view;
     * - "Dashboard" string as a 'title' parameter;
     * - as a 'stage' parameter sends result of getCurrentStage() method that receives @param 'actionEvent' as a parameter;
     * - 500 value as width;
     * - 600 value as height.
     */
    @FXML
    public void onDashboard(ActionEvent actionEvent) {
        Tech.nextWindow(getClass().getResource("/view/Dashboard.fxml"), "Dashboard", getCurrentStage(actionEvent), 500, 600);
    }


}
