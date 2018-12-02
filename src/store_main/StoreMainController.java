package store_main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StoreMainController implements Initializable {


    @FXML private TableView category_table_s;
    @FXML private TableColumn name;

    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("Electronics"));


    @Override
    public void initialize(URL url, ResourceBundle rb){
        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));

        category_table_s.setItems(data);
    }

    public void searchButtonClicked(ActionEvent actionEvent) {
    }

    public void addCategoryButtonClicked(ActionEvent actionEvent) {
    }

    public void generateOrdersButtonClicked(ActionEvent actionEvent) {
    }

    public void updateDButtonClicked(ActionEvent actionEvent) {
    }

    public void viewButtonClicked(ActionEvent actionEvent) {
    }

    public void updateButtonClicked(ActionEvent actionEvent) {
    }

    public void deleteButtonClicked(ActionEvent actionEvent) {
    }
}
