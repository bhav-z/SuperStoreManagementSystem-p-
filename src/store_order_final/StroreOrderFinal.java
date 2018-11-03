package store_order_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StroreOrderFinal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("storeorderfinal.fxml"));
        primaryStage.setTitle("Final Order");
        primaryStage.setScene(new Scene(root, 600, 370));
        primaryStage.show();
    }
}
