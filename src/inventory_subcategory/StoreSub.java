package inventory_subcategory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoreSub extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws  Exception{

        Parent root = FXMLLoader.load(getClass().getResource("storesub.fxml"));
        primaryStage.setTitle("Subcategory");
        primaryStage.setScene(new Scene(root, 715, 400));
        primaryStage.show();

    }
}
