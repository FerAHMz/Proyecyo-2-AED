package uvg.edu.gt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Scanner;

/**
 * Clase principal que ejecuta el prototipo del sistema de recomendación de música.
 */
public class Main {

    private static DataBase db;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        // Inicializar la base de datos y cargar datos desde CSV
        db = new DataBase("bolt://localhost:7687", "neo4j", "123456789");
        db.importarDesdeCSV("src/main/resources/data.csv");

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
