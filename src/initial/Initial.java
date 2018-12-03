package initial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Initial extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("initial.fxml"));
        primaryStage.setTitle("Initial");
        primaryStage.setScene(new Scene(root, 446, 242));
        primaryStage.show();
        primaryStage.getIcons().add(new Image("file:C:\\Users\\A\\Pictures\\stego.jpg"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
