package su_first;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class First extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("su_first.fxml"));
        primaryStage.setTitle(" ");
        primaryStage.setScene(new Scene(root, 715, 383));
        primaryStage.show();
    }
}
