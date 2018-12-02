package update_d;

import MainClasses.Warehouse;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class UpdateDController {

    private Warehouse warehouse;

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void updateButtonClicked(ActionEvent actionEvent) {
        //code to update_D

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }


}
