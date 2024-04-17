package uvg.edu.gt;

import org.neo4j.driver.*;
import org.neo4j.driver.Record;



public class DataBase {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver(
                "bolt://localhost:7687",
                AuthTokens.basic(
                        "neo4j",
                        "12345678"

                ));
        
        try (Session session = driver.session()) {

            session.writeTransaction(tx -> {
                tx.run("CREATE (user:Genero {name:'Urbano'})");
                tx.run("CREATE (user:Genero {name:'Regeton'})");
                tx.run("CREATE (user:Genero {name:'Pop'})");
                tx.run("CREATE (user:Artista {name:'Milo J'})");
                tx.run("CREATE (user:Artista {name:'Bad Bunny'})");
                tx.run("CREATE (user:Artista {name:'Justin Biber'})");
                tx.run("CREATE (user:Cancion {name:'Toi hecho'})");
                tx.run("CREATE (user:Cancion {name:'La cancion'})");
                tx.run("CREATE (user:Cancion {name:'Never Say Never'})");
                return null;
            });

            Result result = session.run("MATCH (n) RETURN n.name AS name");
            while (result.hasNext()) {
                Record record = result.next();
                String name = record.get("name").asString();
                System.out.println("Name: " + name);
            }

            result = session.run("""
                    MATCH (a:Artista {name:"Justin Biber"}), (c:Cancion {name:"Never Say Never"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (p:Person {name:"Lugol"}), (a:Serie {name:"The Boys"})
                    MERGE (p)-[e:WATCH]-(a)
                    RETURN p.name, e, a.name
                    """
            );
            result = session.run("""
                    MATCH (p:Person {name:"Nico"}), (a:Serie {name:"Suits"})
                    MERGE (p)-[e:WATCH]-(a)
                    RETURN p.name, e, a.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Never Say Never"}), (g:Genero {name:"Pop"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN s.name, e, g.name
                    """
            );
            result = session.run("""
                    MATCH (s:Serie {name:"The Boys"}), (g:Genero {name:"Accion"})
                    MERGE (s)-[e:WATCH]-(g)
                    RETURN s.name, e, g.name
                    """
            );
            result = session.run("""
                    MATCH (s:Serie {name:"Suits"}), (g:Genero {name:"Novelas"})
                    MERGE (s)-[e:WATCH]-(g)
                    RETURN s.name, e, g.name
                    """
            );

            while (result.hasNext()) {
                Record record = result.next();
                System.out.println(record);
            }

            result = session.run("MATCH (n) RETURN n.name AS name");
            while (result.hasNext()) {
                Record record = result.next();
                String name = record.get("name").asString();
                System.out.println("Name: " + name);
            }

        } finally {
            driver.close();
        }
    }
    
}