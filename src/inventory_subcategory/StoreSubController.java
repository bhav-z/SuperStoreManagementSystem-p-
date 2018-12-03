package inventory_subcategory;

import ConnectionUtil.ConnectionU;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Class for modifying subcategories
 */
public class StoreSubController implements Initializable {

    @FXML
    private TableView category_table_s;
    @FXML private TableColumn name;
    @FXML private TableColumn id;
    private ObservableList<Store> dataS= FXCollections.observableArrayList(new Store("Smart Phone"));
    private ObservableList<Store> dataW= FXCollections.observableArrayList(new Store("Smart Phone"));

    private Place place;
    private String categoryNAME;
    private Category category;
    private String WAREHOUSE_NAME;

    public void setTableText(String name){
        /*this.WAREHOUSE_NAME=name;
        //System.out.println(this.warehouse.getName());
        name.setCellValueFactory(new PropertyValueFactory<St, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Category, Integer>("id"));
        String sql;
        try {
            sql="SELECT * from "+warehouseName +"_categories;"   ;
        }catch (Exception e){
            System.out.println("NOOOOOOOO");
            sql="SELECT * from "+"Marine" +"_categories;"   ;
        }
        System.out.println(sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                data.add(new Category(resultSet.getInt("category_id"),resultSet.getString("category_name") ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        category_table_w.setItems(data);*/
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        System.out.println(this.getClass());
        name.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));

        category_table_s.setItems(dataW);
    }

    public void setPlace(Place warehouse) {
        this.place=warehouse;
    }

    public void setCategory(Object selectedItem) {
        this.category=(Category) selectedItem;
    }

    public void searchButtonClicked(ActionEvent actionEvent) throws IOException{
    }

    /**
     * Function for adding subcategory in a chosen subcategory
     * @param actionEvent argument for detecting button click
     * @throws IOException known thrown exception by the program
     */
    public void addSubcategoryButtonClicked(ActionEvent actionEvent,String NAME) throws IOException{

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/add_subcategory/addsub.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        AddSubController w=loader.getController();
        w.setPlace(this.place);
//        w.setCategory(this.category);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    /**
     * Function to view the chosen subcategory
     * @param actionEvent argument for detecting button click
     * @throws IOException known thrown exception by the program
     */
    public void viewButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/inventory_items/storeitem.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        StoreItemController w=loader.getController();
        w.setPlace(this.place);
        w.setSubcategory(category_table_s.getSelectionModel().getSelectedItem());
//        w.setCategory(this.category);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }
    /**
     * Function to modify the chosen subcategory
     * @param actionEvent argument for detecting button click
     * @throws IOException known thrown exception by the program
     */
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
    /**
     * Function to delete the chosen subcategory
     * @param actionEvent argument for detecting button click
     * @throws IOException known thrown exception by the program
     */
    public void deleteButtonClicked(ActionEvent actionEvent) throws IOException{
    }


}
