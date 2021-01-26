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
public class BandTest {

    public BandTest() {
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

    private ArrayList<String> leden = new ArrayList<>();
    private Band instance = new Band("Band", "pop", leden);

    /**
     * Test of bekijkArtiest method, of class Band.
     */
    @Test
    public void testBekijkArtiest() {
        System.out.println("bekijkArtiest");
        leden.add("jaap");
        String expResult = "Deze artiest is een band "
                + "en maakt muziek onder de naam " + "Band" + ".\n"
                + "Het genre van deze artiest is " + "pop" + ".\n"
                + "De band bestaat uit de volgende leden: "
                + "jaap" + ".\n"
                + "De volgende albums zijn beschikbaar om af te spelen: "
                + "";
        String result = instance.bekijkArtiest();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBandLeden method, of class Band.
     */
    @Test
    public void testGetBandLeden() {
        System.out.println("getBandLeden");
        ArrayList expResult = leden;
        ArrayList result = instance.getBandLeden();
        assertEquals(expResult, result);
    }

}
