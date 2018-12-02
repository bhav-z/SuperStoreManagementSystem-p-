package w_manageorder;

import MainClasses.Warehouse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderAlertController implements Initializable {

    @FXML
    private TableView order_table;
    @FXML private TableColumn storename;
    @FXML private TableColumn storeid;
    @FXML private TableColumn quantity;
    @FXML private TableColumn date;
    @FXML private TableColumn feasible;
    @FXML private TableColumn itemname;
    @FXML private TableColumn itemid;
    @FXML private TableColumn fulfill;
    @FXML private TableColumn forward;
    //@FXML private TableColumn order;

    private ObservableList<Order> data= FXCollections.observableArrayList(new Order("Bandra", "123", "iPhone X", "10",
            "3", "400", "yes"));

    private Warehouse warehouse;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        storename.setCellValueFactory(new PropertyValueFactory<Order, String>("sname"));
        storeid.setCellValueFactory(new PropertyValueFactory<Order, String>("sid"));
        quantity.setCellValueFactory(new PropertyValueFactory<Order, String>("quantity"));
        date.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
        itemid.setCellValueFactory(new PropertyValueFactory<Order, String>("iid"));
        itemname.setCellValueFactory(new PropertyValueFactory<Order, String>("iname"));
        feasible.setCellValueFactory(new PropertyValueFactory<Order, String>("feasible"));
        fulfill.setCellValueFactory(new PropertyValueFactory<Order, String>("fulfill"));
        forward.setCellValueFactory(new PropertyValueFactory<Order, String>("forward"));

        order_table.setItems(data);
    }

    public void setWarehouse(Warehouse w){
        this.warehouse=w;
    }


    public void doneButtonClicked(ActionEvent actionEvent) {
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }
}
