package su_warehouse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SuperWarehouse extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("su_ware.fxml"));
        primaryStage.setTitle("Warehouses");
        primaryStage.setScene(new Scene(root, 715, 386));
        primaryStage.show();
    }
}
