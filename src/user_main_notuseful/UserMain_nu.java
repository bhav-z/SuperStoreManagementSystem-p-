package user_main_notuseful;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserMain_nu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("usermain_nu.fxml"));
        primaryStage.setTitle("SuperStore");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
