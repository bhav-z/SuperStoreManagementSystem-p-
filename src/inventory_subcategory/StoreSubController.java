package inventory_subcategory;

import MainClasses.Category;
import MainClasses.Place;
import MainClasses.Subcategory;
import MainClasses.Warehouse;
import add_subcategory.AddSubController;
import inventory_items.StoreItemController;
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
import update_category.UpdateCategoryController;
import update_subcategory.UpdateSubcategoryController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreSubController implements Initializable {

    @FXML
    private TableView category_table_s;
    @FXML private TableColumn name;
    @FXML private TableColumn id;
    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("Smart Phone"));

    private Place place;
    private Category category;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));


        category_table_s.setItems(data);
    }

    public void setPlace(Place warehouse) {
        this.place=warehouse;
    }

    public void setCategory(Object selectedItem) {
        this.category=(Category) selectedItem;
    }

    public void searchButtonClicked(ActionEvent actionEvent) throws IOException{
    }

    public void addSubcategoryButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/add_subcategory/addsub.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        AddSubController w=loader.getController();
        w.setPlace(this.place);
        w.setCategory(this.category);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void viewButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/inventory_items/storeitem.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        StoreItemController w=loader.getController();
        w.setPlace(this.place);
        w.setSubcategory(category_table_s.getSelectionModel().getSelectedItem());
        w.setCategory(this.category);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void updateButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/update_subcategory/update_subcategory.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UpdateSubcategoryController w=loader.getController();
        w.setPlace(this.place);
        w.setSubcategory((Subcategory) category_table_s.getSelectionModel().getSelectedItem());

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void deleteButtonClicked(ActionEvent actionEvent) throws IOException{
    }


}
