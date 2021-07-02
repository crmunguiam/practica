El proyecto esta en el repositorio
https://github.com/crmunguiam/practica#:~:text=https%3A//github.com/crmunguiam/practica.git

necesitas
Apache Maven 3.8.1 
SQL server
Java version: 11.0.11

Crear la base de datos en SQL server utulizando el springbootdb_script.sql

el proyeto esta desarrollado en intellij ide con spring boot

bajar del repositorio la carpeta V1

Abrir el proyecto el intellij ide

ejecutar V1Application 

y probar los servicios con los siguientes end points

metodo: Post
localhost:8091/v1/user/saveOrUpdate

body:

{

 "name": "Diego Ivan",
 "lastName": "Hernandez",
 "surname": "Martinez",
 "rfc": "GHTM920416CR6",
 "worshift": 1,
 "gender": 1,
 "phone": "5538475647",
 "pin": "999988",
 "birthdate": 292948281010183
 }
 
 metodo: Post
 localhost:8091/v1/users/list?nombre=Diego Ivan
 
 KEY: nombre
 VALUE: Diego Ivan

