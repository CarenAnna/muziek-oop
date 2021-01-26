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
public class MuziekTest {

    public MuziekTest() {
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

    private Muziek instance = new Muziek();
    private UserPlaylist user = new UserPlaylist("Test");
    private Playlist huidig = new UserPlaylist("Huidig");
    private ArrayList<UserPlaylist> userPlaylists = new ArrayList<>();
    private Nummer nul = new Nummer("Nul", 120);
    private Nummer een = new Nummer("Een", 110);
    private ArrayList<Nummer> nummers = new ArrayList<>();
    private Album album = new Album("Album", 2020, nummers);
    private ArrayList<Album> albums = new ArrayList<>();
    private ArrayList<Artiest> artiesten = new ArrayList<>();
    private Artiest artiest = new Solist("Bob", "punk");

    /**
     * Test of get- and setUserPlaylist method, of class Muziek.
     */
    @Test
    public void testGetSetUserPlaylist() {
        System.out.println("get- and setUserPlaylist");
        instance.setUserPlaylist(user);
        UserPlaylist expResult = user;
        UserPlaylist result = instance.getUserPlaylist();
        assertEquals(expResult, result);
    }

    /**
     * Test of get- and setHuidigePlaylist method, of class Muziek.
     */
    @Test
    public void testGetSetHuidigePlaylist() {
        System.out.println("get- and setHuidigePlaylist");
        instance.setHuidigePlaylist(huidig);
        Playlist expResult = huidig;
        Playlist result = instance.getHuidigePlaylist();
        assertEquals(expResult, result);
    }

    /**
     * Test of get- and setUserPlaylists method, of class Muziek.
     */
    @Test
    public void testGetSetUserPlaylists() {
        System.out.println("get- and setUserPlaylists");
        userPlaylists.add(user);
        instance.setUserPlaylists(userPlaylists);
        ArrayList<UserPlaylist> expResult = userPlaylists;
        ArrayList<UserPlaylist> result = instance.getUserPlaylists();
        assertEquals(expResult, result);
    }

    /**
     * Test of get- and setAlbums method, of class Muziek.
     */
    @Test
    public void testGetSetAlbums() {
        System.out.println("get- and setAlbums");
        instance.setAlbums(albums);
        ArrayList<Album> expResult = albums;
        ArrayList<Album> result = instance.getAlbums();
        assertEquals(expResult, result);
    }

    /**
     * Test of get- and setArtiesten method, of class Muziek.
     */
    @Test
    public void testGetSetArtiesten() {
        System.out.println("get- and setArtiesten");
        instance.setArtiesten(artiesten);
        ArrayList<Artiest> expResult = artiesten;
        ArrayList<Artiest> result = instance.getArtiesten();
        assertEquals(expResult, result);
    }

    /**
     * Test of get- and setHuidigeArtiest method, of class Muziek.
     */
    @Test
    public void testGetSetHuidigeArtiest() {
        System.out.println("get- and setHuidigeArtiest");
        instance.setHuidigeArtiest(artiest);
        Artiest expResult = artiest;
        Artiest result = instance.getHuidigeArtiest();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMuziek method, of class Muziek.
     */
    @Test
    public void testGetMuziek() {
        System.out.println("getMuziek");
        Muziek expResult = instance.getMuziek();
        Muziek result = Muziek.getMuziek();
        assertEquals(expResult, result);
    }

    /**
     * Test of get- and setHuidigeNummerIndex method, of class Muziek.
     */
    @Test
    public void testGetSetHuidigeNummerIndex() {
        System.out.println("get- and setHuidigeNummerIndex");
        instance.setHuidigeNummerIndex(1);
        int expResult = 1;
        int result = instance.getHuidigeNummerIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHuidigeNummerTitel method, of class Muziek. Using previously
     * tested methods.
     */
    @Test
    public void testGetHuidigeNummerTitel() {
        System.out.println("getHuidigeNummerTitel");
        nummers.add(nul);
        nummers.add(een);
        instance.setHuidigePlaylist(album);
        instance.setHuidigeNummerIndex(1);
        String result = instance.getHuidigePlaylist().getAlbumNummers().get(
                instance.getHuidigeNummerIndex()).getTitel();
        String expResult = "Een";
        assertEquals(expResult, result);
    }

}
