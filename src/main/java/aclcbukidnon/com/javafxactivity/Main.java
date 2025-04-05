package aclcbukidnon.com.javafxactivity;

import aclcbukidnon.com.javafxactivity.controllers.SplashScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

@SuppressWarnings("ALL")
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Load the splash screen FXML
        FXMLLoader splashScreenFxml = new FXMLLoader(Main.class.getResource("splash-screen-view.fxml"));
        Scene splashScreenScene = new Scene(splashScreenFxml.load(), 800, 600);

        // Get the splash screen controller and set the stage
        SplashScreenController splashScreenCtrl = splashScreenFxml.getController();
        splashScreenCtrl.setStage(stage);

        // Set up the splash screen stage
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setTitle("Activity");
        stage.setScene(splashScreenScene);
        stage.show();

        // After the splash screen finishes (simulated with a delay or timeline), show the traffic light view
        // Simulating splash screen duration and moving to the traffic light view after 3 seconds
        new Thread(() -> {
            try {
                // Wait for 3 seconds (simulate splash screen duration)
                Thread.sleep(3000);
                // Load the traffic light view
                loadTrafficLightView(stage);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Method to load the traffic light view
    private void loadTrafficLightView(Stage stage) throws IOException {
        FXMLLoader trafficLightFxml = new FXMLLoader(Main.class.getResource("traffic-light-view.fxml"));
        Scene trafficLightScene = new Scene(trafficLightFxml.load(), 309, 556);  // Adjust size accordingly

        // Set up the traffic light stage
        stage.setTitle("Traffic Light Simulator");
        stage.setScene(trafficLightScene);
    }

    public static void main(String[] args) {
        launch();
    }
}
