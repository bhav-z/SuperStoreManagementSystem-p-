package update_category;

import MainClasses.Place;
import MainClasses.Warehouse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateCategoryController {

    @FXML
    private TextField text;
    private Place warehouse;

    public void setPlace(Place warehouse) {
        this.warehouse = warehouse;
    }

    public void updateButtonClicked(ActionEvent actionEvent) {
        //code to update category
        text.setText(warehouse.getName());
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }
}
