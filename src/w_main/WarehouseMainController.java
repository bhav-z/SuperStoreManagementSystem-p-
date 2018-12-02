package w_main;

import ConnectionUtil.ConnectionU;
import MainClasses.Category;
import MainClasses.Warehouse;
import add_category.AddCategory;
import add_category.AddCategoryController;
import inventory_subcategory.StoreSubController;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import store_main.Store;
import update_category.UpdateCategoryController;
import update_d.UpdateD;
import update_d.UpdateDController;
import w_manageorder.OrderAlert;
import w_manageorder.OrderAlertController;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class WarehouseMainController implements Initializable {

    @FXML public Button view_button;
    @FXML public Button update_button;
    @FXML public Button delete_button;
    @FXML public Button back_button;
    @FXML private Button search;
    @FXML private Button add_category_button;
    @FXML private Button manage_orders_button;
    @FXML private Button update_d_button;
    @FXML private TableColumn<Category,String> name;
    @FXML private TableColumn<Category,Integer> id;

    private ObservableList<Category> data = FXCollections.observableArrayList();
    @FXML private TableView<Category> category_table_w;

    private Warehouse warehouse;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //System.out.println(this.warehouse.getName());
        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();

        name.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Category, Integer>("id"));

        String sql="SELECT * from "+this.warehouse.getName() +"_categories;"   ;
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                data.add(new Category(resultSet.getInt("id"),resultSet.getString("name") ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        category_table_w.setItems(data);
    }

    public void setWarehouse(Warehouse w){
        this.warehouse=w;
        //check with database and get warehouse id
        int id=0;
        this.warehouse.setID(id);
    }

    public void searchButtonClicked(ActionEvent actionEvent) {
    }

    public void manageOrdersButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/w_manageorder/neworderalert.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);
        OrderAlertController w=loader.getController();
        w.setWarehouse(this.warehouse);
        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void updateDButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/update_d/updated.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UpdateDController w=loader.getController();
        w.setWarehouse(this.warehouse);

//        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        window.setScene(wmain_scene);
//        window.show();
        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void addCategoryButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/add_category/addcategory.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        AddCategoryController w=loader.getController();
        w.setWarehouse(this.warehouse);

//        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        window.setScene(wmain_scene);
//        window.show();
        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void viewButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/inventory_subcategory/storesub.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

<<<<<<< HEAD
        StoreSubController w=loader.getController();
        w.setPlace(this.warehouse);
        w.setCategory(category_table_w.getSelectionModel().getSelectedItem());

=======
>>>>>>> 6c539d58b3f0da441653b8dcba981ee584cbf93d
//        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        window.setScene(wmain_scene);
//        window.show();
        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void updateButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/update_category/update_category.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        UpdateCategoryController w=loader.getController();
        w.setPlace(this.warehouse);
        w.setCategory(category_table_w.getSelectionModel().getSelectedItem());

        Stage manage=new Stage();
        manage.initModality(Modality.APPLICATION_MODAL);
        manage.setScene(wmain_scene);
        manage.show();
    }

    public void deleteButtonClicked(ActionEvent actionEvent) throws IOException{

        //code to delete category
        Category c=(Category) category_table_w.getSelectionModel().getSelectedItem();
        String c_name=c.getName();

        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();
        try {
            Statement statement=connection.createStatement();
            String tableName=this.warehouse.getName();
            System.out.println(tableName+" "+c_name);
            String sql = "DELETE FROM "+tableName+"_categories WHERE "+tableName+"_categories.category_name = '"+c_name+"';";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/warehouse_main1/waremain1.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(wmain_scene);
        window.show();
    }
}
