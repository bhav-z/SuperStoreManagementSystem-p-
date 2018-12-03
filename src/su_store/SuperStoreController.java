package su_store;

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
import javafx.stage.Stage;
import w_manageorder.Order;

import java.io.IOException;
import java.net.URL;
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
    @FXML private  TableColumn view;
    @FXML private  TableColumn link;
    @FXML private  TableColumn delete;


    private ObservableList<Order> data= FXCollections.observableArrayList(new Order("Bandra", "123", "iPhone X", "10",
            "45", "7/12/18", "yes"));


    @Override
    public void initialize(URL url, ResourceBundle rb){
        storename.setCellValueFactory(new PropertyValueFactory<Order, String>("sname"));
        storeid.setCellValueFactory(new PropertyValueFactory<Order, String>("sid"));
        //quantity.setCellValueFactory(new PropertyValueFactory<Order, String>("quantity"));
        //date.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
        //itemid.setCellValueFactory(new PropertyValueFactory<Order, String>("iid"));
        //itemname.setCellValueFactory(new PropertyValueFactory<Order, String>("iname"));
        //feasible.setCellValueFactory(new PropertyValueFactory<Order, String>("feasible"));
        delete.setCellValueFactory(new PropertyValueFactory<Order, String>("delete"));
        link.setCellValueFactory(new PropertyValueFactory<Order, String>("link"));
        view.setCellValueFactory(new PropertyValueFactory<Order, String>("view"));


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
}
