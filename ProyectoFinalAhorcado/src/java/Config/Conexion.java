
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    Connection conexion;
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_Ahorcado?useSSL=false", "quintom", "admin");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return conexion;
    }
    
}
