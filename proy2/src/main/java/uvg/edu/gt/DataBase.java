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

/**
 * Clase que gestiona la base de datos Neo4j.
 */
public class DataBase {
    public final Driver driver;

    public DataBase(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    public void close() {
        driver.close();
    }  

    /**
     * Crea un nodo en la base de datos Neo4j.
     *
     * @param tipo   El tipo de nodo (etiqueta).
     * @param nombre El nombre del nodo.
     */
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

    /**
     * Crea una relación entre dos nodos en la base de datos Neo4j.
     *
     * @param tipo1     El tipo del primer nodo (etiqueta).
     * @param nombre1   El nombre del primer nodo.
     * @param relacion  El tipo de relación.
     * @param tipo2     El tipo del segundo nodo (etiqueta).
     * @param nombre2   El nombre del segundo nodo.
     */
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

    /**
     * Elimina un nodo de la base de datos Neo4j.
     *
     * @param tipo   El tipo de nodo (etiqueta).
     * @param nombre El nombre del nodo.
     */
    @SuppressWarnings("deprecation")
    public void eliminarNodo(String tipo, String nombre) {
        try (Session session = driver.session()) {
            session.writeTransaction(tx -> {
                String query = String.format("MATCH (n:%s {name: $name}) DETACH DELETE n", tipo);
                tx.run(query, Values.parameters("name", nombre));
                return null;
            });
            System.out.println("Nodo " + tipo + " con nombre " + nombre + " eliminado.");
        } catch (Exception e) {
            System.out.println("Error al eliminar nodo: " + e.getMessage());
        }
    }

    /**
     * Verifica si existe una relación entre dos nodos en la base de datos Neo4j.
     *
     * @param tipo     El tipo de relación.
     * @param tipo1    El tipo del primer nodo (etiqueta).
     * @param tipo2    El tipo del segundo nodo (etiqueta).
     * @param nombre1  El nombre del primer nodo.
     * @param nombre2  El nombre del segundo nodo.
     * @return true si la relación existe, false en caso contrario.
     */
    @SuppressWarnings("deprecation")
    public boolean existeRelacion(String tipo, String tipo1, String tipo2, String nombre1, String nombre2) {
        try (Session session = driver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run("MATCH (a:" + tipo1 + " {name: $name1})-[r:" + tipo + "]->(b:" + tipo2 + " {name: $name2}) RETURN r",
                        org.neo4j.driver.Values.parameters("name1", nombre1, "name2", nombre2));
                return result.hasNext();
            });
        }
    }

    /**
     * Importa datos desde un archivo CSV y crea nodos y relaciones en la base de datos Neo4j.
     *
     * @param rutaArchivo La ruta del archivo CSV.
     */
    public void importarDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue; // Saltar la primera línea (cabecera)
                }
                String[] valores = linea.split(";");
                if (valores.length != 3) {
                    System.out.println("Línea no válida: " + linea);
                    continue;
                }
                String cancion = valores[0].trim();
                String artista = valores[1].trim();
                String genero = valores[2].trim();

                crearNodo("Cancion", cancion);
                crearNodo("Artista", artista);
                crearNodo("Genero", genero);

                crearRelacion("Artista", artista, "CANTA", "Cancion", cancion);
                crearRelacion("Cancion", cancion, "PERTENECE_A", "Genero", genero);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica los nodos de un tipo específico en la base de datos Neo4j.
     *
     * @param tipo El tipo de nodo (etiqueta).
     */
    @SuppressWarnings("deprecation")
    public void verificarNodos(String tipo) {
        try (Session session = driver.session()) {
            session.readTransaction(tx -> {
                Result result = tx.run(String.format("MATCH (n:%s) RETURN n.name AS name", tipo));
                while (result.hasNext()) {
                    Record record = result.next();
                    System.out.println(record.get("name").asString());
                }
                return null;
            });
        } catch (Exception e) {
            System.out.println("Error al verificar nodos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Obtiene los nombres de nodos de un tipo específico en la base de datos Neo4j.
     *
     * @param tipo El tipo de nodo (etiqueta).
     * @return Una lista con los nombres de los nodos.
     */
    @SuppressWarnings("deprecation")
    public List<String> obtenerNombresDeNodos(String tipo) {
        List<String> nombres = new ArrayList<>();
        try (Session session = driver.session()) {
            session.readTransaction(tx -> {
                String query = "MATCH (n:" + tipo + ") RETURN n.name AS name";
                Result result = tx.run(query);
                while (result.hasNext()) {
                    Record record = result.next();
                    nombres.add(record.get("name").asString());
                }
                return null;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombres;
    }

    /**
     * Verifica si una canción existe en la base de datos Neo4j.
     *
     * @param cancion El nombre de la canción.
     * @return true si la canción existe, false en caso contrario.
     */
    @SuppressWarnings("deprecation")
    public boolean existeCancion(String cancion) {
        try (Session session = driver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run("MATCH (c:Cancion {name: $name}) RETURN c",
                        Values.parameters("name", cancion));
                return result.hasNext();
            });
        }
    }

    /**
     * Obtiene recomendaciones de canciones por género.
     *
     * @param genero El nombre del género.
     * @return Una lista con las recomendaciones.
     */
    @SuppressWarnings("deprecation")
    public List<String> obtenerRecomendacionesPorGenero(String genero) {
        List<String> recomendaciones = new ArrayList<>();
        try (Session session = driver.session()) {
            session.readTransaction(tx -> {
                Result result = tx.run("MATCH (g:Genero {name: $name})<-[:PERTENECE_A]-(c:Cancion)-[:CANTA]->(a:Artista) RETURN c.name AS cancion, a.name AS artista",
                        org.neo4j.driver.Values.parameters("name", genero));
                while (result.hasNext()) {
                    Record record = result.next();
                    recomendaciones.add("Genero: " + genero + " - Artista: " + record.get("artista").asString() + " - Cancion: " + record.get("cancion").asString());
                }
                return null;
            });
        }
        return obtenerAleatorias(recomendaciones, 5);
    }

    /**
     * Obtiene recomendaciones de canciones por artista.
     *
     * @param artista El nombre del artista.
     * @return Una lista con las recomendaciones.
     */
    @SuppressWarnings("deprecation")
    public List<String> obtenerRecomendacionesPorArtista(String artista) {
        List<String> recomendaciones = new ArrayList<>();
        try (Session session = driver.session()) {
            session.readTransaction(tx -> {
                System.out.println("Buscando recomendaciones para el artista: " + artista); // Mensaje de depuración
                Result result = tx.run("MATCH (a:Artista {name: $name})-[:CANTA]->(c:Cancion)-[:PERTENECE_A]->(g:Genero) " +
                        "RETURN c.name AS cancion, g.name AS genero",
                        Values.parameters("name", artista));
                while (result.hasNext()) {
                    Record record = result.next();
                    recomendaciones.add("Genero: " + record.get("genero").asString() + " - Cancion: " + record.get("cancion").asString());
                }
                return null;
            });
        } catch (Exception e) {
            System.out.println("Error al obtener recomendaciones por artista: " + e.getMessage());
        }
        return obtenerAleatorias(recomendaciones, 5);
    }
    
    /**
     * Obtiene una lista aleatoria de recomendaciones.
     *
     * @param lista La lista de recomendaciones.
     * @param max   El número máximo de recomendaciones.
     * @return Una lista con las recomendaciones aleatorias.
     */
    private List<String> obtenerAleatorias(List<String> lista, int max) {
        Collections.shuffle(lista, new Random());
        return lista.size() > max ? lista.subList(0, max) : lista;
    }

    @SuppressWarnings("deprecation")
    public List<String> obtenerGenerosPorArtista(String artista) {
            List<String> generos = new ArrayList<>();
            try (Session session = driver.session()) {
                    session.readTransaction(tx -> {
                    Result result = tx.run("MATCH (a:Artista {name: $name})-[:CANTA]->(c:Cancion)-[:PERTENECE_A]->(g:Genero) " +
                                    "RETURN DISTINCT g.name AS genero",
                            Values.parameters("name", artista));
                    while (result.hasNext()) {
                            Record record = result.next();
                            generos.add(record.get("genero").asString());
                    }
                    return null;
                    });
            } catch (Exception e) {
                    System.out.println("Error al obtener géneros por artista: " + e.getMessage());
            }
            return generos;
    }

    @SuppressWarnings("deprecation")
    public List<String> obtenerCancionesPorArtistaYGenero(String artista, String genero) {
            List<String> recomendaciones = new ArrayList<>();
            try (Session session = driver.session()) {
                    session.readTransaction(tx -> {
                    Result result = tx.run("MATCH (a:Artista {name: $artista})-[:CANTA]->(c:Cancion)-[:PERTENECE_A]->(g:Genero {name: $genero}) " +
                                    "RETURN c.name AS cancion",
                            Values.parameters("artista", artista, "genero", genero));
                    while (result.hasNext()) {
                            Record record = result.next();
                            recomendaciones.add(record.get("cancion").asString());
                    }
                    return null;
                    });
            } catch (Exception e) {
                    System.out.println("Error al obtener canciones por artista y género: " + e.getMessage());
            }
            return recomendaciones;
    }

}
