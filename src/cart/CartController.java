package cart;

import ConnectionUtil.ConnectionU;
import MainClasses.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Controller class for Cart
 */
public class CartController implements Initializable {

    @FXML private TextField total;
    @FXML private TableView table;
    @FXML private TableColumn product;
    @FXML private TableColumn quantity;
    @FXML private TableColumn cost;
    @FXML private TableColumn delete;
    private ObservableList<Cart> data= FXCollections.observableArrayList();

    /**
     * Program to initialise the values in the cart, received from sql server
     * @param url first argument
     * @param rb second argument
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        product.setCellValueFactory(new PropertyValueFactory<Cart, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<Cart, String>("quantity"));
        cost.setCellValueFactory(new PropertyValueFactory<Cart, String>("cost"));
        delete.setCellValueFactory(new PropertyValueFactory<Cart, String>("del"));

        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();

//        name.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
//        id.setCellValueFactory(new PropertyValueFactory<Category, Integer>("id"));

        String sql="SELECT * from cart;"   ;
        int costt=0;
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                data.add(
                        new Cart(resultSet.getString("name") , resultSet.getInt("quantity") , resultSet.getInt("cost")));
                costt+=resultSet.getInt("quantity")*resultSet.getInt("cost");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.setItems(data);
        total.setText(costt+"");
        total.setEditable(false);
    }

    public void backButtonClicked(ActionEvent actionEvent) {
        Stage win = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        win.close();
    }
}
