package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PalabraDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "call sp_ListarPalabras()";
        List<Palabra> listaPalabra = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Palabra pa = new Palabra();
                pa.setPalabra(rs.getString(1));
                pa.setPista1(rs.getString(2));
                pa.setPista2(rs.getString(3));
                pa.setPista3(rs.getString(4));
                listaPalabra.add(pa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPalabra;
    }
}