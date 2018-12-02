package store_main;

import ConnectionUtil.ConnectionU;
import MainClasses.Category;
import add_category.AddCategoryController;
import inventory_subcategory.StoreSubController;
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
import store_order.StoreOrderController;
import update_category.UpdateCategoryController;
import update_d.UpdateDController;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StoreMainController implements Initializable {


    @FXML public TableColumn id;
    @FXML private TableView category_table_s;
    @FXML private TableColumn name;

    private String storename;
    private MainClasses.Store store;

    private ObservableList<Category> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb){
        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();

        name.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Category, Integer>("id"));

//        category_table_s.setItems(data);
//        String sql="SELECT * from "+this.store.getName() +"_categories;"   ;
//        try {
//            Statement statement=connection.createStatement();
//            ResultSet resultSet=statement.executeQuery(sql);
//            while (resultSet.next()){
//                data.add(new Category(resultSet.getInt("id") , resultSet.getString("name")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        category_table_s.setItems(data);
    }

    public void searchButtonClicked(ActionEvent actionEvent) throws IOException{
    }

    public void addCategoryButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/add_category/addcategory.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        AddCategoryController w=loader.getController();
        w.setPlace(this.store);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void generateOrdersButtonClicked(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/store_order/storeorder.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        StoreOrderController w=loader.getController();

        w.setPlace(this.store);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void updateDButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/update_d/updated.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UpdateDController w=loader.getController();

        w.setPlace(this.store);

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void viewButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/inventory_subcategory/storesub.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        StoreSubController w=loader.getController();
        w.setPlace(this.store);
        w.setCategory(category_table_s.getSelectionModel().getSelectedItem());

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void updateButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/update_category/update_category.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UpdateCategoryController w=loader.getController();
        w.setPlace(this.store);
        w.setCategory(category_table_s.getSelectionModel().getSelectedItem());

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void deleteButtonClicked(ActionEvent actionEvent) {
    }

    public void setStoreName(String s) {
        this.storename=s;
        this.store= new MainClasses.Store() ;
    }
}
