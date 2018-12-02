package user_main;

import MainClasses.Cart;
import MainClasses.Category;
import inventory_subcategory.StoreSubController;
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
import user_subcategory.UserSubController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserMainController implements Initializable {

    @FXML
    private ComboBox<String> filterCombo;
    ObservableList<String> list= FXCollections.observableArrayList("Name");
    @FXML private TableView category_table;
    @FXML private TableColumn name;

    private MainClasses.Store store;

    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("Electronics"));

    @Override
    public void initialize(URL url, ResourceBundle rb){
        filterCombo.setItems(list);

        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));

        category_table.setItems(data);

    }

    /**
     * indicates current store
     * @param store
     */
    public void setStore(MainClasses.Store store) {
        this.store = store;
    }

    /**
     * switch to subcategories of selected category
     * @param actionEvent
     * @throws IOException
     */
    public void exploreButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/user_subcategory/usersub.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UserSubController w=loader.getController();
        w.setStore(this.store);
        w.setCategory((Category) category_table.getSelectionModel().getSelectedItem());

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    /**
     * view cart
     * @param actionEvent
     * @throws IOException
     */
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
