package w_main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WarehouseMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("wmain.fxml"));
        primaryStage.setTitle("WarehouseName");
        primaryStage.setScene(new Scene(root, 715, 383));
        primaryStage.show();
    }
}
