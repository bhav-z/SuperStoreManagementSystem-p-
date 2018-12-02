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

@SuppressWarnings("ALL")
public class AddWarehouseController {
    @FXML
    private Button add;
    @FXML
    private TextField name;

    public void addButtonClicked(ActionEvent actionEvent) throws IOException{
        //code to add warehouse
        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();
        try {
            Statement statement=connection.createStatement();
            String warehousename1=name.getText().trim();
            //THERES NO CONNECTION BETWEEN THE VALUES IN WAREHOUSE_LIST AND ITS SUBSEQUENT 3 TABLES
            String sql0="INSERT INTO warehouse_list (name) VALUES ('"+warehousename1+"');";
            statement.executeUpdate(sql0);
            //https://stackoverflow.com/questions/6260688/how-do-i-use-cascade-delete-with-sql-server
            String sql1 =
                    "CREATE TABLE "+ warehousename1 +"_categories " +
                            "(category_id INT NOT NULL , " +
                            " category_name VARCHAR(100) PRIMARY KEY );";
            String sql2 =
                    "CREATE TABLE "+ warehousename1 +"_subcategories ( " +
                            " subcategory_id INT NOT NULL ," +
                            " category_name VARCHAR(100) NOT NULL , "+
                            " subcategory_name VARCHAR(100) PRIMARY KEY , "+
                            " CONSTRAINT fk_inv_"+warehousename1+"_category_id " +
                            "FOREIGN KEY (category_name)" +
                            "REFERENCES "+ warehousename1 +"_categories (category_name)" +
                            "ON DELETE CASCADE);";
//            String sql3 =
//                    "CREATE TABLE "+ warehousename1 +"_itemss ( " +
//                            " item_id INT NOT NULL ," +
//                            " subcategory_name VARCHAR(100) NOT NULL , "+
//                            " item_name VARCHAR(100) NOT NULL , "+
//                            " CONSTRAINT fk_inv_subcategory_id " +
//                            "FOREIGN KEY (subcategory_name)" +
//                            "REFERENCES "+ warehousename1 +"_subcategories (subcategory_name)" +
//                            "ON DELETE CASCADE);";

            statement.addBatch(sql1);
            statement.addBatch(sql2);
//            statement.addBatch(sql3);
            statement.executeBatch();

            this.createProductsTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }

    public void createProductsTable(){
        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();
        try {
            Statement statement=connection.createStatement();
            String warehousename1=name.getText().trim();

            String sql3 =
                    "CREATE TABLE "+ warehousename1 +"_itemss ( " +
                            " item_id INT NOT NULL ," +
                            " subcategory_name VARCHAR(100) NOT NULL , "+
                            " item_name VARCHAR(100) NOT NULL , "+
                            " CONSTRAINT fk_inv_"+warehousename1+"_subcategory_id " +
                            "FOREIGN KEY (subcategory_name)" +
                            "REFERENCES "+ warehousename1 +"_subcategories (subcategory_name)" +
                            "ON DELETE CASCADE);";

            statement.addBatch(sql3);
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}