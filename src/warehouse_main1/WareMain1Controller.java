package warehouse_main1;

import ConnectionUtil.ConnectionU;
import MainClasses.Warehouse;
import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import store_main.Store;
import w_main.WarehouseMainController;

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
    //private ObservableList<Warehouse> comboData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Statement statement=connection.createStatement();
            //String tableName="warehouse_list";
            //comboData = FXCollections.observableArrayList();
            resultSet = statement.executeQuery("Select name from warehouse_list");
            while (resultSet.next()) {  // loop
                // Now add the comboBox addAll statement
                comboString.getItems().addAll(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void proceed1ButtonClicked(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/w_main/wmain.fxml"));
        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        WarehouseMainController w=loader.getController();
        Warehouse w2=new Warehouse();
        w2.setName(comboString.getValue().toString());
        w.setWarehouse(w2);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(wmain_scene);
        window.show();
    }
}
