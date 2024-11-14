
package Utilities;

import java.sql.Connection;
import java.sql.SQLException;



public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Database connection successful!");
            } else {
                System.out.println("Failed to connect to database.");
            }
            
            
            DBConnection.closeConnection(connection);
            
        } catch (SQLException e) {
            System.err.println(e) ;
        }
        
        
    }
}
