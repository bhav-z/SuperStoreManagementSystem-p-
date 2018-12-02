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

    /**
     * Closes the window
     * @param actionEvent argument to detect click on Ok button
     */
    public void okayButtonClicked(ActionEvent actionEvent) {
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }

    /**
     * Function to set the title text
     * @param s String parameter for the title
     */
    public void setErrorTitle(String s){
        error_title.setText(s);
    }

    /**
     * Function to set the message
     * @param s String parameter for the message
     */
    public void setErrorMessage(String s){
        error_message.setText(s);
    }

}
