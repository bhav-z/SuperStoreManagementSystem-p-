package store_main;

import ConnectionUtil.ConnectionU;
import MainClasses.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StoreMainController implements Initializable {


    @FXML public TableColumn id;
    @FXML private TableView category_table_s;
    @FXML private TableColumn name;

    private ObservableList<Category> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb){
        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();

        name.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Category, Integer>("id"));

        category_table_s.setItems(data);
        String sql="SELECT * from "+this.store.getName() +"_categories;"   ;
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                data.add(new Category(resultSet.getInt("id") , resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        category_table_s.setItems(data);
    }

    public void searchButtonClicked(ActionEvent actionEvent) {
    }

    public void addCategoryButtonClicked(ActionEvent actionEvent) {
    }

    public void generateOrdersButtonClicked(ActionEvent actionEvent) {
    }

    public void updateDButtonClicked(ActionEvent actionEvent) {
    }

    public void viewButtonClicked(ActionEvent actionEvent) {
    }

    public void updateButtonClicked(ActionEvent actionEvent) {
    }

    public void deleteButtonClicked(ActionEvent actionEvent) {
    }
}
