package com.exercise.observerproject;

import entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ObserverController extends ViewController {
    @FXML
    public Label notificationMessage;

    public ScrollPane dashboardScroll;

    public GridPane dashboardArea;

    private static List<Resource> resources;

    private static List<Resource> resourcesNew;

    int scrollCounter = 0;

    @FXML
    public void initialize(){
        updateDashboardButton();
        scrollEvent();
    }

    private void scrollEvent() {
        dashboardScroll.vvalueProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue.intValue() == 1 && scrollCounter == 0){
                showReviewed();
                scrollCounter = 1;
            }
        });
    }

    private void showReviewed() {
        resources.removeAll(resourcesNew);
        reloadDashboard(new ArrayList<>(resources));
        resources = new LinkedList<>(currentUser.getDashboard());
    }

    @FXML
    protected void updateDashboardButton() {

        scrollCounter = 0;
        resourcesNew = new LinkedList<>(currentUser.getDashboard());

        excludeReviewed();

        resources = new LinkedList<>(currentUser.getDashboard());
        dashboardArea.getChildren().clear();
        reloadDashboard(new ArrayList<>(resourcesNew));

    }

    private void excludeReviewed() {
        if(resources != null && resourcesNew.size() - resources.size() > 1 )
            resourcesNew.removeAll(resources);
    }

    private void reloadDashboard(ArrayList<Resource> r) {
        for (Resource resource : r) {
            dashboardArea.add(addRecord(resource), 0, dashboardArea.getRowCount()+1);
        }
        dashboardArea.add(createMessageLine(), 0, dashboardArea.getRowCount()+1);
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
        Tech.nextWindow(getClass().getResource("Home.fxml"), "Home", getCurrentStage(actionEvent), 500, 600);
    }

    private Label createMessageLine() {
        Label l = new Label();
        l.setText("There are no unreviewed notifications");
        return l;
    }
}