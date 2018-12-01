package login;

import ConnectionUtil.ConnectionU;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label isConnected;
    @FXML
    protected void handleLoginButtonAction(ActionEvent event) throws SQLException {
        isConnected.setText("Not Connected"); // errorLabel is for showing errors with log in
    }
    public void Login(ActionEvent actionEvent){
//        isConnected.setText("Not Connected"); // errorLabel is for showing errors with log in
        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();
        try {
            Statement statement=connection.createStatement();
            String tableNAme="userauth";
            String sql = "SELECT * FROM "+tableNAme+" WHERE username = '"+usernameField.getText()+"' AND password = '"+passwordField.getText()+"';";
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
                isConnected.setText("Connected");
            }
            else {
                isConnected.setText("Not Connected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
