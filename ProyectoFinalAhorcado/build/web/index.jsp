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
        <title>Juego de Ahorcado</title>
        <link rel="stylesheet" href="Styles/ahorcado.css"/>
    </head>
    <body>
        <h1>Juego de Ahorcado</h1>
        <div>
            <div id="letras-usadas"></div>
        </div>
        <div id="contenedor-palabras"></div>

        <button id="inicio" >Inicio</button>
        <input type="text" id="letra" maxlength="1" placeholder="Ingresa una letra">
        <button id="verificar">Verificar letra</button>
        <button id="pausa">Pausa</button>
        <button id="reiniciar">Reiniciar</button>
    </body>
</html>
