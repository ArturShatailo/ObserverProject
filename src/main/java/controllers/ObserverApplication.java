package controllers;

import service.Tech;
import service.User;
import javafx.application.Application;
import javafx.stage.Stage;

public class ObserverApplication extends Application {

    @Override
    public void start(Stage stage){
        Tech.nextWindow(ObserverApplication.class.getResource("/view/Register.fxml"), "Registration", stage, 500, 600);
        Tech.newWindow(ObserverApplication.class.getResource("/view/Portals.fxml"), "Portals", 500, 600);
    }

    public static void main(String[] args) {

        //add one User into users base to have ability to test program without registration
        ViewController.users.add(new User("a", "a", "a"));
        launch();

    }
}