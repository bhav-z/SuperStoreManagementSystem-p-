package user_product;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserProductController implements Initializable {

    @FXML private ComboBox<Integer> quantity;
    ObservableList<Integer> list= FXCollections.observableArrayList(1,2,3);

    private MainClasses.Store store;
    private Category category;
    private Subcategory subcategory;
    private Item item;

    /**
     * indicates current item
     * @param item
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * indicates current category
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * indicates current subcategory
     * @param subcategory
     */
    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    /**
     * indicates current store
     * @param store
     */
    public void setStore(MainClasses.Store store) {
        this.store=store;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        quantity.setItems(list);
        //code to show details of item
    }

    public void viewButtonClicked(ActionEvent actionEvent) throws IOException {
       //code for adding item to cart
        Stage win = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        win.close();
    }
}
