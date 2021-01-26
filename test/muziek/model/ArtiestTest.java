/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Caren
 */
public class ArtiestTest {

    public ArtiestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private ArrayList<Nummer> testNummer = new ArrayList<>();
    private Album test = new Album("Test", 2020, testNummer);
    private ArrayList<Album> albums = new ArrayList<>();
    private Artiest instance = new Solist("Piet", "pop");

    /**
     * Test of addAlbum and getAlbums method, of class Artiest.
     */
    @Test
    public void testGetAlbums() {
        System.out.println("getAlbums");
        instance.addAlbum(test);
        albums.add(test);
        ArrayList<Album> expResult = albums;
        ArrayList<Album> result = instance.getAlbums();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArtiestNummers method, of class Artiest.
     */
    @Test
    public void testGetArtiestNummers() {
        System.out.println("getArtiestNummers");
        instance.addAlbum(test);
        ArrayList<Nummer> expResult = testNummer;
        ArrayList<Nummer> result = instance.getArtiestNummers();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNaam method, of class Artiest.
     */
    @Test
    public void testGetNaam() {
        System.out.println("getNaam");
        String expResult = "Piet";
        String result = instance.getNaam();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGenre method, of class Artiest.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        String expResult = "pop";
        String result = instance.getGenre();
        assertEquals(expResult, result);
    }

    public class ArtiestImpl extends Artiest {

        public ArtiestImpl() {
            super("", "");
        }

        public String bekijkArtiest() {
            return "";
        }
    }

}
