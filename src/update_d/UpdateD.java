package update_d;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UpdateD extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("updated.fxml"));
        primaryStage.setTitle("Update D");
        primaryStage.setScene(new Scene(root, 414, 235));
        primaryStage.show();
    }
}
