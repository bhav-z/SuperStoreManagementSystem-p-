package user_items;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import store_main.Store;

import java.net.URL;
import java.util.ResourceBundle;

public class UserItemController implements Initializable {

    @FXML
    private ComboBox<String> filterCombo;
    ObservableList<String> list= FXCollections.observableArrayList("Name", "Price");
    @FXML private TableView category_table;
    @FXML private TableColumn name;
    @FXML private TableColumn explore;
    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("Product1"));

    @Override
    public void initialize(URL url, ResourceBundle rb){
        filterCombo.setItems(list);

        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));
        explore.setCellValueFactory(new PropertyValueFactory<Store, String>("view"));

        category_table.setItems(data);

    }
}
