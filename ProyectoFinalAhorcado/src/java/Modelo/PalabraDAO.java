package Modelo;

import Config.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PalabraDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public List<Palabra> listar() {
        List<Palabra> lista = new ArrayList<>();
        String sql = "SELECT * FROM palabra";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Palabra p = new Palabra();
                p.setCodigoPalabra(rs.getInt("codigoPalabra"));
                p.setPalabra(rs.getString("palabra"));
                p.setPistaUno(rs.getString("pistaUno"));
                p.setPistaDos(rs.getString("pistaDos"));
                p.setPistaTres(rs.getString("pistaTres"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al listar palabras: " + e);
        }
        return lista;
    }
}