package w_alert;

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

public class AlertController implements Initializable {

    @FXML
    private TableView order_table;
    //@FXML private TableColumn storename;
    //@FXML private TableColumn storeid;
    @FXML private TableColumn quantity;
    @FXML private TableColumn date;
    //@FXML private TableColumn feasible;
    @FXML private TableColumn itemname;
    @FXML private TableColumn itemid;
    //@FXML private TableColumn fulfill;
    //@FXML private TableColumn forward;
    @FXML private  TableColumn order;

    private ObservableList<Order> data= FXCollections.observableArrayList(new Order("Bandra", "123", "iPhone X", "10",
            "45", "7/12/18", "yes"));


    @Override
    public void initialize(URL url, ResourceBundle rb){
        //storename.setCellValueFactory(new PropertyValueFactory<Order, String>("sname"));
        //storeid.setCellValueFactory(new PropertyValueFactory<Order, String>("sid"));
        quantity.setCellValueFactory(new PropertyValueFactory<Order, String>("quantity"));
        date.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
        itemid.setCellValueFactory(new PropertyValueFactory<Order, String>("iid"));
        itemname.setCellValueFactory(new PropertyValueFactory<Order, String>("iname"));
        //feasible.setCellValueFactory(new PropertyValueFactory<Order, String>("feasible"));
        //fulfill.setCellValueFactory(new PropertyValueFactory<Order, String>("fulfill"));
        //forward.setCellValueFactory(new PropertyValueFactory<Order, String>("forward"));
        order.setCellValueFactory(new PropertyValueFactory<Order, String>("order"));


        order_table.setItems(data);
    }
}
