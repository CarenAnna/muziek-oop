/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek.model;

/**
 * Nummer class
 * 
 * @author Caren
 */
public class Nummer {

    private String titel;
    private int afspeelDuur;

    /**
     * Constructor of class Nummer.
     *
     * @param titel String: title of Nummer.
     * @param duur int: length of Nummer in seconds.
     */
    public Nummer(String titel, int duur) {
        this.titel = titel;
        this.afspeelDuur = duur;
    }

    /**
     * @return the titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * @return the afspeelDuur
     */
    public int getAfspeelDuur() {
        return afspeelDuur;
    }

}
