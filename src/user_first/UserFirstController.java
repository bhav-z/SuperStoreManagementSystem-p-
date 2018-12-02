package user_first;

import ConnectionUtil.ConnectionU;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import user_main.UserMainController;
import w_main.WarehouseMainController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UserFirstController implements Initializable {

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
            resultSet = statement.executeQuery("Select name from store_list");
            while (resultSet.next()) {  // loop
                // Now add the comboBox addAll statement
                comboString.getItems().addAll(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void proceedButtonClicked(ActionEvent actionEvent) throws IOException, InvocationTargetException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/w_main/warehouse_main.fxml"));

        UserMainController a=loader.getController();
        MainClasses.Store w2=new MainClasses.Store();
        w2.setName(comboString.getValue().toString());
        a.setStore(w2);

        Parent wmain_page = loader.load();
        Scene wmain_scene = new Scene(wmain_page);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(wmain_scene);
        window.show();
    }
}
