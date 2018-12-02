package user_main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
        * class to run usermain.fxml individually
        */
public class UserMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("usermain.fxml"));
        primaryStage.setTitle("StoreName");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
