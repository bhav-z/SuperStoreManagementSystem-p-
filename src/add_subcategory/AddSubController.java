package add_subcategory;

import MainClasses.Category;
import MainClasses.Place;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AddSubController {

    private Place place;
    private Category category;

    public void setPlace(Place place) {
        this.place=place;
    }

    public void setCategory(Category category) {
        this.category=category;
    }


    public void addButtonClicked(ActionEvent actionEvent) {
        //code to add a subcategory, use the category variable to set category name

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }
}
