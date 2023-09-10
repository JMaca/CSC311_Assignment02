package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            URL url = new File("src/main/java/view/loanCalculator.fxml").toURI().toURL();
            GridPane root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 400, 400);
            stage.setTitle("Loan Calculator");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}