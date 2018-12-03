package su_store;

import ConnectionUtil.ConnectionU;
import MainClasses.Store;
import MainClasses.Warehouse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import link_warehouse.LinkWarehouseController;
import store_main.StoreMainController;
import w_main.WarehouseMainController;
import w_manageorder.Order;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SuperStoreController implements Initializable {

    @FXML
    private TableView store_table;
    @FXML private TableColumn storename;
    @FXML private TableColumn storeid;
    //@FXML private TableColumn quantity;
    //@FXML private TableColumn date;
    //@FXML private TableColumn feasible;
    //@FXML private TableColumn itemname;
    //@FXML private TableColumn itemid;
    //@FXML private TableColumn fulfill;
    //@FXML private TableColumn forward;
    //@FXML private  TableColumn order;
//    @FXML private  TableColumn view;
//    @FXML private  TableColumn link;
//    @FXML private  TableColumn delete;


    private ObservableList<Store> data= FXCollections.observableArrayList(new Store("Sunrise", 123),
            new Store("Sudo Foods",3));
    @FXML
    private TextField searchBar;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        storename.setCellValueFactory(new PropertyValueFactory<Order, String>("name"));
        storeid.setCellValueFactory(new PropertyValueFactory<Order, String>("ID"));
        //quantity.setCellValueFactory(new PropertyValueFactory<Order, String>("quantity"));
        //date.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
        //itemid.setCellValueFactory(new PropertyValueFactory<Order, String>("iid"));
        //itemname.setCellValueFactory(new PropertyValueFactory<Order, String>("iname"));
        //feasible.setCellValueFactory(new PropertyValueFactory<Order, String>("feasible"));


        store_table.setItems(data);
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/su_main/su_main.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(wmain_scene);
        window.show();
    }

    public void searchFnc(ActionEvent actionEvent) {
        store_table.getItems().clear();
        storename.setCellValueFactory(new PropertyValueFactory<Store, String>("name"));
        storeid.setCellValueFactory(new PropertyValueFactory<Store, Integer>("ID"));

        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();
        try {
            String sql= "SELECT name,id from store_list WHERE name like '%"+searchBar.getText().trim()+"%';";

            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                data.add(new Store(resultSet.getString("name") , resultSet.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        store_table.setItems(data);
    }

    public void deleteButtonClicked(ActionEvent actionEvent) {
    }

    public void linkButtonClicked(ActionEvent actionEvent) {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/link_warehouse/link_ware.fxml"));
        try {
            Parent root = (Parent)loader.load();
        }catch (IOException e){
            System.out.println("OOPS");
        }

        Store w2=(MainClasses.Store) store_table.getSelectionModel().getSelectedItem();
        LinkWarehouseController ok = loader.getController();
        ok.setStore(w2);
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show(); //AndWait();
    }

    public void viewButtonClicked(ActionEvent actionEvent) {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/store_main/storemain.fxml"));
        try {
            Parent root = (Parent)loader.load();
        }catch (IOException e){
            System.out.println("OOPS");
        }

        Store w2=(MainClasses.Store) store_table.getSelectionModel().getSelectedItem();
        StoreMainController ok = loader.getController();
        ok.setStore(w2);
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show(); //AndWait();
    }
}
