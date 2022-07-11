package controllers;

import service.*;
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
    public ScrollPane dashboardScroll;
    @FXML
    public GridPane dashboardArea;

    private static List<Resource> resources;

    private static List<Resource> resourcesNew;

    int scrollCounter = 0;



    //Initialization of Dashboard view and updateDashboardButton(), scrollEvent() methods calling.
    @FXML
    public void initialize(){
        updateDashboardButton();
        scrollEvent();
    }

    /*
     * Realizes displaying old reviewed Resource objects in Dashboard only after full scrolling down.
     *
     * Scroll event handler for 'dashboardScroll' field. If scroll position is full bottom, that is 1 in numeric equivalent
     * AND if 'scrollCounter' field is 0, calls method showReviewed() and sets 'scrollCounter' field as 1 value;
     */
    private void scrollEvent() {
        dashboardScroll.vvalueProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue.intValue() == 1 && scrollCounter == 0){
                showReviewed();
                scrollCounter = 1;
            }
        });
    }

    /*
     * Shows all old, that is reviewed or showed, objects from 'resources' field. If this method is called for the first time
     * 'resources' field will be empty, but in case of further calls, the 'resources' field will contain elements from
     * 'dashboard' field of object in 'currentUser' field but excluding elements from 'resourcesNew' field.
     * To show elements the method reloadDashboard() is called with 'resources' field as a parameter.
     */
    private void showReviewed() {
        resources.removeAll(resourcesNew);
        reloadDashboard(new ArrayList<>(resources));
        resources = new LinkedList<>(currentUser.getDashboard());
    }

    /*
     * Clears all objects shown on dashboard and uploads new ones that are the latest added to 'dashboard'
     * field of object in 'currentUser' field.
     *
     * update button click handler method. er
     * Sets 'scrollCounter' field as 0;
     * Sets 'dashboard' field of object in 'currentUser' field as 'resourcesNew' field
     * Calls method excludeReviewed();
     * Sets 'dashboard' field of object in 'currentUser' field as 'resources' field
     * Clears 'dashboardArea' field from children objects;
     * calls reloadDashboard() method with cast to ArrayList 'resourcesNew' field as a parameter.
     */
    @FXML
    protected void updateDashboardButton() {

        scrollCounter = 0;
        resourcesNew = new LinkedList<>(currentUser.getDashboard());

        excludeReviewed();

        resources = new LinkedList<>(currentUser.getDashboard());
        dashboardArea.getChildren().clear();
        reloadDashboard(new ArrayList<>(resourcesNew));

    }

    /*
     * Helps to realize the rule that if there are 1 or none notifications of the specific User, the dashboard will show
     * all elements from 'dashboard' field of this User object.
     *
     * Checks if 'resources' field is not null AND difference between 'resourcesNew' and 'resources' sizes is more than 1
     * If yes, removes elements from 'resourcesNew' that are equals to elements in 'resources'.
     */
    private void excludeReviewed() {
        if(resources != null && resourcesNew.size() - resources.size() > 1 )
            resourcesNew.removeAll(resources);
    }

    /*
     * Adds new Node elements generated according to information of Resource objects from @param 'r' ArrayList,
     * into GridPane of 'dashboardArea' field. Generating of Nodes occurs with the help of addRecord() method that receives
     * Resource objects from @param 'r' as a parameter
     */
    private void reloadDashboard(ArrayList<Resource> r) {
        for (Resource resource : r) {
            dashboardArea.add(addRecord(resource), 0, dashboardArea.getRowCount()+1);
        }
        dashboardArea.add(createMessageLine(), 0, dashboardArea.getRowCount()+1);
    }

    /*
     * Created new GridPane Node with inner tags where fields of @param 'resource' are included;
     * Returns created GridPane Node object.
     */
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

    /*
     * 'back' button click handler that calls nextWindow() method of Tech class with parameters:
     * - target URL, that is "Home" view;
     * - "Home" string as a 'title' parameter;
     * - as a 'stage' parameter sends result of getCurrentStage() method that receives @param 'actionEvent' as a parameter;
     * - 500 value as width;
     * - 600 value as height.
     */
    @FXML
    public void back(ActionEvent actionEvent) {
        Tech.nextWindow(getClass().getResource("/view/Home.fxml"), "Home", getCurrentStage(actionEvent), 500, 600);
    }

    /*
     * Creates new Label Node element with specific message and returns it.
     */
    private Label createMessageLine() {
        Label l = new Label();
        l.setText("There are no unreviewed notifications");
        return l;
    }
}