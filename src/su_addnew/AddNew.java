package su_addnew;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddNew extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("su_addnew.fxml"));
        primaryStage.setTitle("Add New Store/Warehouse");
        primaryStage.setScene(new Scene(root, 470, 251));
        primaryStage.show();
    }
}
