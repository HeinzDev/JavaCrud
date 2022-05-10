  
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConnectBD {
    public Connection conectaBD(){
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/Champ?user=root&password=";
            conn = DriverManager.getConnection(url);
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
     return conn;
    }
}

