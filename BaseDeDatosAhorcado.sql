drop database if exists DB_Ahorcado;
create database DB_Ahorcado;
use DB_Ahorcado;

create table Palabras(
	codigoPalabra int auto_increment,
    palabra varchar(20),
    pistaUno varchar(100),
    pistaDos varchar(100),
    pistaTres varchar(100),
    primary key PK_codigoPalabra(codigoPalabra)
);

DELIMITER $$
create procedure sp_InsertarPalabras(
	in palabra varchar(20),
    in pistaUno varchar(100),
    in pistaDos varchar(100),
    in pistaTres varchar(100))
	begin
		insert into Palabras (palabra, pistaUno, pistaDos, pistaTres)
			values(palabra, pistaUno, pistaDos, pistaTres);
		
	end $$
DELIMITER ;
call sp_InsertarPalabras("PROGRAMADOR", "Escribe código", "Trabaja con software", "Conoce lenguajes");
call sp_InsertarPalabras("ELEFANTE", "Animal de gran tamaño", "Tiene trompa", "Vive en África y Asia");
call sp_InsertarPalabras ("VEHICULO", "Se usa para transportarse", "Tiene ruedas", "Puede ser coche, moto o camión");
call sp_InsertarPalabras  ("GUATEMALA", "Es un país en Centroamérica", "Tiene volcanes", "Su capital es Ciudad de Guatemala");
call sp_InsertarPalabras ("DESAYUNO", "Es la primera comida del día", "Suele incluir café o jugo", "Comida matutina");
call sp_InsertarPalabras("INTERNET", "Red global de comunicaciones", "Se usa para navegar", "Conecta computadoras en todo el mundo");
call sp_InsertarPalabras("TELEVISIÓN", "Es un medio de comunicación", "Tiene canales", "Se usa para ver programas y películas");
call sp_InsertarPalabras ("COMPUTADORA", "Herramienta electrónica", "Tiene teclado y pantalla", "Se usa para navegar y trabajar");
call sp_InsertarPalabras ("IMPRESORA", "Dispositivo de salida", "Imprime documentos", "Puede ser de tinta o láser");
call sp_InsertarPalabras ("PELICULA", "Forma de entretenimiento", "Puede ser de cine o video", "Se proyecta en una pantalla grande");


DELIMITER $$
create procedure sp_ListarPalabras()
	begin
		select palabra, pistaUno, pistaDos, pistaTres from Palabras;
	end $$
DELIMITER ;
call sp_ListarPalabras();
