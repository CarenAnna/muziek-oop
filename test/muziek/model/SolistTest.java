/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek.model;

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
public class SolistTest {

    public SolistTest() {
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
     * Test of bekijkArtiest method, of class Solist.
     */
    @Test
    public void testBekijkArtiest() {
        System.out.println("bekijkArtiest");
        Solist instance = new Solist("Test", "pop");
        String expResult = "De geselecteerde artiest is " + "Test" + ".\n"
                + "Het genre van deze artiest is " + "pop" + ".\n"
                + "De volgende albums zijn beschikbaar om af te spelen: "
                + "";
        String result = instance.bekijkArtiest();
        assertEquals(expResult, result);
    }

}
