package uvg.edu.gt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Clase que representa un usuario del sistema.
 * Se encarga de manejar la información del usuario y hash de la contraseña.
 */
public class Usuario {
    private String nombre;
    private String usuario;
    private String correo;
    private String contrasena;

    /**
     * Constructor de la clase Usuario.
     *
     * @param nombre      Nombre del usuario.
     * @param usuario     Nombre de usuario.
     * @param correo      Correo del usuario.
     * @param contrasena  Contraseña del usuario.
     * @param isHashed    Indica si la contraseña ya está hasheada.
     */
    public Usuario(String nombre, String usuario, String correo, String contrasena, boolean isHashed) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        if (isHashed) {
            this.contrasena = contrasena;
        } else {
            this.contrasena = hashContrasena(contrasena);
        }
    }

    private String hashContrasena(String contrasena) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(contrasena.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }
}
