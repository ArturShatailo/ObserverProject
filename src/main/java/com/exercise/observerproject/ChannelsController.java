package com.exercise.observerproject;

import entity.Statics;
import entity.Tech;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ChannelsController implements Statics {
    public Label notificationMessage;
    public Button onBackClick;
    public Button followNews;
    public Button followFilms;
    public Button onDashboard;

    private User currentUser;

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    @FXML
    public void initialize(){

        followNews.setOnAction(event -> currentUser.subscribeRequest(newsPortal));

        followFilms.setOnAction(event -> currentUser.subscribeRequest(filmsPortal));

    }

    public void back(ActionEvent actionEvent) {

        Node node = (Node) actionEvent.getSource();
        Stage currentStage = (Stage) node.getScene().getWindow();
        Tech.newWindow(getClass().getResource("Register.fxml"), "Home", currentStage, 500, 600);

    }

    public void onDashboard(ActionEvent actionEvent) {

        Node node = (Node) actionEvent.getSource();
        Stage currentStage = (Stage) node.getScene().getWindow();
        Tech.newWindowA(getClass().getResource("Dashboard.fxml"), "Dashboard", currentUser, currentStage, 500, 600);

    }

    public void followNews(ActionEvent actionEvent) {
    }

    public void followFilms(ActionEvent actionEvent) {
    }
}
