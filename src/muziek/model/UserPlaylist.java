/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek.model;

import java.util.ArrayList;

/**
 * Userplaylist class, extends Playlist
 * 
 * @author Caren
 */
public class UserPlaylist extends Playlist {

    /**
     * Constructor of class UserPlaylist.
     *
     * @param titel String: name of Playlist
     */
    public UserPlaylist(String titel) {
        super(titel);
    }

    /**
     * Constructor of class UserPlaylist.
     *
     * @param albumNummers ArrayList of Nummer: all songs of the Playlist.
     */
    public UserPlaylist(ArrayList<Nummer> albumNummers) {
        super(albumNummers);
    }

    /**
     * Method to add all songs of an album to a Playlist.
     *
     * @param album the Album you want to add.
     */
    public void toevoegen(Album album) {
        this.getAlbumNummers().addAll(album.getAlbumNummers());
    }

    /**
     * Method to add a song to a Playlist.
     *
     * @param nummer the Nummer you want to add.
     */
    public void toevoegen(Nummer nummer) {
        this.getAlbumNummers().add(nummer);
    }

    /**
     * Method to delete a song from a Playlist.
     *
     * @param nummer you want to delete.
     */
    public void verwijderen(Nummer nummer) {
        this.getAlbumNummers().remove(nummer);
    }

}
