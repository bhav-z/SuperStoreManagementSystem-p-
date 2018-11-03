package cart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("cart.fxml"));
        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root, 600, 336));
        primaryStage.show();
    }
}
