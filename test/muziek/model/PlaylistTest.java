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
public class PlaylistTest {

    public PlaylistTest() {
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

    private ArrayList<Nummer> testNummers = new ArrayList<>();
    private Playlist instance = new Album("Test", 2020, testNummers);

    /**
     * Test of getTitel method, of class Playlist.
     */
    @Test
    public void testGetTitel() {
        System.out.println("getTitel");
        String expResult = "Test";
        String result = instance.getTitel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitel method, of class Playlist.
     */
    @Test
    public void testSetTitel() {
        System.out.println("setTitel");
        String titel = "TestTwee";
        instance.setTitel(titel);
        String expResult = "TestTwee";
        String result = instance.getTitel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAlbumNummers method, of class Playlist.
     */
    @Test
    public void testGetAlbumNummers() {
        System.out.println("getAlbumNummers");
        ArrayList<Nummer> expResult = testNummers;
        ArrayList<Nummer> result = instance.getAlbumNummers();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAlbumNummers method, of class Playlist.
     */
    @Test
    public void testSetAlbumNummers() {
        System.out.println("setAlbumNummers");
        ArrayList<Nummer> albumNummers = new ArrayList<>();
        instance.setAlbumNummers(albumNummers);
        ArrayList<Nummer> expResult = albumNummers;
        ArrayList<Nummer> result = instance.getAlbumNummers();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAlbumDuur and berekenDuur method, of class Playlist.
     */
    @Test
    public void testGetAlbumDuur() {
        System.out.println("getAlbumDuur and berekenDuur");
        instance.berekenDuur();
        int expResult = 0;
        int result = instance.getAlbumDuur();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAlbumDuur method, of class Playlist.
     */
    @Test
    public void testSetAlbumDuur() {
        System.out.println("setAlbumDuur");
        int albumDuur = 200;
        instance.setAlbumDuur(albumDuur);
        int expResult = 200;
        int result = instance.getAlbumDuur();
        assertEquals(expResult, result);
    }

    public class PlaylistImpl extends Playlist {

        public PlaylistImpl() {
            super("");
        }
    }
}
