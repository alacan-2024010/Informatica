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
        <div class="juego-container">
            <div id="info-juego">
                <h1>Juego del Ahorcado</h1>

                <p>Cronómetro: <span id="cronometro">00:00</span></p>

                <div class="botones">
                    <button id="inicio" onclick="comenzar()">Iniciar</button>
                    <button id="btn-pausar" >Pausar</button>
                    <button id="btn-reiniciar" onclick="reiniciar()">Reiniciar</button>
                </div>

                <div id="pistas">
                    <p id="pista1"></p>
                    <p id="pista2"></p>
                    <p id="pista3"></p>
                </div>

                <p id="palabra-oculta"></p>

                <p>Letras incorrectas: <span id="letras-incorrectas"></span></p>
                <p id="intentos">Intentos restantes: 6</p>

                <input type="text" id="letra" maxlength="1" placeholder="Letra">
                <button id="btn-verificar" onclick="verificar()">Verificar</button>
                <p id="resultado"></p>
            </div>

            <div id="muñeco-container">
                <img id="muñeco" src="img/Ahorcado.png" alt="Muñeco del Ahorcado">
            </div>
        </div>
        <script src="js/ahorcado.js"></script>
    </body>
</html>
