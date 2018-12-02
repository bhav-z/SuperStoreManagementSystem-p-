package update_subcategory;

import MainClasses.Place;
import MainClasses.Subcategory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateSubcategoryController {

    private  Place place;
    @FXML private TextField text;

    private Subcategory subcategory;

    public void setPlace(Place place) {
        this.place=place;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public void updateButtonClicked(ActionEvent actionEvent) {
        text.setText(this.subcategory.getName());
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }
}
