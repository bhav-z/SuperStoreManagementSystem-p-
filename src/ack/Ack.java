package ack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ack extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ack.fxml"));
        primaryStage.setTitle("Ack");
        primaryStage.setScene(new Scene(root, 480, 203));
        primaryStage.show();
    }
}
