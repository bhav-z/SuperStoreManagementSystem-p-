package add_item;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddItem extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("additem.fxml"));
        primaryStage.setTitle("Add Item");
        primaryStage.setScene(new Scene(root, 444, 444));
        primaryStage.show();
    }
}
