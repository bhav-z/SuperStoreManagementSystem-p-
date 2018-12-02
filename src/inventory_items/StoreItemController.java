package inventory_items;

import MainClasses.Category;
import MainClasses.Place;
import MainClasses.Subcategory;
import add_item.AddItemController;
import add_subcategory.AddSubController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import store_main.Store;
import update_item.UpdateItemController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreItemController implements Initializable {

    @FXML private TableColumn id;
    @FXML
    private TableView item_table;
    @FXML private TableColumn name;
    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("Electronics"));

    private Place place;
    private Subcategory subcategory;
    private Category category;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));

        item_table.setItems(data);

    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPlace(Place warehouse) {
        this.place=warehouse;
    }

    public void setSubcategory(Object selectedItem) {
        this.subcategory =(Subcategory) selectedItem;
    }


    public void addItemButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/add_item/additem.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        AddItemController w=loader.getController();
        w.setPlace(this.place);
        w.setCategory(this.category);
        w.setSubcategory(this.subcategory);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void deleteButtonClicked(ActionEvent actionEvent) {
        //code to delete an item
    }

    public void updateButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/update_item/update_item.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UpdateItemController w=loader.getController();
        w.setPlace(this.place);
        w.setCategory(this.category);
        w.setSubcategory(this.subcategory);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();

    }


    public void searchButtonClicked(ActionEvent actionEvent) {
    }
}
