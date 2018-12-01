package su_first;

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

public class FirstController implements Initializable {

    @FXML
    private TableView all_table;
    @FXML private TableColumn name;
    @FXML private TableColumn id;
    @FXML private TableColumn type;
    @FXML private TableColumn admin;
    @FXML private TableColumn view;

    private ObservableList<Order> data4= FXCollections.observableArrayList(new Order("Bandra", "123", "Store", "Raj",
            "45", "7/12/18", "yes"),new Order("Sudooooo", "23", "Store", "Aaj",
            "42", "7/12/18", "yes"),new Order("Aandra", "12223", "Store", "Zaj",
            "46", "7/12/18", "yes"));

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setCellValueFactory(new PropertyValueFactory<Order, String>("sname"));
        id.setCellValueFactory(new PropertyValueFactory<Order, String>("sid"));
        type.setCellValueFactory(new PropertyValueFactory<Order, String>("iname"));
        admin.setCellValueFactory(new PropertyValueFactory<Order, String>("iid"));
        view.setCellValueFactory(new PropertyValueFactory<Order, String>("view"));

        all_table.setItems(data4);
    }
}
