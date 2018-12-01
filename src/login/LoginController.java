package login;

import ConnectionUtil.ConnectionU;

import error_window.ErrorWindowController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    private String typeOfUser="";

    @FXML
    private PasswordField passwordField;
//    @FXML
//    private Label infoEx;
    @FXML
    private TextField usernameField;
    @FXML
    private Label isConnected;
    @FXML
    protected void handleLoginButtonAction(ActionEvent event) throws SQLException {
        isConnected.setText("Not Connected"); // errorLabel is for showing errors with log in
    }
    public void Login(ActionEvent actionEvent) throws IOException{
//        isConnected.setText("Not Connected"); // errorLabel is for showing errors with log in
        ConnectionU connectionClass = new ConnectionU();
        Connection connection=connectionClass.getConnection();

        try {
            Statement statement=connection.createStatement();
            String tableName=this.getUserTableName();
            String sql = "SELECT * FROM "+tableName+" WHERE username = '"+usernameField.getText()+"' AND password = '"+passwordField.getText()+"';";
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

        this.switchToUserScreen(isConnected.getText(), actionEvent);

    }

    public void setTypeOfUser(String s){
        typeOfUser=s;
    }

    public String getTypeOfUser(){
        return this.typeOfUser;
    }

    public String getUserTableName(){
        String a=this.typeOfUser;
        if(a.equals("Super User"))
            return "superauth";
        else if(a.equals("Warehouse Admin"))
            return "warehouseauth";
        else if(a.equals("Store Admin"))
            return "storeauth";
        else
            return "guest";

    }

    public void switchToUserScreen(String s, ActionEvent event) throws IOException {
        FXMLLoader loader2=new FXMLLoader();

        if(s.equals("Not Connected") || s.equals("LoginError")) {
            Stage errorwindow=new Stage();
            errorwindow.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader3=new FXMLLoader();
            loader3.setLocation(getClass().getResource("/error_window/errorw.fxml"));
            Parent error_page=loader3.load();
            Scene error_scene=new Scene(error_page);
            errorwindow.setScene(error_scene);
            errorwindow.show();
            ErrorWindowController ew=loader3.getController();
            ew.setErrorTitle("Invalid Credentials");
            ew.setErrorMessage("The username or password is incorrect.");
        }
        else if(s.equals("Connected") && this.typeOfUser.equals("Super User"))
            loader2.setLocation(getClass().getResource("/su_main/su_main.fxml"));
        else if(s.equals("Connected") && this.typeOfUser.equals("Warehouse Admin"))
            loader2.setLocation(getClass().getResource("/warehouse_main1/waremain1.fxml"));
        else if(s.equals("Connected") && this.typeOfUser.equals("Store Admin"))
            loader2.setLocation(getClass().getResource("/store_main/storemain.fxml"));

        Parent user_page=loader2.load();
        Scene user_scene=new Scene(user_page);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(user_scene);
        window.show();
    }


}
