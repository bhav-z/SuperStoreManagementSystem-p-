package user_product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class UserProductController implements Initializable {

    @FXML private ComboBox<Integer> quantity;
    ObservableList<Integer> list= FXCollections.observableArrayList(1,2,3);

    @Override
    public void initialize(URL url, ResourceBundle rb){
        quantity.setItems(list);
    }
}
