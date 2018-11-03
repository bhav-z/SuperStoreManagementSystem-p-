package item;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ItemApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("item.fxml"));
        primaryStage.setTitle("ItemName");
        primaryStage.setScene(new Scene(root, 444, 444));
        primaryStage.show();
    }
}
