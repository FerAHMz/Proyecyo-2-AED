package uvg.edu.gt;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Values;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DataBase {
    public final Driver driver;

    public DataBase(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    public void close() {
        driver.close();
    }   

    @SuppressWarnings("deprecation")
    public void crearNodo(String tipo, String nombre) {
        try (Session session = driver.session()) {
            String query = "MERGE (n:" + tipo + " {name: $name}) RETURN n";
            session.writeTransaction(tx -> {
                tx.run(query, Values.parameters("name", nombre)).consume();
                return null;
            });
        } catch (Exception e) {
            System.out.println("Error al crear nodo: " + e.getMessage());
        }
    }

    @SuppressWarnings("deprecation")
    public void crearRelacion(String tipo1, String nombre1, String relacion, String tipo2, String nombre2) {
        try (Session session = driver.session()) {
            String query = "MATCH (a:" + tipo1 + " {name: $nombre1}), (b:" + tipo2 + " {name: $nombre2}) " +
                    "MERGE (a)-[r:" + relacion + "]->(b)";
            session.writeTransaction(tx -> {
                tx.run(query, Values.parameters("nombre1", nombre1, "nombre2", nombre2)).consume();
                return null;
            });
        } catch (Exception e) {
            System.out.println("Error al crear relación: " + e.getMessage());
        }
    }
}
