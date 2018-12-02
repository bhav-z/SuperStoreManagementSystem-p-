package user_items;

import MainClasses.Category;
import MainClasses.Item;
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
import user_product.UserProduct;
import user_product.UserProductController;

import java.io.IOException;
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

    private MainClasses.Store store;
    private Category category;
    private Subcategory subcategory;

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public void setStore(MainClasses.Store store) {
        this.store=store;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        filterCombo.setItems(list);

        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));
        explore.setCellValueFactory(new PropertyValueFactory<Store, String>("view"));

        category_table.setItems(data);

    }


    public void viewButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/user_product/userproduct.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UserProductController w=loader.getController();
        w.setStore(this.store);
        w.setSubcategory(this.subcategory);
        w.setCategory(this.category);
        w.setItem((Item) category_table.getSelectionModel().getSelectedItem());

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
