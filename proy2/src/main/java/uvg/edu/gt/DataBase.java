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
                //Nico
                tx.run("CREATE (user: Genero {name:'Bubblegum Pop'})");
                tx.run("CREATE (user: Genero {name:'Electronica'})");
                tx.run("CREATE (user: Genero {name:'Post-Rock'})");
                tx.run("CREATE (user: Genero {name:'New Age'})");
                tx.run("CREATE (user: Genero {name:'Synth-Score'})");
                tx.run("CREATE (user: Genero {name:'Experimental'})");
                tx.run("CREATE (user: Genero {name:'EDM'})");
                tx.run("CREATE (user: Genero {name:'Minimalist'})");
                tx.run("CREATE (user: Genero {name:'Trance'})");
                tx.run("CREATE (user: Genero {name:'Ambient'})");
                tx.run("CREATE (user: Genero {name:'Son Cubano'})");
                tx.run("CREATE (user: Genero {name:'Classical Crossover'})");
                tx.run("CREATE (user: Genero {name:'Ambient'})");
                tx.run("CREATE (user: Genero {name:'Indie Folk'})");
                tx.run("CREATE (user: Genero {name:'Post-Rock'})");
                tx.run("CREATE (user: Genero {name:'Electronic'})");
                tx.run("CREATE (user: Genero {name:'Electronica'})");
                tx.run("CREATE (user: Genero {name:'Indie Pop'})");
                tx.run("CREATE (user: Genero {name:'Trip Hop'})");
                tx.run("CREATE (user: Genero {name:'Psychedelic Rock'})");
                //Artistas
                tx.run("CREATE (user: Artista {name:'Carly Rae Jepsen'})");
                tx.run("CREATE (user: Artista {name:'Moby'})");
                tx.run("CREATE (user: Artista {name:'Sigur Rós'})");
                tx.run("CREATE (user: Artista {name:'Enya'})");
                tx.run("CREATE (user: Artista {name:'Vangelis'})");
                tx.run("CREATE (user: Artista {name:'Björk'})");
                tx.run("CREATE (user: Artista {name:'Steve Aoki'})");
                tx.run("CREATE (user: Artista {name:'Yann Tiersen'})");
                tx.run("CREATE (user: Artista {name:'Armin van Buuren'})");
                tx.run("CREATE (user: Artista {name:'Boards of Canada'})");
                tx.run("CREATE (user: Artista {name:'Buena Vista Social Club'})");
                tx.run("CREATE (user: Artista {name:'Ludovico Einaudi'})");
                tx.run("CREATE (user: Artista {name:'Brian Eno'})");
                tx.run("CREATE (user: Artista {name:'Sufjan Stevens'})");
                tx.run("CREATE (user: Artista {name:'Explosions in the Sky'})");
                tx.run("CREATE (user: Artista {name:'Kraftwerk'})");
                tx.run("CREATE (user: Artista {name:'Aphex Twin'})");
                tx.run("CREATE (user: Artista {name:'Alt-J'})");
                tx.run("CREATE (user: Artista {name:'Massive Attack'})");
                tx.run("CREATE (user: Artista {name:'Tame Impala'})");
                //Canciones
                tx.run("CREATE (user: Cancion {name:'Call Me Maybe'})");
                tx.run("CREATE (user: Cancion {name:'Porcelain'})");
                tx.run("CREATE (user: Cancion {name:'Hoppípolla'})");
                tx.run("CREATE (user: Cancion {name:'Only Time'})");
                tx.run("CREATE (user: Cancion {name:'Chariots of Fire'})");
                tx.run("CREATE (user: Cancion {name:'Joga'})");
                tx.run("CREATE (user: Cancion {name:'Delirious'})");
                tx.run("CREATE (user: Cancion {name:'Comptine d'un autre été : L'après-midi'})");
                tx.run("CREATE (user: Cancion {name:'Blah Blah Blah'})");
                tx.run("CREATE (user: Cancion {name:'Dayvan Cowboy'})");
                tx.run("CREATE (user: Cancion {name:'Chan Chan'})");
                tx.run("CREATE (user: Cancion {name:'Nuvole Bianche'})");
                tx.run("CREATE (user: Cancion {name:'An Ending (Ascent)'})");
                tx.run("CREATE (user: Cancion {name:'Chicago'})");
                tx.run("CREATE (user: Cancion {name:'Your Hand in Mine'})");
                tx.run("CREATE (user: Cancion {name:'Autobahn'})");
                tx.run("CREATE (user: Cancion {name:'Avril 14th'})");
                tx.run("CREATE (user: Cancion {name:'Breezeblocks'})");
                tx.run("CREATE (user: Cancion {name:'Teardrop'})");
                tx.run("CREATE (user: Cancion {name:'The Less I Know the Better'})");


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

                //Nico
                result = session.run("""
                        MATCH (a:Artista {name:"Carly Rae Jepsen"}), (c:Cancion {name:"Call Me Maybe"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Call Me Maybe"}), (g:Genero {name:"Bubblegum Pop"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Moby"}), (c:Cancion {name:"Porcelain"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Porcelain"}), (g:Genero {name:"Electronica"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Sigur Rós"}), (c:Cancion {name:"Hoppípolla"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Hoppípolla"}), (g:Genero {name:"Post-Rock"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Enya"}), (c:Cancion {name:"Only Time"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Only Time"}), (g:Genero {name:"New Age"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Vangelis"}), (c:Cancion {name:"Chariots of Fire"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Chariots of Fire"}), (g:Genero {name:"Synth-Score"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Björk"}), (c:Cancion {name:"Joga"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Joga"}), (g:Genero {name:"Experimental"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Steve Aoki"}), (c:Cancion {name:"Delirious"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Delirious"}), (g:Genero {name:"EDM"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Yann Tiersen"}), (c:Cancion {name:"Comptine d'un autre été : L'après-midi"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Comptine d'un autre été : L'après-midi"}), (g:Genero {name:"Minimalist"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Armin van Buuren"}), (c:Cancion {name:"Blah Blah Blah"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Blah Blah Blah"}), (g:Genero {name:"Trance"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Boards of Canada"}), (c:Cancion {name:"Dayvan Cowboy"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Dayvan Cowboy"}), (g:Genero {name:"Ambient"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Buena Vista Social Club"}), (c:Cancion {name:"Chan Chan"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Chan Chan"}), (g:Genero {name:"Son Cubano"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Ludovico Einaudi"}), (c:Cancion {name:"Nuvole Bianche"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Nuvole Bianche"}), (g:Genero {name:"Classical Crossover"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Brian Eno"}), (c:Cancion {name:"An Ending (Ascent)"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"An Ending (Ascent)"}), (g:Genero {name:"Ambient"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Sufjan Stevens"}), (c:Cancion {name:"Chicago"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Chicago"}), (g:Genero {name:"Indie Folk"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Explosions in the Sky"}), (c:Cancion {name:"Your Hand in Mine"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Your Hand in Mine"}), (g:Genero {name:"Post-Rock"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Kraftwerk"}), (c:Cancion {name:"Autobahn"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Autobahn"}), (g:Genero {name:"Electronic"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Aphex Twin"}), (c:Cancion {name:"Avril 14th"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Avril 14th"}), (g:Genero {name:"Electronica"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Alt-J"}), (c:Cancion {name:"Breezeblocks"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Breezeblocks"}), (g:Genero {name:"Indie Pop"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Massive Attack"}), (c:Cancion {name:"Teardrop"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"Teardrop"}), (g:Genero {name:"Trip Hop"})
                        MERGE (c)-[e:WATCH]-(g)
                        RETURN c.name, e, g.name
                        """
                );
                result = session.run("""
                        MATCH (a:Artista {name:"Tame Impala"}), (c:Cancion {name:"The Less I Know the Better"})
                        MERGE (a)-[e:WATCH]-(c)
                        RETURN a.name, e, c.name
                        """
                );
                result = session.run("""
                        MATCH (c:Cancion {name:"The Less I Know the Better"}), (g:Genero {name:"Psychedelic Rock"})
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