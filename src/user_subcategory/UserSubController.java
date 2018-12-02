package user_subcategory;

import MainClasses.Category;
import MainClasses.Subcategory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import store_main.Store;
import user_items.UserItemController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserSubController implements Initializable {
    @FXML
    private ComboBox<String> sortCombo;
    ObservableList<String> list= FXCollections.observableArrayList("Name");
    @FXML private TableView category_table;
    @FXML private TableColumn name;
    @FXML private TableColumn explore;
    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("Smart Phone"));

    private MainClasses.Store store;
    private Category category;

    public void setStore(MainClasses.Store store) {
        this.store = store;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        sortCombo.setItems(list);

        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));
        explore.setCellValueFactory(new PropertyValueFactory<Store, String>("explore"));

        category_table.setItems(data);

    }

    public void exploreButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/user_items/useritem.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UserItemController w=loader.getController();
        w.setStore(this.store);
        w.setSubcategory((Subcategory) category_table.getSelectionModel().getSelectedItem());
        w.setCategory(this.category);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void goToCart(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/cart/cart.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

}
