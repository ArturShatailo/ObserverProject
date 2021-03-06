package service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class Tech {

    /*
    * Updating Stage of the current Window with the new Scene object.
    * URL and title values are received from @param 'application' and @param 'title'.
    * New Stage object is received from @param 'stage'
    * @param x is width
    * @param y is height
    */
    public static void nextWindow(URL application, String title, Stage stage, int x, int y){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(application);
            Scene scene = new Scene(fxmlLoader.load(), x, y);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    /*
     * Creating new Stage and new Window opening.
     * URL and title values are received from @param 'application' and @param 'title'.
     * @param x is width
     * @param y is height
     */
    public static void newWindow(URL application, String title, int x, int y){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(application);
            Scene scene = new Scene(fxmlLoader.load(), x, y);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
