package com.exercise.observerproject;

import entity.Main;
import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ObserverController {
    @FXML
    public Label notificationMessage;

    private User currentUser;

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    @FXML
    public void initialize(){
        Main.main(new String[10]);
    }

    @FXML
    protected void updateDashboardButton() {
        currentUser.showDashboard();
    }
}