/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek.model;

import java.util.ArrayList;

/**
 * Album class, extends Playlist
 * 
 * @author Caren
 */
public class Album extends Playlist {

    private int jaartal;

    /**
     * Constructor of class Album.
     *
     * @param albumTitel String: name of the Album.
     * @param jaartal int: year album was released.
     * @param albumNummers ArrayList of type Nummer: all nummers of Album.
     */
    public Album(String albumTitel, int jaartal, ArrayList<Nummer> albumNummers) {
        super(albumTitel, albumNummers);
        this.jaartal = jaartal;
    }

    /**
     * @return the jaartal
     */
    public int getJaartal() {
        return jaartal;
    }

}
