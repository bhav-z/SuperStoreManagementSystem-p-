package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class LoginController {

    @FXML private Text errorLabel;

    @FXML protected void handleLoginButtonAction(ActionEvent event) {
        errorLabel.setText("Sign in button pressed"); // errorLabel is for showing errors with log in
    }
}
