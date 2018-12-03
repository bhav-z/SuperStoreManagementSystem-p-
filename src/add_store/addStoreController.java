package add_store;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class addStoreController {
    public void addButtonClicked(ActionEvent actionEvent) {
        //code to add new store

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }
}
