package user_main_notuseful;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;

import java.util.ResourceBundle;

public class UserMainController_nu implements Initializable{

    @FXML private TreeTableView<String> treeTableView;
    @FXML private TreeTableColumn<String, String> columnView;
    @FXML private ComboBox<String> filterCombo;
    ObservableList<String> list= FXCollections.observableArrayList("Name", "Price", "Category", "Subcategory");
//
    TreeItem<String> item_m1=new TreeItem<>("SamsungA1");
    TreeItem<String> item_m2=new TreeItem<>("SamsungA2");
    TreeItem<String> mobile=new TreeItem<>("Mobile Phone");

    TreeItem<String> item_t1=new TreeItem<>("SonyBravia");
    TreeItem<String> item_t2=new TreeItem<>("LG");
    TreeItem<String> tv=new TreeItem<>("TV");

    TreeItem<String> root=new TreeItem<>("Electronics");

//
    @Override
    public void initialize(URL url, ResourceBundle rb){
        filterCombo.setItems(list);

        mobile.getChildren().setAll(item_m1,item_m2);
        tv.getChildren().setAll(item_t2,item_t1);
        root.getChildren().setAll(mobile,tv);

        columnView.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<String, String> param) {
                return new SimpleStringProperty(param.getValue().getValue());
            }
        });

        treeTableView.setRoot(root);
    }
}
