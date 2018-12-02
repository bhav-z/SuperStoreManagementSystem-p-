package initial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import login.LoginController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class InitialController {

    @FXML private Button SuperUser;
    @FXML private Button WarehouseAdmin;
    @FXML private Button StoreAdmin;
    @FXML private Button Guest;

    public void buttonClickedForLogin(ActionEvent actionEvent) throws IOException {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/login/sign_in.fxml"));
            Parent login_page = loader.load();
            Scene login_scene = new Scene(login_page);
            LoginController login=loader.getController();
            login.setTypeOfUser(((Button)actionEvent.getSource()).getText());
        System.out.println(loader.getLocation());

            //This line gets the Stage information
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

            window.setScene(login_scene);
            window.show();

    }

    public void guestButtonClicked(ActionEvent actionEvent) throws IOException{
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/user_main/usermain.fxml"));
            Parent user_main_page=loader.load();
            Scene user_main_scene=new Scene(user_main_page);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(user_main_scene);
            window.show();
    }

    
}
