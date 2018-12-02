package inventory_subcategory;

import MainClasses.Warehouse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import store_main.Store;

import java.net.URL;
import java.util.ResourceBundle;

public class StoreSubController implements Initializable {

    @FXML
    private TableView category_table;
    @FXML private TableColumn name;
    @FXML private TableColumn update;
    @FXML private TableColumn delete;
    @FXML private TableColumn go;
    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("Smart Phone"));

    private Warehouse warehouse;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));
        update.setCellValueFactory(new PropertyValueFactory<Store, String>("update"));
        delete.setCellValueFactory(new PropertyValueFactory<Store, String>("delete"));
        go.setCellValueFactory(new PropertyValueFactory<Store, String>("view"));

        category_table.setItems(data);
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse=warehouse;
    }
}
