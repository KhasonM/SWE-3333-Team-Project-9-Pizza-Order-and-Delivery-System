package ui.Customer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file (adjust path if not in the same package; assumes it's in resources/ui/Customer/LoginPage-view.fxml)
            Parent root = FXMLLoader.load(getClass().getResource("LoginPage-view.fxml"));

            // Set up the scene with preferred dimensions (match your FXML's prefWidth/prefHeight)
            Scene scene = new Scene(root, 600, 400);  // Or use root's preferred size

            // Configure the stage
            primaryStage.setTitle("Customer Login");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();  // Handle loading errors (e.g., FXML not found)
            // Optionally, show an alert or log the issue
        }
    }
}