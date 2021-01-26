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
public class AlbumTest {

    public AlbumTest() {
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

    /**
     * Test of getJaartal method, of class Album.
     */
    @Test
    public void testGetJaartal() {
        System.out.println("getJaartal");
        ArrayList<Nummer> albumNummers = new ArrayList<>();
        Album instance = new Album("Test", 2020, albumNummers);
        int expResult = 2020;
        int result = instance.getJaartal();
        assertEquals(expResult, result);
    }

}
