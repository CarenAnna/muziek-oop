/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Playlist abstract class
 * 
 * @author Caren
 */
public abstract class Playlist {

    private String titel;
    private ArrayList<Nummer> albumNummers = new ArrayList<>();
    private int albumDuur;

    /**
     * Constructor of class Playlist.
     *
     * @param titel String: name of Playlist
     * @param albumNummers ArrayList of Nummer: all songs of the Playlist.
     */
    public Playlist(String titel, ArrayList<Nummer> albumNummers) {
        this.titel = titel;
        this.albumNummers = albumNummers;
        this.berekenDuur();
    }

    /**
     * Constructor of class Playlist, with only a title as input.
     *
     * @param titel String: name of Playlist
     */
    public Playlist(String titel) {
        this.titel = titel;
    }

    /**
     * Constructor of class Playlist, with only albumNummers as input.
     *
     * @param albumNummers ArrayList of Nummer: all songs of the Playlist.
     */
    public Playlist(ArrayList<Nummer> albumNummers) {
        this.albumNummers = albumNummers;
    }

    /**
     * Method to calculate album length. 
     * After calculation uses setAlbumDuur().
     */
    public void berekenDuur() {
        int duur = 0;
        for (Nummer nummer : albumNummers) {
            duur += nummer.getAfspeelDuur();
        }
        this.setAlbumDuur(duur);
    }

    /**
     * Method to shuffle a playlist. 
     * Uses an existing method: Collections.shuffle().
     */
    public void shuffle() {
        Collections.shuffle((List<Nummer>) this.albumNummers);
    }

    /**
     * @return the Titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * @param titel the Titel to set
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * @return the albumNummers
     */
    public ArrayList<Nummer> getAlbumNummers() {
        return albumNummers;
    }

    /**
     * @param albumNummers the albumNummers to set
     */
    public void setAlbumNummers(ArrayList<Nummer> albumNummers) {
        this.albumNummers = albumNummers;
        this.berekenDuur();
    }

    /**
     * @return the albumDuur
     */
    public int getAlbumDuur() {
        return albumDuur;
    }

    /**
     * @param albumDuur the albumDuur to set
     */
    public void setAlbumDuur(int albumDuur) {
        this.albumDuur = albumDuur;
    }
}
