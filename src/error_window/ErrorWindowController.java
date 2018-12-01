package error_window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;

public class ErrorWindowController {

    @FXML
    private Label error_message;

    @FXML
    private Label error_title;

    public void okayButtonClicked(ActionEvent actionEvent) {
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }

    public void setErrorTitle(String s){
        error_title.setText(s);
    }

    public void setErrorMessage(String s){
        error_message.setText(s);
    }

}
