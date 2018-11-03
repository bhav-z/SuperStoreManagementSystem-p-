package error_window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ErrorWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("errorw.fxml"));
        primaryStage.setTitle("Error");
        primaryStage.setScene(new Scene(root, 446, 242));
        primaryStage.show();
    }
}
