package update_d;

import MainClasses.Place;
import MainClasses.Warehouse;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class UpdateDController {

    private Place warehouse;

    public void setPlace(Place warehouse) {
        this.warehouse = warehouse;
    }

    public void updateButtonClicked(ActionEvent actionEvent) {
        //code to update_D

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }


}
