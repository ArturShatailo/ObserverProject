package com.exercise.observerproject;

import entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Collections;

public class ObserverController extends ViewController {
    @FXML
    public Label notificationMessage;
    public GridPane dashboardArea;
    private static ArrayList<Resource> resources = new ArrayList<>();

    @FXML
    public void initialize(){

        updateDashboardButton();

    }

    private void reloadDashboard(ArrayList<Resource> r) {
        for (Resource resource : r) {
            dashboardArea.add(addRecord(resource), 0, dashboardArea.getRowCount()+1);
        }
    }

    @FXML
    protected void updateDashboardButton() {

        Main.main(new String[10]);
//        resources = new ArrayList<>(currentUser.getDashboard());
//        reloadDashboard(resources);

        ArrayList<Resource> newResources = new ArrayList<>(currentUser.getDashboard());
        newResources.removeAll(resources);
        resources = new ArrayList<>(currentUser.getDashboard());
        reloadDashboard(newResources);
    }

    private GridPane addRecord(Resource resource){

        GridPane gp = new GridPane();
        Label titleArea = new Label(resource.getNotification().title);
        titleArea.setFont(new Font("Serif", 16));
        Label dateArea = new Label("("+resource.getNotification().date+")");
        Label textArea= new Label(resource.toString());
        Label divider = new Label("---------------------------------------");

        gp.add(titleArea, 0, 0);
        gp.add(dateArea, 1, 0);
        gp.add(textArea, 0, 3);
        gp.add(divider, 0, 8);

        gp.setAlignment(Pos.TOP_LEFT);
        gp.setHgap(5.0);
        gp.setVgap(5.0);

        return gp;
    }

    @FXML
    public void back(ActionEvent actionEvent) {
        Tech.newWindow(getClass().getResource("Register.fxml"), "Home", getCurrentStage(actionEvent), 500, 600);
    }
}