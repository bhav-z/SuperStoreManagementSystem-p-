package ConnectionUtil;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Utility Class for connecting to the sql server, currently on local host
 */
public class ConnectionU {

    private Connection connection;
    public Connection getConnection() {
        Connection conn = null;
        String dbName = "Management";
        String username = "root"; //superuser l8r idk
        String password = "";       //superuser l8r idk

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName, username, password); //server address for the sql server
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        return conn;
    }
}