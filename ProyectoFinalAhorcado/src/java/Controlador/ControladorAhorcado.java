package Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Config.Conexion;
import Modelo.Palabra;
import Modelo.PalabraDAO;
/**
 *
 * @author PC
 */
@WebServlet(name = "ControladorAhorcado", urlPatterns = {"/ControladorAhorcado"})
public class ControladorAhorcado extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if ("obtenerPalabras".equals(action)) {
            obtenerPalabras(request, response);
        } else {
            // Redirigir a la página del juego
            request.getRequestDispatcher("/ahorcado.jsp").forward(request, response);
        }
    }
    
    private void obtenerPalabras(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Usar tu clase de conexión
        Conexion conn = new Conexion();
        Connection connection = conn.Conexion();
        PalabraDAO dao = new PalabraDAO(connection);
        List<Palabra> palabras = dao.listar();
        // Construir JSON manualmente
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (int i = 0; i < palabras.size(); i++) {
            Palabra palabra = palabras.get(i);
            json.append("{");
            json.append("\"codigoPalabra\":").append(palabra.getCodigoPalabra()).append(",");
            json.append("\"palabra\":\"").append(palabra.getPalabra()).append("\",");
            json.append("\"pistaUno\":\"").append(palabra.getPistaUno()).append("\",");
            json.append("\"pistaDos\":\"").append(palabra.getPistaDos()).append("\",");
            json.append("\"pistaTres\":\"").append(palabra.getPistaTres()).append("\"");
            json.append("}");
            
            if (i < palabras.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toString());
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Servlet para el juego del ahorcado";
    }
}