package user_subcategory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * class to run usersub.fxml individually
 */

public class UserSub extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("usersub.fxml"));
        primaryStage.setTitle("CategoryName");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }
}
