package add_warehouse;

import ConnectionUtil.ConnectionU;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Controller class for Adding Warehouses
 */
@SuppressWarnings("ALL")
public class AddWarehouseController {
    @FXML
    private Button add;
    @FXML
    private TextField name;
    @FXML
    private TextField dinput; //YET TO BE IMPLEMENTED

    /**
     * Button to Add warehouse and make subsequent classes on sql server
     * @param actionEvent argument to detect click on Add button
     * @throws IOException known exception that is thrown
     */
    public void addButtonClicked(ActionEvent actionEvent) throws IOException{
        //code to add warehouse
        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();
        try {
            Statement statement=connection.createStatement();
            String warehousename1=name.getText().trim();
//            String Dinput=dinput.getText().trim();
            //THERES NO CONNECTION BETWEEN THE VALUES IN WAREHOUSE_LIST AND ITS SUBSEQUENT 3 TABLES
            String sql0="INSERT INTO warehouse_list" +
                    " (name,id,D,if_order) " +
                    "VALUES (" +
                    "'"+warehousename1+"'," +
                    "'"+warehousename1.hashCode()+"'," +
                    "'"+12+"',"+
                    0 +");";
            statement.executeUpdate(sql0);
            //https://stackoverflow.com/questions/6260688/how-do-i-use-cascade-delete-with-sql-server
            String sql1 =
                    "CREATE TABLE "+ warehousename1 +"_categories " +
                            "(" +
                            "category_id INT NOT NULL , " +
                            " category_name VARCHAR(100) PRIMARY KEY " +
                            ");";
            String sql2 =
                    "CREATE TABLE "+ warehousename1 +"_subcategories ( " +
                            " subcategory_id INT NOT NULL ," +
                            " category_name VARCHAR(100) NOT NULL , "+
                            " subcategory_name VARCHAR(100) PRIMARY KEY , "+
                            " CONSTRAINT fk_inv_"+warehousename1+"_category_id " +
                            "FOREIGN KEY (category_name)" +
                            "REFERENCES "+ warehousename1 +"_categories (category_name)" +
                            "ON DELETE CASCADE);";
            statement.addBatch(sql1);
            statement.addBatch(sql2);
            statement.executeBatch();

            this.createProductsTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }

    /**
     * Function to create the product table
     */
    public void createProductsTable(){
        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();
        try {
            Statement statement=connection.createStatement();
            String warehousename1=name.getText().trim();
            String test=
                    "CREATE TABLE "+ warehousename1 +"_itemss  ( " +
                            " `item_name` INT(10) NOT NULL , " +
                            " `item_id` INT(10) NOT NULL , " +
                            " `subcategory_name` VARCHAR(100) NOT NULL , " +
                            " `units` INT(10) NOT NULL , " +
                            " `carrying_cost` INT(10) NOT NULL , " +
                            " `demand` INT(10) NOT NULL , " +
                            " `description` VARCHAR(2000) NOT NULL , "+
                            " CONSTRAINT fk_inv_"+warehousename1+"_subcategory_id " +
                            " FOREIGN KEY (subcategory_name)" +
                            " REFERENCES "+ warehousename1 +"_subcategories (subcategory_name)" +
                            " ON DELETE CASCADE);";
            statement.addBatch(test);
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}