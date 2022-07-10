package entity;

import com.exercise.observerproject.ChannelsController;
import com.exercise.observerproject.ObserverController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Scanner;

public class Tech {

    //"GetInputFunction" is a scanner of input that returns Integer entered by user
    public static int GetInputFunction(){
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    //"GetInputStringFunction" is a scanner of input that returns String entered by user
    public static String GetInputStringFunction(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    //Get random value from min to max
    public static int getRandom(int min, int max){
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static Double getRandomDouble(double min, double max) {
        return roundMet((Math.random() * (max - min)) + min);
    }

    public static double roundMet(double a){
        double b = Math.pow(10, 2);
        return Math.ceil(a * b) / b;
    }

    public static void newWindow(URL application, String title, User user, Stage stage, int x, int y){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(application);
            Scene scene = new Scene(fxmlLoader.load(), x, y);
            stage.setTitle(title);
            stage.setScene(scene);

            ChannelsController channelsController = fxmlLoader.getController();
            channelsController.setCurrentUser(user);

            stage.show();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static void newWindowA(URL application, String title, User user, Stage stage, int x, int y){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(application);
            Scene scene = new Scene(fxmlLoader.load(), x, y);
            stage.setTitle(title);
            stage.setScene(scene);

            ObserverController observerController = fxmlLoader.getController();
            observerController.setCurrentUser(user);

            stage.show();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static void newWindow(URL application, String title, Stage stage, int x, int y){
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
