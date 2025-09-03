package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PalabraDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Método para obtener una palabra aleatoria desde el SP
    public Palabra obtenerPalabraAleatoria() {
        Palabra palabra = null;
        String sql = "call sp_ObtenerPalabraAleatoria()";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                palabra = new Palabra();
                palabra.setPalabra(rs.getString("palabra"));
                palabra.setPista1(rs.getString("pistaUno"));
                palabra.setPista2(rs.getString("pistaDos"));
                palabra.setPista3(rs.getString("pistaTres"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palabra;
    }
}