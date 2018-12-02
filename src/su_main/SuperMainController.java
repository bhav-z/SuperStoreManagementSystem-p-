package su_main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import w_manageorder.OrderAlertController;

import java.io.IOException;

public class SuperMainController {

    public void storesButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/su_store/su_store.fxml"));
        Parent stores_page = loader.load();
        Scene stores_scene = new Scene(stores_page);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(stores_scene);
        window.show();
    }

    public void warehousesButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/su_warehouse/su_ware.fxml"));
        Parent stores_page = loader.load();
        Scene stores_scene = new Scene(stores_page);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(stores_scene);
        window.show();
    }

    public void usersButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/su_users/users.fxml"));
        Parent stores_page = loader.load();
        Scene stores_scene = new Scene(stores_page);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(stores_scene);
        window.show();
    }
}
