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
                tx.run("CREATE (user:Genero {name:'Fol Rock'})");
                tx.run("CREATE (user:Genero {name:'Salsa'})");
                tx.run("CREATE (user:Genero {name:'Rock'})");
                tx.run("CREATE (user:Genero {name:'Afrobeat'})");
                tx.run("CREATE (user:Genero {name:'Latin Pop'})");
                tx.run("CREATE (user:Genero {name:'Indie Rock'})");
                tx.run("CREATE (user:Genero {name:'Heavy Metal'})");
                tx.run("CREATE (user:Genero {name:'Country'})");
                tx.run("CREATE (user:Genero {name:'Hip-Hop'})");
                tx.run("CREATE (user:Genero {name:'Jazz'})");
                tx.run("CREATE (user:Genero {name:'Soul'})");
                tx.run("CREATE (user:Genero {name:'R&B'})");
                tx.run("CREATE (user:Artista {name:'Milo J'})");
                tx.run("CREATE (user:Artista {name:'Bad Bunny'})");
                tx.run("CREATE (user:Artista {name:'Justin Biber'})");
                tx.run("CREATE (user:Artista {name:'Shakira'})");
                tx.run("CREATE (user:Artista {name:'Rihanna'})");
                tx.run("CREATE (user:Artista {name:'Queen'})");
                tx.run("CREATE (user:Artista {name:'Prince'})");
                tx.run("CREATE (user:Artista {name:'Ozzy Osbourne'})");
                tx.run("CREATE (user:Artista {name:'Nina Simone'})");
                tx.run("CREATE (user:Artista {name:'Miles Davis'})");
                tx.run("CREATE (user:Artista {name:'Lorde'})");
                tx.run("CREATE (user:Artista {name:'Kendrick Lamar'})");
                tx.run("CREATE (user:Artista {name:'Johnny Cash'})");
                tx.run("CREATE (user:Artista {name:'Iron Maiden'})");
                tx.run("CREATE (user:Artista {name:'Hozier'})");
                tx.run("CREATE (user:Artista {name:'Gloria Estefan'})");
                tx.run("CREATE (user:Artista {name:'Fela Kuti'})");
                tx.run("CREATE (user:Artista {name:'Ed Sheeran'})");
                tx.run("CREATE (user:Artista {name:'David Bowie'})");
                tx.run("CREATE (user:Artista {name:'Celia Cruz'})");
                tx.run("CREATE (user:Artista {name:'Bob Dylan'})");
                tx.run("CREATE (user:Artista {name:'Adele'})");
                tx.run("CREATE (user:Cancion {name:'Toi hecho'})");
                tx.run("CREATE (user:Cancion {name:'La cancion'})");
                tx.run("CREATE (user:Cancion {name:'Never Say Never'})");
                tx.run("CREATE (user:Cancion {name:'Someone Like You'})");
                tx.run("CREATE (user:Cancion {name:'Like a Rolling Stone'})");
                tx.run("CREATE (user:Cancion {name:'La Vida es un Carnaval'})");
                tx.run("CREATE (user:Cancion {name:'Space Oddity'})");
                tx.run("CREATE (user:Cancion {name:'Shape of You'})");
                tx.run("CREATE (user:Cancion {name:'Water No Get Enemy'})");
                tx.run("CREATE (user:Cancion {name:'Conga'})");
                tx.run("CREATE (user:Cancion {name:'Take Me to Church'})");
                tx.run("CREATE (user:Cancion {name:'The Trooper'})");
                tx.run("CREATE (user:Cancion {name:'Ring of Fire'})");
                tx.run("CREATE (user:Cancion {name:'Alright'})");
                tx.run("CREATE (user:Cancion {name:'Royals'})");
                tx.run("CREATE (user:Cancion {name:'So What'})");
                tx.run("CREATE (user:Cancion {name:'Feeling Good'})");
                tx.run("CREATE (user:Cancion {name:'Crazy Train'})");
                tx.run("CREATE (user:Cancion {name:'Purple Rain'})");
                tx.run("CREATE (user:Cancion {name:'Bohemian Rhapsody'})");
                tx.run("CREATE (user:Cancion {name:'Umbrella'})");
                tx.run("CREATE (user:Cancion {name:'Hips Don't Lie'})");
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
                    MATCH (c:Cancion {name:"Never Say Never"}), (g:Genero {name:"Pop"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Adele"}), (c:Cancion {name:"Someone Like You"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Someone Like You"}), (g:Genero {name:"Pop"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Bob Dylan"}), (c:Cancion {name:"Like a Rolling Stone"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Like a Rolling Stone"}), (g:Genero {name:"Folk Rock"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Celia Cruz"}), (c:Cancion {name:"La Vida es un Carnaval"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"La Vida es un Carnaval"}), (g:Genero {name:"Salsa"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"David Bowie"}), (c:Cancion {name:"Space Oddity"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Space Oddity"}), (g:Genero {name:"Rock"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Ed Sheeran"}), (c:Cancion {name:"Shape of You"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Shape of You"}), (g:Genero {name:"Pop"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Fela Kuti"}), (c:Cancion {name:"Water No Get Enemy"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Water No Get Enemy"}), (g:Genero {name:"Afrobeat"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Gloria Estefan"}), (c:Cancion {name:"Conga"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Conga"}), (g:Genero {name:"Latino Pop"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Hozier"}), (c:Cancion {name:"Take Me to Church"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Take Me to Church"}), (g:Genero {name:"Indie Rock"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Iron Maiden"}), (c:Cancion {name:"The Trooper"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"The Trooper"}), (g:Genero {name:"Heavy Metal"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Johnny Cash"}), (c:Cancion {name:"Ring of Fire"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Ring of Fire"}), (g:Genero {name:"Country"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Kendrick Lamar"}), (c:Cancion {name:"Alright"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Alright"}), (g:Genero {name:"Hip-Hop"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Lorde"}), (c:Cancion {name:"Royals"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Royals"}), (g:Genero {name:"Pop"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Miles Davis"}), (c:Cancion {name:"So What"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"So What"}), (g:Genero {name:"Jazz"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Nina Simone"}), (c:Cancion {name:"Feeling Good"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Feeling Good"}), (g:Genero {name:"Soul"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Ozzy Osbourn"}), (c:Cancion {name:"Crazy Train"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Crazy Train"}), (g:Genero {name:"Heavy Metal"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Prince"}), (c:Cancion {name:"Purple Rain"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Purple Rain"}), (g:Genero {name:"Pop"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Queen"}), (c:Cancion {name:"Bohemian Rhapsody"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Bohemian Rhapsody"}), (g:Genero {name:"Rock"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Rihanna"}), (c:Cancion {name:"Umbrella"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Umbrella"}), (g:Genero {name:"R&B"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
                    """
            );

            result = session.run("""
                    MATCH (a:Artista {name:"Shakira"}), (c:Cancion {name:"Hips Don't Lie"})
                    MERGE (a)-[e:WATCH]-(c)
                    RETURN a.name, e, c.name
                    """
            );
            result = session.run("""
                    MATCH (c:Cancion {name:"Hips Don't Lie"}), (g:Genero {name:"Pop"})
                    MERGE (c)-[e:WATCH]-(g)
                    RETURN c.name, e, g.name
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