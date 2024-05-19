package uvg.edu.gt;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Base64;

/**
 * Clase que gestiona la base de datos de usuarios y sus preferencias.
 */
public class UserDB {
    private static final String USERS_CSV = "src/main/resources/users.csv";
    private static final String PREFERENCIAS_CSV = "src/main/resources/preferenciasUsuario.csv";
    private static Map<String, Usuario> usuarios = new HashMap<>();

    static {
        cargarUsuariosDesdeCSV();
    }

    /**
     * Carga los usuarios desde un archivo CSV.
     */
    private static void cargarUsuariosDesdeCSV() {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(USERS_CSV)).build()) {
            List<String[]> data = reader.readAll();
            for (String[] line : data) {
                if (line.length < 4) continue;
                String nombre = line[0];
                String usuario = line[1];
                String correo = line[2];
                String contrasena = line[3];
                usuarios.put(usuario, new Usuario(nombre, usuario, correo, contrasena, true));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario El usuario a registrar.
     */
    public static void registrarUsuario(Usuario usuario) {
        if (!usuarios.containsKey(usuario.getUsuario())) {
            usuarios.put(usuario.getUsuario(), usuario);
            guardarUsuarioEnCSV(usuario);
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("El usuario ya existe.");
        }
    }

    /**
     * Guarda un usuario en el archivo CSV.
     *
     * @param usuario El usuario a guardar.
     */
    private static void guardarUsuarioEnCSV(Usuario usuario) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(USERS_CSV, true))) {
            String[] record = {usuario.getNombre(), usuario.getUsuario(), usuario.getCorreo(), usuario.getContrasena()};
            writer.writeNext(record);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicia sesión para un usuario.
     *
     * @param usuario    El nombre de usuario.
     * @param contrasena La contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public static boolean iniciarSesion(String usuario, String contrasena) {
        Usuario u = usuarios.get(usuario);
        if (u == null) {
            return false;
        }

        String hashedContrasena = hashContrasena(contrasena);
        return u.getContrasena().equals(hashedContrasena);
    }

    /**
     * Genera el hash de una contraseña.
     *
     * @param contrasena La contraseña a hashear.
     * @return El hash de la contraseña.
     */
    private static String hashContrasena(String contrasena) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(contrasena.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Agrega una preferencia de usuario en el archivo CSV.
     *
     * @param usuario     El nombre de usuario.
     * @param preferencia La preferencia a agregar.
     */
    public static void agregarPreferenciaCSV(String usuario, String preferencia) {
        Map<String, String> preferenciasUsuarios = new HashMap<>();

        try (CSVReader csvReader = new CSVReaderBuilder(Files.newBufferedReader(Paths.get(PREFERENCIAS_CSV))).withSkipLines(1).build()) {
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                String user = row[0];
                String preferenciaActual = row[1];
                preferenciasUsuarios.put(user, preferenciasUsuarios.getOrDefault(user, "") + preferenciaActual + ",");
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        String nuevasPreferencias = preferenciasUsuarios.getOrDefault(usuario, "") + preferencia;
        preferenciasUsuarios.put(usuario, nuevasPreferencias);

        try (CSVWriter writer = new CSVWriter(new FileWriter(PREFERENCIAS_CSV))) {
            writer.writeNext(new String[]{"Usuario", "Preferencias"});
            for (Map.Entry<String, String> entry : preferenciasUsuarios.entrySet()) {
                writer.writeNext(new String[]{entry.getKey(), entry.getValue()});
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Imprime los usuarios cargados desde el archivo CSV.
     */
    public static void imprimirUsuariosCargados() {
        System.out.println("Usuarios cargados desde el CSV:");
        for (Usuario u : usuarios.values()) {
            System.out.println("Usuario: " + u.getUsuario() + ", Contraseña (hash): " + u.getContrasena());
        }
    }
}
