package w_main;

import ConnectionUtil.ConnectionU;
import MainClasses.Warehouse;
import add_category.AddCategory;
import add_category.AddCategoryController;
import inventory_subcategory.StoreSubController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import store_main.Store;
import update_category.UpdateCategoryController;
import update_d.UpdateD;
import update_d.UpdateDController;
import w_manageorder.OrderAlert;
import w_manageorder.OrderAlertController;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class WarehouseMainController implements Initializable {

    @FXML
    private Button search;
    @FXML private Button add_category_button;
    @FXML private Button manage_orders_button;
    @FXML private Button update_d_button;
    @FXML
    private TableView category_table_w;
    @FXML private TableColumn name;
    @FXML private TableColumn id;

    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("Electronics"));

    private Warehouse warehouse;


    @Override
    public void initialize(URL url, ResourceBundle rb){
//        namee.setCellValueFactory(new PropertyValueFactory<Store, String>("category_name"));
//        updatee.setCellValueFactory(new PropertyValueFactory<Store, String>("update"));
//        deletee.setCellValueFactory(new PropertyValueFactory<Store, String>("delete"));
//        go.setCellValueFactory(new PropertyValueFactory<Store, String>("view"));
//        category_tablee.setItems(data);
    }

    public void setWarehouse(Warehouse w){
        this.warehouse=w;
        //check with database and get warehouse id
        int id=0;
        this.warehouse.setId(id);
    }

    public void searchButtonClicked(ActionEvent actionEvent) {
    }

    public void manageOrdersButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/w_manageorder/neworderalert.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        OrderAlertController w=loader.getController();
        w.setWarehouse(this.warehouse);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(wmain_scene);
        window.show();
    }

    public void updateDButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/update_d/updated.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UpdateDController w=loader.getController();
        w.setWarehouse(this.warehouse);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(wmain_scene);
        window.show();
    }

    public void addCategoryButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/add_category/addcategory.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        AddCategoryController w=loader.getController();
        w.setWarehouse(this.warehouse);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(wmain_scene);
        window.show();
    }

    public void viewButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/inventory_subcategory/storesub.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        StoreSubController w=loader.getController();
        w.setWarehouse(this.warehouse);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(wmain_scene);
        window.show();
    }

    public void updateButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/update_category/update_category.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UpdateCategoryController w=loader.getController();
        w.setWarehouse(this.warehouse);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(wmain_scene);
        window.show();
    }

    public void deleteButtonClicked(ActionEvent actionEvent) throws IOException{
        //code to delete category
        /*
        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();
        try {
            Statement statement=connection.createStatement();
            String tableName="";
            String sql = "SELECT * FROM "+tableName+" WHERE username = '"+usernameField.getText()+"' AND password = '"+passwordField.getText()+"';";
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
                //isConnected.setText("Connected");
            }
            else {
                //isConnected.setText("Not Connected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

}
