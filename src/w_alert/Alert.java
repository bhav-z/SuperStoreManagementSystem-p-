package w_alert;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Alert extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("alert.fxml"));
        primaryStage.setTitle("Alert");
        primaryStage.setScene(new Scene(root, 552, 400));
        primaryStage.show();
    }
}
