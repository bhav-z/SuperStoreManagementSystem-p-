package su_warehouse;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import w_manageorder.Order;

import java.net.URL;
import java.util.ResourceBundle;

public class SuperWarehouseController implements Initializable {

    @FXML
    private TableView ware_table;
    @FXML private TableColumn storenamee;
    @FXML private TableColumn storeidd;
    //@FXML private TableColumn quantity;
    //@FXML private TableColumn date;
    //@FXML private TableColumn feasible;
    //@FXML private TableColumn itemname;
    //@FXML private TableColumn itemid;
    //@FXML private TableColumn fulfill;
    //@FXML private TableColumn forward;
    //@FXML private  TableColumn order;
    @FXML private  TableColumn vieww;
    @FXML private  TableColumn linkk;
    @FXML private TableColumn deletee;

    private ObservableList<Order> data= FXCollections.observableArrayList(new Order("Worli", "13", "iPhone X", "10",
            "45", "7/12/18", "yes"));


    @Override
    public void initialize(URL url, ResourceBundle rb){
        storenamee.setCellValueFactory(new PropertyValueFactory<Order, String>("sname"));
        storeidd.setCellValueFactory(new PropertyValueFactory<Order, String>("sid"));
        //quantity.setCellValueFactory(new PropertyValueFactory<Order, String>("quantity"));
        //date.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
        //itemid.setCellValueFactory(new PropertyValueFactory<Order, String>("iid"));
        //itemname.setCellValueFactory(new PropertyValueFactory<Order, String>("iname"));
        //feasible.setCellValueFactory(new PropertyValueFactory<Order, String>("feasible"));
        deletee.setCellValueFactory(new PropertyValueFactory<Order, String>("delete"));
        linkk.setCellValueFactory(new PropertyValueFactory<Order, String>("link"));
        vieww.setCellValueFactory(new PropertyValueFactory<Order, String>("view"));


        ware_table.setItems(data);
    }
}

