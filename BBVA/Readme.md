
ENTORNO DESARROLLO

-Por estar en mi casa y disponer solo de MAC y no querer hacer una maquina virtual se ha desarrollado en:
	
	SO MacOS Mojave 10.14.4
	IDE STS 3.9.12 
	Se ha utlizado Spring Boot, Junit4 y H2
	



BASE DE DATOS

-La base de datos es autocontenida y es H2 los parametros de conexion son 

	http:localhost:8080/h2-console 
	jdbc:h2:mem:test
	(no tiene clave)


He creado una app (Spring Boot) con dos endpoint

http://localhost:8080/updateprice

Actualiza el precio de un mercado y se hace la media de los mercados y actualiza los instruments.

http://localhost:8080/create

Crea instruments con datos (inventados)

He creado dos tablas 

CREATE TABLE instruments (
  reference      	    VARCHAR NOT NULL primary KEY,
  account_iban  		VARCHAR NOT NULL,
  date			        TIMESTAMP,
  price		            INT,
  description			VARCHAR
);

CREATE TABLE market (
  reference      	    VARCHAR NOT NULL primary KEY,
  price		            INT,
  description			VARCHAR
);


Se ha creado la tabla en H2 con algunos registros.
Se ha utilizado JPA por estar muy testado y no inventar nada nuevo, aunque entiendo que lo ideal seria utilizar algun framework que tratara datos masivamente, doy por supuesto la la BD es oracle o db2, aunque yo localmente utilizo H2 por comodidad.
Como entiendo que solo se quiere ver el estilo de programación hay temas que no están finos (las anotaciones getter y setter, los test , y no he creado factorías de los objetos).
He incluido configuración, constantes de manera nominal.

He entendido que se quiere utilizar un gran volumen de datos en este caso serian dos tablas, instrumento y mercados. Cuando se actualiza un precio de mercado se actualizan todos los registros de instruments con la media de los mercados


Adjunto el postman para realizar las pruebas (esta en el mismo directorio)



curl --location --request GET 'http://localhost:8080/create' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--header 'Accept-Language: es' \
--header 'Content-Type: text/plain' \
--data-raw '{
    "reference": "5",
    "account_iban": "ES0000000000000000000000",
    "date": "2019-07-16T16:55:42.000Z",
    "price":100,
    "description": "Jacinto 3"
 
}’


url --location --request GET 'http://localhost:8080/updateprice' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--header 'Accept-Language: es' \
--header 'Content-Type: text/plain' \
--data-raw '{
    "reference": "5",
    "price":100
}'