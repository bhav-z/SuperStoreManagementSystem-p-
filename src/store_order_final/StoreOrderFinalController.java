package store_order_final;

import cart.Cart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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

    public void sendButtonClicked(ActionEvent actionEvent) {
        //code to add order data to backend

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }
}
