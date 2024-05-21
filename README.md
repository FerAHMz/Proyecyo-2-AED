# Proyecyo-2-AED

# Sistema de Recomendación de Música

Este proyecto implementa un sistema de recomendación de música utilizando Neo4j como gestor de base de datos. Los usuarios pueden registrarse, iniciar sesión y obtener recomendaciones de canciones basadas en géneros y artistas.

## Tabla de Contenidos

- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Clases Principales](#clases-principales)
  - [Usuario](#usuario)
  - [UserDB](#userdb)
  - [DataBase](#database)
  - [Main](#Main)
- [Contribuciones](#contribuciones)

## Requisitos

- Java 17 o superior
- Neo4j 4.0 o superior
- Maven
- OpenCSV

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/FerAHMz/Proyecyo-2-AED.git
   
2.  Instalar dependencias Maven
   mvn clean install

3. Asegúrate de que Neo4j esté corriendo y configurado correctamente. Actualiza las credenciales de conexión a la base de datos en la clase DataBase.

4. Al tener encendido el neo4j asegurate de ingresar la contraseña al Main para funcionar de manera correcta

## Uso

1. Ejecuta la clase Prototipo desde tu entorno de desarrollo o línea de comandos:
    mvn exec:java -Dexec.mainClass="uvg.edu.gt.Main"

2. Sigue las instrucciones en la consola para registrarte, iniciar sesión y obtener recomendaciones.

## Clase Principales

Usuario
La clase Usuario representa a un usuario del sistema y se encarga de manejar la información del usuario y el hash de su contraseña. El constructor de la clase acepta parámetros como el nombre del usuario, nombre de usuario, correo y contraseña. La contraseña puede ser pasada ya hasheada o sin hashear, en cuyo caso se genera el hash dentro del constructor utilizando el algoritmo SHA-256.

UserDB
La clase UserDB gestiona la base de datos de usuarios y sus preferencias utilizando archivos CSV. Esta clase proporciona métodos para cargar usuarios desde un archivo CSV, registrar nuevos usuarios, guardar usuarios en el archivo CSV y manejar las preferencias de los usuarios. También incluye un método para iniciar sesión, que compara el hash de la contraseña proporcionada con el almacenado en la base de datos.

DataBase
La clase DataBase gestiona la base de datos Neo4j. Proporciona métodos para crear nodos, crear relaciones entre nodos, eliminar nodos, verificar la existencia de relaciones y nodos, y obtener recomendaciones basadas en género y artista. También incluye un método para importar datos desde un archivo CSV, creando los nodos y relaciones necesarios en Neo4j.

Main
La clase Main es la clase principal que ejecuta el sistema de recomendación de música. Esta clase proporciona un menú interactivo para que los usuarios puedan registrarse, iniciar sesión, obtener recomendaciones de canciones, agregar nuevas canciones y eliminar canciones existentes. Utiliza las clases DataBase y UserDB para manejar las operaciones relacionadas con la base de datos y las preferencias de los usuarios. La clase también se encarga de actualizar el archivo CSV cuando se agregan o eliminan canciones.

## Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request para mejoras, correcciones de errores o nuevas funcionalidades.