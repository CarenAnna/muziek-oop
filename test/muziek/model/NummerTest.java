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
public class NummerTest {

    public NummerTest() {
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

    private Nummer instance = new Nummer("Test", 120);

    /**
     * Test of getTitel method, of class Nummer.
     */
    @Test
    public void testGetTitel() {
        System.out.println("getTitel");
        String expResult = "Test";
        String result = instance.getTitel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAfspeelDuur method, of class Nummer.
     */
    @Test
    public void testGetAfspeelDuur() {
        System.out.println("getAfspeelDuur");
        int expResult = 120;
        int result = instance.getAfspeelDuur();
        assertEquals(expResult, result);
    }

}
