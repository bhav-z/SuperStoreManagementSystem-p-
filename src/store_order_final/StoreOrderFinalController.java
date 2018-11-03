package store_order_final;

import cart.Cart;
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

public class StoreOrderFinalController implements Initializable {

    @FXML
    private TableView order_table;
    @FXML private TableColumn name;
    @FXML private TableColumn id;
    @FXML private TableColumn quantity;
    @FXML private TableColumn date;
    @FXML private TableColumn delete;
    private ObservableList<Cart> data= FXCollections.observableArrayList(new Cart("iPhone X", "45", "80,000"));


    @Override
    public void initialize(URL url, ResourceBundle rb){
        name.setCellValueFactory(new PropertyValueFactory<Cart, String>("name"));
        //add.setCellValueFactory(new PropertyValueFactory<Store, String>("add"));
        quantity.setCellValueFactory(new PropertyValueFactory<Cart, String>("quantity"));
        date.setCellValueFactory(new PropertyValueFactory<Cart, String>("date"));
        id.setCellValueFactory(new PropertyValueFactory<Cart, String>("ID"));
        delete.setCellValueFactory(new PropertyValueFactory<Cart, String>("del"));

        order_table.setItems(data);
    }
}
