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
public class UserPlaylistTest {

    public UserPlaylistTest() {
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

    private UserPlaylist instance = new UserPlaylist("Test");
    private ArrayList<Nummer> nummers = new ArrayList<>();
    private Nummer nummer = new Nummer("Nummer", 120);

    /**
     * Test of toevoegen method, of class UserPlaylist.
     */
    @Test
    public void testToevoegen_Album() {
        System.out.println("toevoegen album");
        Album album = new Album("Album", 2020, nummers);
        instance.toevoegen(album);
        ArrayList<Nummer> expResult = nummers;
        ArrayList<Nummer> result = instance.getAlbumNummers();
        assertEquals(expResult, result);
    }

    /**
     * Test of toevoegen method, of class UserPlaylist.
     */
    @Test
    public void testToevoegen_Nummer() {
        System.out.println("toevoegen nummer");
        nummers.add(nummer);
        instance.toevoegen(nummer);
        ArrayList<Nummer> expResult = nummers;
        ArrayList<Nummer> result = instance.getAlbumNummers();
        assertEquals(expResult, result);
    }

    /**
     * Test of verwijderen method, of class UserPlaylist.
     */
    @Test
    public void testVerwijderen() {
        System.out.println("verwijderen");
        instance.toevoegen(nummer);
        instance.verwijderen(nummer);
        Boolean expResult = true;
        Boolean result = nummers.isEmpty();
        assertEquals(expResult, result);
    }

}
