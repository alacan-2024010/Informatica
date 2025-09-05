let palabraElegida = "";
let espacios = [];
let letrasMalas = [];
let errores = 0;
let intentos = 6;

let tiempoRestante = 300;
let temporizador;
let juegoEnPausa = false;

const pista1 = document.getElementById("pistaUno");
const pista2 = document.getElementById("pistaDos");
const pista3 = document.getElementById("pistaTres");
const palabraOculta = document.getElementById("palabra-oculta");
const letrasIncorrectasEl = document.getElementById("letras-incorrectas");
const intentosEl = document.getElementById("intentos");
const imagen = document.getElementById("muñeco");
const cronometroEl = document.getElementById("cronometro");
const btnPausar = document.getElementById("btn-pausar");

function comenzar() {
    if (!palabraElegida) {
        if (typeof palabraBD !== "undefined" && palabraBD) {
            palabraElegida = palabraBD.toUpperCase();
            const pistas = pistasBD;
            espacios = Array(palabraElegida.length).fill("_");
            palabraOculta.textContent = espacios.join(" ");
            pista1.textContent = "Pista No.1: " + pistas[0];
            pista2.textContent = "Pista No.2: " + pistas[1];
            pista3.textContent = "Pista No.3: " + pistas[2];
        } else {
            // fallback: usar array local
            const palabraAleatoria = palabrasAhorcado[Math.floor(Math.random() * palabrasAhorcado.length)];
            palabraElegida = palabraAleatoria.palabra;
            espacios = Array(palabraElegida.length).fill("_");
            palabraOculta.textContent = espacios.join(" ");
            pista1.textContent = "Pista No.1: " + palabraAleatoria.pistas[0];
            pista2.textContent = "Pista No.2: " + palabraAleatoria.pistas[1];
            pista3.textContent = "Pista No.3: " + palabraAleatoria.pistas[2];
        }

        tiempoRestante = 300;
        cronometroEl.textContent = tiempoRestante;
        iniciarCronometro();
    }
}

function reiniciar() {
    palabraElegida = "";
    espacios = [];
    letrasMalas = [];
    errores = 0;
    intentos = 6;

    palabraOculta.textContent = "";
    letrasIncorrectasEl.textContent = "";
    intentosEl.textContent = "Intentos restantes: 6";
    pista1.textContent = "";
    pista2.textContent = "";
    pista3.textContent = "";
    imagen.src = "img/Ahorcado.png";
    
    tiempoRestante = 300;
    cronometroEl.textContent = tiempoRestante;
    juegoEnPausa = false;
    btnPausar.textContent = "Pausar";
}

function verificar() {
    const verificarLetra = document.getElementById("letra");
    const letra = verificarLetra.value.toUpperCase();
    verificarLetra.value = "";

    if (!letra || letrasMalas.includes(letra) || espacios.includes(letra)) return;

    if (palabraElegida.includes(letra)) {
        for (let i = 0; i < palabraElegida.length; i++) {
            if (palabraElegida[i] === letra) {
                espacios[i] = letra;
            }
        }
        palabraOculta.textContent = espacios.join(" ");
    } else {
        letrasMalas.push(letra);
        letrasIncorrectasEl.textContent = letrasMalas.join(", ");
        errores++;
        intentos--;
        intentosEl.textContent = `Intentos restantes: ${intentos}`;
        imagen.src = `img/Ahorcado${errores}.png`;
    }

    if (!espacios.includes("_")) {
        alert("¡Ganaste!");
    }

    if (errores === 6) {
        alert("¡Perdiste! La palabra era: " + palabraElegida);
    }
}

function actualizarCronometro() {
    if (!juegoEnPausa && tiempoRestante > 0) {
        tiempoRestante--;
        cronometroEl.textContent = tiempoRestante;
    } else if (tiempoRestante <= 0) {
        clearInterval(temporizador);
        alert("¡Se acabó el tiempo! La palabra era: " + palabraElegida);
        reiniciar();
    }
}

function iniciarCronometro() {
    temporizador = setInterval(actualizarCronometro, 2000);
}

function pausarJuego() {
    juegoEnPausa = !juegoEnPausa;
    btnPausar.textContent = juegoEnPausa ? "Reanudar" : "Pausar";
}


const  palabrasAhorcado = [
        {palabra: "PROGRAMADOR", pistas: ["Escribe código", "Trabaja con software", "Conoce lenguajes"]},
        {palabra: "ELEFANTE", pistas: ["Animal de gran tamaño", "Tiene trompa", "Vive en África y Asia"]},
        {palabra: "VEHICULO", pistas: ["Se usa para transportarse", "Tiene ruedas", "Puede ser coche, moto o camión"]},
        {palabra: "GUATEMALA", pistas: ["Es un país en Centroamérica", "Tiene volcanes", "Su capital es Ciudad de Guatemala"]},
        {palabra: "DESAYUNO", pistas: ["Es la primera comida del día", "Suele incluir café o jugo", "Comida matutina"]},
        {palabra: "INTERNET", pistas: ["Red global de comunicaciones", "Se usa para navegar", "Conecta computadoras en todo el mundo"]},
        {palabra: "TELEVISIÓN", pistas: ["Es un medio de comunicación", "Tiene canales", "Se usa para ver programas y películas"]},
        {palabra: "COMPUTADORA", pistas: ["Herramienta electrónica", "Tiene teclado y pantalla", "Se usa para navegar y trabajar"]},
        {palabra: "IMPRESORA", pistas: ["Dispositivo de salida", "Imprime documentos", "Puede ser de tinta o láser"]},
        {palabra: "PELICULA", pistas: ["Forma de entretenimiento", "Puede ser de cine o video", "Se proyecta en una pantalla grande"]}
];