package uvg.edu.gt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que ejecuta el sistema de recomendación de música.
 */
public class Main {

    private static DataBase db;
    private static final String rutaArchivo = "src/main/resources/data.csv";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        // Inicializar la base de datos y cargar datos desde CSV
        db = new DataBase("bolt://localhost:7687", "neo4j", "123456789");
        db.importarDesdeCSV(rutaArchivo);

            while (continuar) {
                System.out.println("***************");
                System.out.println("Bienvenido al sistema de recomendación de música.");
                System.out.println("***************");
                System.out.println("Ingrese la opción que desea realizar:");
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Salir");

                int opcion = sc.nextInt();
                sc.nextLine(); 

                switch (opcion) {
                    case 1:
                        registrarse(sc);
                        break;
                    case 2:
                        iniciarSesion(sc);
                        break;
                    case 3:
                        continuar = false;
                        System.out.println("Gracias por usar el sistema de recomendación de música.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
            
            sc.close();
            db.close();
        }
    
        //Metodo para registrar un usuario
        private static void registrarse(Scanner scanner) {
            System.out.println("Ingrese su nombre:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese su usuario:");
            String usuario = scanner.nextLine();
            System.out.println("Ingrese su correo:");
            String correo = scanner.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contrasena = scanner.nextLine();
    
            Usuario nuevoUsuario = new Usuario(nombre, usuario, correo, contrasena, false);
            UserDB.registrarUsuario(nuevoUsuario);
        }
    
        //Metodo para iniciar sesion
        private static void iniciarSesion(Scanner scanner) {
            System.out.println("Ingrese su usuario:");
            String usuario = scanner.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contrasena = scanner.nextLine();
    
            if (UserDB.iniciarSesion(usuario, contrasena)) {
                mostrarMenuRecomendaciones(scanner, usuario);
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
            }
        }

        //Metodo para mostrar el menu de recomendaciones
        private static void mostrarMenuRecomendaciones(Scanner scanner, String usuario) {
            boolean continuar = true;
            while (continuar) {
                System.out.println("***************");
                System.out.println("Inicio de sesión exitoso.");
                System.out.println("***************");
                System.out.println("¿Qué recomendación deseas ver?");
                System.out.println("\u001B[33m1. Recomendación de Géneros");
                System.out.println("\u001B[35m2. Recomendación de Artistas");
                System.out.println("\u001B[36m3. Agregar una Cancion");
                System.out.println("\u001B[0m4. Quitar una Cancion");
                System.out.println("\u001B[31m5. Cerrar sesión");
    
                int recomendacion = scanner.nextInt();
                scanner.nextLine(); 
    
                switch (recomendacion) {
                    case 1:
                        recomendarGenero(scanner, usuario);
                        break;
                    case 2:
                        recomendarArtista(scanner, usuario);
                        break;
                    case 3:
                        System.out.println("Ingrese el nombre de la canción que desea agregar:");
                        String cancion = scanner.nextLine();
                        System.out.println("Ingrese el nombre del artista de la canción:");
                        String artista = scanner.nextLine();
                        System.out.println("Ingrese el género de la canción:");
                        String genero = scanner.nextLine();
                        agregarCancion(cancion, artista, genero);
                        break;
                    case 4: 
                        System.out.println("Ingrese el nombre de la canción que desea quitar:");
                        String cancionQuitar = scanner.nextLine();
                        System.out.println("Ingrese el nombre del artista de la canción:");
                        String artistaQuitar = scanner.nextLine();
                        System.out.println("Ingrese el género de la canción:");
                        String generoQuitar = scanner.nextLine();
                        quitarCancion(cancionQuitar, artistaQuitar, generoQuitar);
                        break;
                    case 5:
                        continuar = false;
                        System.out.println("Cerrando sesión...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        }
    
    private static void recomendarGenero(Scanner scanner, String usuario) {
        System.out.println("\u001B[0m");
        List<String> generos = db.obtenerNombresDeNodos("Genero");
        System.out.println("Géneros disponibles:");
        for (String genero : generos) {
            System.out.println(genero);
        }

        System.out.println("¿Qué género deseas ver?");
        String generoSeleccionado = scanner.nextLine();

        List<String> recomendaciones = db.obtenerRecomendacionesPorGenero(generoSeleccionado);
        if (recomendaciones.isEmpty()) {
            System.out.println("No se encontraron recomendaciones para el género " + generoSeleccionado);
        } else {
            System.out.println("Las canciones de este género son:");
            for (String recomendacion : recomendaciones) {
                System.out.println(recomendacion);
            }
        }

        UserDB.agregarPreferenciaCSV(usuario, generoSeleccionado); // Guardar preferencia de usuario en CSV
    }

    private static void recomendarArtista(Scanner scanner, String usuario) {
        System.out.println("\u001B[0m");
        List<String> artistas = db.obtenerNombresDeNodos("Artista");
        System.out.println("Artistas disponibles:");
        for (String artista : artistas) {
            System.out.println(artista);
        }
        System.out.println("¿Qué artista deseas ver?");
        String artistaElegido = scanner.nextLine();
        System.out.println("Artista elegido: " + artistaElegido); // Mensaje de depuración

        List<String> recomendaciones = db.obtenerRecomendacionesPorArtista(artistaElegido);

        if (recomendaciones.isEmpty()) {
            System.out.println("No se encontraron recomendaciones para el artista " + artistaElegido);
        } else {
            System.out.println("Las canciones de este artista son:");
            for (String recomendacion : recomendaciones) {
                System.out.println(recomendacion);
            }
            UserDB.agregarPreferenciaCSV(usuario, artistaElegido);
            System.out.println("Preferencia agregada exitosamente al CSV.");
        }
    }

    private static void agregarCancion(String cancion, String artista, String genero) {
        System.out.println("\u001B[0m");
        System.out.println("Agregando canción: " + cancion);
        System.out.println("Artista: " + artista);
        System.out.println("Genero: " + genero);

        // Verificar si la canción ya existe en Neo4j
        if (db.existeCancion(cancion)) {
            System.out.println("La canción ya existe en la base de datos Neo4j.");
            return;
        }

        // Agregar nodos y relaciones en Neo4j
        db.crearNodo("Cancion", cancion);
        db.crearNodo("Artista", artista);
        db.crearNodo("Genero", genero);

        System.out.println("Creando relación CANTA...");
        db.crearRelacion("Artista", artista, "CANTA", "Cancion", cancion);

        System.out.println("Creando relación PERTENECE_A...");
        db.crearRelacion("Cancion", cancion, "PERTENECE_A", "Genero", genero);

        System.out.println("Canción agregada exitosamente en Neo4j.");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.newLine();
            writer.write(cancion + ";" + artista + ";" + genero);
            System.out.println("Canción agregada exitosamente en el archivo CSV.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }

    private static void quitarCancion(String cancion, String artista, String genero) {
        System.out.println("\u001B[0m");
        // Eliminar nodos y relaciones en Neo4j
        db.eliminarNodo("Cancion", cancion);
        System.out.println("Canción eliminada exitosamente de Neo4j.");

        // Actualizar el archivo CSV eliminando la línea correspondiente
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(rutaArchivo))) {
                for (String linea : lineas) {
                    if (!linea.equals(cancion + ";" + artista + ";" + genero)) {
                        writer.write(linea);
                        writer.newLine();
                    }
                }
            }
            System.out.println("Canción eliminada exitosamente del archivo CSV.");
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo CSV: " + e.getMessage());
        }
    }
    }