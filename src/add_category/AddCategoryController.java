package add_category;

import MainClasses.Place;
import MainClasses.Store;
import MainClasses.Warehouse;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AddCategoryController {

    private Place warehouse;

    public void addButtonClicked(ActionEvent actionEvent) {
        //code to add category

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }

    public void setPlace(Place store) {
        this.warehouse=store;
    }
}
