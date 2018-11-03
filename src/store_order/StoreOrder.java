package store_order;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoreOrder extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("storeorder.fxml"));
        primaryStage.setTitle("Order");
        primaryStage.setScene(new Scene(root, 600, 370));
        primaryStage.show();
    }
}
