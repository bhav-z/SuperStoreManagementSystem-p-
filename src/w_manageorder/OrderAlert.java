package w_manageorder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrderAlert extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("neworderalert.fxml"));
        primaryStage.setTitle("Manage Orders");
        primaryStage.setScene(new Scene(root, 900, 400));
        primaryStage.show();

    }
}
