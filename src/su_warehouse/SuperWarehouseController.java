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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import w_main.WarehouseMainController;
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

    public Button searchBtn;
    public TextField searchBar;
    @FXML private TableView ware_table;
    @FXML private TableColumn name;
    @FXML private TableColumn id;

    private ObservableList<Warehouse> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb){
//        storenamee.setCellValueFactory(new PropertyValueFactory<Order, String>("sname"));
//        storeidd.setCellValueFactory(new PropertyValueFactory<Order, String>("sid"));
//        quantity.setCellValueFactory(new PropertyValueFactory<Order, String>("quantity"));
//        date.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
//        itemid.setCellValueFactory(new PropertyValueFactory<Order, String>("iid"));
//        itemname.setCellValueFactory(new PropertyValueFactory<Order, String>("iname"));
//        feasible.setCellValueFactory(new PropertyValueFactory<Order, String>("feasible"));
//        deletee.setCellValueFactory(new PropertyValueFactory<Order, String>("delete"));
//        linkk.setCellValueFactory(new PropertyValueFactory<Order, String>("link"));
//        vieww.setCellValueFactory(new PropertyValueFactory<Order, String>("view"));
//        ware_table.setItems(data);

        name.setCellValueFactory(new PropertyValueFactory<Warehouse, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Warehouse, Integer>("ID"));

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
        ware_table.refresh();


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
        try {
            Parent root = (Parent)loader.load();
        }catch (IOException e){
            System.out.println("OOPS");
        }

        Warehouse w2=(Warehouse) ware_table.getSelectionModel().getSelectedItem();
        WarehouseMainController ok = loader.getController();
        ok.setWarehouse(w2);
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show(); //AndWait();
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

    public void searchFnc(ActionEvent actionEvent) {
        ware_table.getItems().clear();
        name.setCellValueFactory(new PropertyValueFactory<Warehouse, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Warehouse, Integer>("ID"));

        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();
        try {
            String sql= "SELECT name,id from warehouse_list WHERE name like '%"+searchBar.getText().trim()+"%';";

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
}

