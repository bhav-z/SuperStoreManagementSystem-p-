package warehouse_main1;

import ConnectionUtil.ConnectionU;
import MainClasses.Warehouse;
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
import w_main.WarehouseMain;
import w_main.WarehouseMainController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class WareMain1Controller implements Initializable {
    public static Warehouse temp;
    @FXML public Button proceed1;
    @FXML ComboBox comboString;
    ConnectionU connectionClass = new ConnectionU();
    java.sql.Connection connection=connectionClass.getConnection();
    ResultSet resultSet;
    //private ObservableList<Warehouse> comboData;

    /**
     * method to populate the comboBox
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(this.getClass());
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

    /**
     * Method to proceed to the selected warehouse's dashboard
     * @param actionEvent
     * @throws IOException
     * @throws InvocationTargetException
     */
    public void proceed1ButtonClicked(ActionEvent actionEvent) throws IOException, InvocationTargetException {
//        FXMLLoader loader=new FXMLLoader();
//        loader.setLocation(getClass().getResource("/w_main/warehouse_main.fxml"));
//        try {
//            Parent root = (Parent)loader.load();
//        }catch (IOException e){
//            System.out.println("OOPS");
//        }
//        Warehouse w2=new Warehouse(comboString.getValue().toString(),2 );
//        temp=w2;
//        System.out.println(w2.getName()+"LOOOL");
//        System.out.println(w2.getName()+"LMAOO");
//        WarehouseMainController ok = loader.getController();
//        ok.setWarehouse(w2);
//        Parent p = loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(p));
//        stage.show(); //AndWait();
//          OR

        String warehousename=comboString.getValue().toString();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/w_main/warehouse_main.fxml"));

//            Stage stage = (Stage) proceed1.getScene().getWindow();
//            Scene scene = new Scene(loader.load());
//            WarehouseMainController ok = loader.getController();
//            stage.setScene(scene);
        try {
            loader.load();
        }catch (IOException e){
            System.out.println("o no");
        }
        WarehouseMainController ok = loader.getController();
        ok.setTableText(warehousename);
        Parent p =loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();


    }
}