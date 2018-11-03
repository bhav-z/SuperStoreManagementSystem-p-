package su_store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SuperStore extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("su_store.fxml"));
        primaryStage.setTitle("Stores");
        primaryStage.setScene(new Scene(root, 715, 386));
        primaryStage.show();
    }
}
