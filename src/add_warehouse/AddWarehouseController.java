package add_warehouse;

import ConnectionUtil.ConnectionU;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            //https://stackoverflow.com/questions/6260688/how-do-i-use-cascade-delete-with-sql-server
            String sql1 = "CREATE TABLE "+ warehousename1 +"_categories ( category_id INT NOT NULL , category_name VARCHAR(100) PRIMARY KEY );";
            String sql2 =
                    "CREATE TABLE "+ warehousename1 +"_subcategories ( " +
                            "subcategory_id INT NOT NULL ," +
                            " category_name VARCHAR(100) PRIMARY KEY , "+
                            " subcategory_name VARCHAR(100) NOT NULL , "+
                            " CONSTRAINT fk_inv_cateory_id " +
                            "FOREIGN KEY (category_name)" +
                            "REFERENCES "+ warehousename1 +"_categories (category_name)" +
                            "ON DELETE CASCADE);";
            String sql3 =
                    "CREATE TABLE "+ warehousename1 +"_items ( " +
                            "item_id INT NOT NULL ," +
                            " subcategory_name VARCHAR(100) PRIMARY KEY , "+
                            " item_name VARCHAR(100) NOT NULL , "+
                            " CONSTRAINT fk_inv_subcategory_id " +
                            "FOREIGN KEY (subcategory_name)" +
                            "REFERENCES "+ warehousename1 +"_subcategories (subcategory_name)" +
                            "ON DELETE CASCADE);";

            statement.addBatch(sql1);
            statement.addBatch(sql2);
            statement.addBatch(sql3);
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}