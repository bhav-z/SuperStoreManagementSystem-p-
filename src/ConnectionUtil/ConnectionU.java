package ConnectionUtil;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionU {

    private Connection connection;
    public Connection getConnection() {
        Connection conn = null;
        String dbName = "Management";
        String username = "root"; //superuser l8r idk
        String password = "";       //superuser l8r idk

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName, username, password);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        return conn;
    }
}