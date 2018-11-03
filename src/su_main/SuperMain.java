package su_main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SuperMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("su_main.fxml"));
        primaryStage.setTitle("SuperUser");
        primaryStage.setScene(new Scene(root, 454, 268));
        primaryStage.show();
    }
}
