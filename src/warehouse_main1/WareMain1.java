package warehouse_main1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * class to test waremain1.fxml
 */
public class WareMain1 extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("waremain1.fxml"));
        primaryStage.setTitle(" ");
        primaryStage.setScene(new Scene(root, 411, 220));
        primaryStage.show();
    }
}
