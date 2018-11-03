package su_users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import w_manageorder.Order;

import java.net.URL;
import java.util.ResourceBundle;

public class UsersController implements Initializable {

    @FXML private TableView users_table;
    @FXML private TableColumn name;
    @FXML private TableColumn id;
    @FXML private TableColumn type;
    @FXML private TableColumn setpassword;
    @FXML private TableColumn delete;

    private ObservableList<Order> data2= FXCollections.observableArrayList(new Order("Raj", "13", "StoreAdmin", "10",
            "45", "7/12/18", "yes"));

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setCellValueFactory(new PropertyValueFactory<Order, String>("sname"));
        id.setCellValueFactory(new PropertyValueFactory<Order, String>("sid"));
        type.setCellValueFactory(new PropertyValueFactory<Order, String>("iname"));
        setpassword.setCellValueFactory(new PropertyValueFactory<Order, String>("setpass"));
        delete.setCellValueFactory(new PropertyValueFactory<Order, String>("delete"));

        users_table.setItems(data2);
    }

}
