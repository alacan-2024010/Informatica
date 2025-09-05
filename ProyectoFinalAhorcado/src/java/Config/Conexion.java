package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/DB_Ahorcado?useSSL=false&serverTimezone=UTC";
    String user = "admin";
    String pass = "quintom";

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e);
        }
        return con;
    }
}


