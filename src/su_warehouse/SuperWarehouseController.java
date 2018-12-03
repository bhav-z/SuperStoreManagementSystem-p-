package su_warehouse;


import ConnectionUtil.ConnectionU;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import w_manageorder.Order;
import w_manageorder.OrderAlertController;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SuperWarehouseController implements Initializable {

    @FXML private TableView ware_table;
    @FXML private TableColumn ware_name;
    @FXML private TableColumn ware_id;
    //@FXML private TableColumn quantity;
    //@FXML private TableColumn date;
    //@FXML private TableColumn feasible;
    //@FXML private TableColumn itemname;
    //@FXML private TableColumn itemid;
    //@FXML private TableColumn fulfill;
    //@FXML private TableColumn forward;
    //@FXML private  TableColumn order;
//    @FXML private  TableColumn vieww;
//    @FXML private  TableColumn linkk;
//    @FXML private TableColumn deletee;

    private ObservableList<Warehouse> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb){
//        storenamee.setCellValueFactory(new PropertyValueFactory<Order, String>("sname"));
//        storeidd.setCellValueFactory(new PropertyValueFactory<Order, String>("sid"));
//        //quantity.setCellValueFactory(new PropertyValueFactory<Order, String>("quantity"));
//        //date.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
//        //itemid.setCellValueFactory(new PropertyValueFactory<Order, String>("iid"));
//        //itemname.setCellValueFactory(new PropertyValueFactory<Order, String>("iname"));
//        //feasible.setCellValueFactory(new PropertyValueFactory<Order, String>("feasible"));
//        deletee.setCellValueFactory(new PropertyValueFactory<Order, String>("delete"));
//        linkk.setCellValueFactory(new PropertyValueFactory<Order, String>("link"));
//        vieww.setCellValueFactory(new PropertyValueFactory<Order, String>("view"));
//
//
//        ware_table.setItems(data);

        ware_name.setCellValueFactory(new PropertyValueFactory<Warehouse, String>("name"));
        ware_id.setCellValueFactory(new PropertyValueFactory<Warehouse, Integer>("id"));

        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();
        try {
            String sql= "SELECT name,id from warehouse_list;";

            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                data.add(new Warehouse(resultSet.getString("name") , resultSet.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ware_table.setItems(data);


    }

    public void addButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/add_warehouse/add_ware.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);
        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void viewButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/w_main/warehouse_main.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);
        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void deleteButtonClicked(ActionEvent actionEvent) {
        //code for deleting a warehouse
    }

    public void linkButtonClicked(ActionEvent actionEvent) {
        //code for changing store link
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/su_main/su_main.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(wmain_scene);
        window.show();
    }
}

