package link_warehouse;

import MainClasses.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LinkWarehouseController implements Initializable {

    @FXML private TableView ware_table;
    @FXML private TableColumn name;
    @FXML private TableColumn id;
    @FXML private TextField searchBar;
    private MainClasses.Store store;

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void searchFnc(ActionEvent actionEvent) {
    }

    public void linkButtonClicked(ActionEvent actionEvent) {
        //just update store stored in the store variable's linked_warehouse to the selected warehouse in the table

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }
}
