<%-- 
    Document   : index
    Created on : 1/09/2025, 15:37:32
    Author     : Francisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
        <link rel="stylesheet" href="Styles/index.css"/>
        
    </head>
    <body>
        <div class="login-contendor">
            <h2>Bienvenido</h2>
            <p>Ingresa tus datos para poder iniciar sesion</p>

            <form action="Validar" method="POST">
                <input type="tex" name="txtCorreo" placeholder="Correo" required />
                <input type="password" name="txtContrasena" placeholder="Contraseña" required />
                <button type="submit" name="btnIngresar" value="Ingresar">Iniciar Sesión</button>
            </form>

        </div>
    </body>
</html>
