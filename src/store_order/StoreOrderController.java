package store_order;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreOrderController implements Initializable {

    @FXML
    private TableView order_table;
    @FXML private TableColumn name;
    @FXML private TableColumn add;
    //@FXML private TableColumn delete;
    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("iPhone X"));

    private MainClasses.Store store;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));
        add.setCellValueFactory(new PropertyValueFactory<Store, String>("add"));
        //delete.setCellValueFactory(new PropertyValueFactory<Store, String>("delete"));

        order_table.setItems(data);
    }

    public void setPlace(MainClasses.Store store) {
        this.store=store;
    }

    public void viewOrderButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader2=new FXMLLoader();
        loader2.setLocation(getClass().getResource("/store_order_final/storeorderfinal.fxml"));
        Parent user_page = loader2.load();
        Scene user_scene = new Scene(user_page);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(user_scene);
        window.show();
    }
}
