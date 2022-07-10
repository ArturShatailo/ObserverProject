package com.exercise.observerproject;

import entity.Portal;
import entity.Tech;
import entity.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeController extends ViewController {
    public Label notificationMessage;
    public Button news;
    public Button films;
    public Button onDashboard;
    public Button onBackClick;


    public void initialize(){
        checkPortal(newsPortal, news);
        checkPortal(filmsPortal, films);
    }

    private void checkPortal(Portal portal, Button button) {

        if(currentUser.getPortals().contains(portal)) {
            button.setOnAction(event -> unfollow(portal, button));
            button.setText("Unsubscribe");
        } else {
            button.setOnAction(event -> follow(portal, button));
            button.setText("Subscribe");
        }

    }

    private void follow(Portal portal, Button button) {
        currentUser.subscribeRequest(portal);
        button.setText("Unsubscribe");
        button.setOnAction(event -> unfollow(portal, button));
    }

    private void unfollow(Portal portal, Button button) {
        currentUser.unsubscribeRequest(portal);
        button.setText("Subscribe");
        button.setOnAction(event -> follow(portal, button));
    }


    @FXML
    public void back(ActionEvent actionEvent) {
        Tech.newWindow(getClass().getResource("Register.fxml"), "Home", getCurrentStage(actionEvent), 500, 600);
    }
    @FXML
    public void onDashboard(ActionEvent actionEvent) {
        Tech.newWindow(getClass().getResource("Dashboard.fxml"), "Dashboard", getCurrentStage(actionEvent), 500, 600);
    }


}
