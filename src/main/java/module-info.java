module com.exersice.observerproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.exercise.observerproject to javafx.fxml;
    exports com.exercise.observerproject;
}