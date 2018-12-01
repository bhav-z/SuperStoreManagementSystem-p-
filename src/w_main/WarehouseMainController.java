package w_main;

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

public class WarehouseMainController implements Initializable {

    @FXML
    private TableView category_tablee;
    @FXML private TableColumn namee;
    @FXML private TableColumn updatee;
    @FXML private TableColumn deletee;
    @FXML private TableColumn go;
    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("Electronics"));

    private Warehouse warehouse;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        namee.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));
        updatee.setCellValueFactory(new PropertyValueFactory<Store, String>("update"));
        deletee.setCellValueFactory(new PropertyValueFactory<Store, String>("delete"));
        go.setCellValueFactory(new PropertyValueFactory<Store, String>("view"));
        category_tablee.setItems(data);
    }

    public void setWarehouse(String s){
        this.warehouse=new Warehouse();
        this.warehouse.setName(s);
    }
}
