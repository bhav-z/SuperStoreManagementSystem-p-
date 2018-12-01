package warehouse_main1;

import ConnectionUtil.ConnectionU;
import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class WareMain1Controller implements Initializable {

    @FXML
    ComboBox comboString;
    ConnectionU connectionClass = new ConnectionU();
    java.sql.Connection connection=connectionClass.getConnection();
    ResultSet resultSet;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Statement statement=connection.createStatement();
            String tableName="warehouse_list";
            comboString = FXCollections.observableArrayList();
            resultSet = statement.executeQuery("Select name from department");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (resultSet.next()) {  // loop

            // Now add the comboBox addAll statement
            comboBox.getItems().addAll(resultSet.getString("name"));
        }
    }
}
