package user_items;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserItem extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("useritem.fxml"));
        primaryStage.setTitle("SubCategoryName");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
