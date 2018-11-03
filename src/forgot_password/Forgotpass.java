package forgot_password;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Forgotpass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("forgotpass.fxml"));
        primaryStage.setTitle("ForgotPassword");
        primaryStage.setScene(new Scene(root, 446, 242));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
