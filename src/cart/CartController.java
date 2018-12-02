package cart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML private TableView table;
    @FXML private TableColumn product;
    @FXML private TableColumn quantity;
    @FXML private TableColumn cost;
    @FXML private TableColumn delete;
    private ObservableList<Cart> data= FXCollections.observableArrayList(new Cart("Samsung A1", "2", "40,000"));

    @Override
    public void initialize(URL url, ResourceBundle rb){
        product.setCellValueFactory(new PropertyValueFactory<Cart, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<Cart, String>("quantity"));
        cost.setCellValueFactory(new PropertyValueFactory<Cart, String>("cost"));
        delete.setCellValueFactory(new PropertyValueFactory<Cart, String>("del"));

        table.setItems(data);
    }

    public void backButtonClicked(ActionEvent actionEvent) {
        Stage win = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        win.close();
    }
}
