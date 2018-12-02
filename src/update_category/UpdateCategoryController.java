package update_category;

import MainClasses.Category;
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
    private Category category;

    public void setPlace(Place warehouse) {
        this.warehouse = warehouse;
    }

    public void updateButtonClicked(ActionEvent actionEvent) {
        //code to update category
        text.setText(this.category.getName());
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }

    public void setCategory(Object selectedItem) {
        this.category=(Category) selectedItem;
    }
}
