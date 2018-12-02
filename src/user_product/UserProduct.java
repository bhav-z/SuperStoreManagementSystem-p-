package user_product;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * class to run userproduct.fxml individually
 */

public class UserProduct extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("userproduct.fxml"));
        primaryStage.setTitle("ProductName");
        primaryStage.setScene(new Scene(root, 440, 230));
        primaryStage.show();
    }
}
