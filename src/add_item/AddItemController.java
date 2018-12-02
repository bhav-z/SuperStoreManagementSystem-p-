package add_item;

import MainClasses.Category;
import MainClasses.Place;
import MainClasses.Subcategory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddItemController {

    @FXML private TextField name;
    @FXML private TextField id;
    @FXML private TextField price;
    @FXML private TextField carrying_cost;
    @FXML private TextField demand;
    @FXML private TextArea desc;
    @FXML private Button add;
    @FXML private TextField units;
    private Subcategory sub;
    private Category category;
    private Place place;

    public void setCategory(Category category) {
        this.category = (Category) category;
    }

    public void setPlace(Place place) {
        this.place = (Place) place;
    }

    public void setSubcategory(Subcategory sub) {
        this.sub = (Subcategory) sub;
    }


    public void addButtonClicked(ActionEvent actionEvent) {
        String Name=name.getText();
        String ID=id.getText();
        String Price=price.getText();
        String CarryingCost=carrying_cost.getText();
        String Demand=demand.getText();
        String Description=desc.getText();
        String Units=units.getText();

        //code to add item to backend


        Stage win = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        win.close();

    }
}
