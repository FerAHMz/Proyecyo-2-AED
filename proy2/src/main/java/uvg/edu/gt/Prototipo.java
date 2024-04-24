package uvg.edu.gt;

import java.util.Scanner;

public class Prototipo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al prototipo del proyecto");
        boolean menu = true;
        while (menu) {
            //Menu principal
            System.out.println("\u001B[32m");
            System.out.println("Ingresa una opción");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\u001B[34m");
                    System.out.println("Ingresa tu usuario");
                    System.out.println("Ingresa tu contraseña");
                    System.out.println("Iniciando sesión...");
                    System.out.println("Inicio de sesión exitoso!");
                    System.out.println("Que recomendacion deseas ver?");
                    System.out.println("\u001B[33m1. Recomendacion de Generos");
                    System.out.println("\u001B[35m2. Recomendacion de Artistas");
                    System.out.println("\u001B[36m3. Recomendacion de Canciones");
                    System.out.println("\u001B[31m4. Cerar sesión");
                    int opcionRecomendacion = sc.nextInt();
                    switch (opcionRecomendacion) {
                        case 1:
                            System.out.println("\u001B[33mRecomendacion de Generos");
                            System.out.println("\u001B[37m");
                            System.out.println("Estos son los generos que te recomendamos:");
                            System.out.println("Ejemplo 1");
                            System.out.println("Ejemplo 2");
                            System.out.println("Ejemplo 3");
                            System.out.println("Ejemplo 4");
                            break;
                        case 2:
                            System.out.println("\u001B[35mRecomendacion de Artistas");
                            break;
                        case 3:
                            System.out.println("\u001B[36mRecomendacion de Canciones");
                            break;
                        case 4:
                            System.out.println("Cerrando sesión...");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\u001B[33m");
                    System.out.println("Ingresa tu usuario");
                    System.out.println("Ingresa tu contraseña");
                    System.out.println("Registrando usuario...");
                    System.out.println("Usuario registrado exitosamente!");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    menu = false;
                    break;
            }
        }

    }
}
