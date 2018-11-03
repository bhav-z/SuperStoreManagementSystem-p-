package add_category;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddCategory extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("addcategory.fxml"));
        primaryStage.setTitle("Add Category");
        primaryStage.setScene(new Scene(root, 480, 203));
        primaryStage.show();
    }
}
