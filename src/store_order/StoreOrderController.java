package store_order;

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

public class StoreOrderController implements Initializable {

    @FXML
    private TableView order_table;
    @FXML private TableColumn name;
    @FXML private TableColumn add;
    //@FXML private TableColumn delete;
    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("iPhone X"));


    @Override
    public void initialize(URL url, ResourceBundle rb){
        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));
        add.setCellValueFactory(new PropertyValueFactory<Store, String>("add"));
        //delete.setCellValueFactory(new PropertyValueFactory<Store, String>("delete"));

        order_table.setItems(data);
    }
}
