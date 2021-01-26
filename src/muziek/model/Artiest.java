/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek.model;

import java.util.ArrayList;

/**
 * Artiest abstract class
 * 
 * @author Caren
 */
public abstract class Artiest {

    private String naam;
    private String genre;
    private ArrayList<Album> albums = new ArrayList<>();

    /**
     * Constructor of class Artiest.
     *
     * @param naam String: name of the Artiest.
     * @param genre String: genre of the Artiest.
     */
    public Artiest(String naam, String genre) {
        this.naam = naam;
        this.genre = genre;
    }

    /**
     * Abstract method bekijkArtiest() to be implemented in subclasses.
     *
     * @return String
     */
    public abstract String bekijkArtiest();

    public void addAlbum(Album album) {
        albums.add(album);
    }

    /**
     * Method to get an ArrayList of all nummers from an Artist, based on known
     * albums.
     *
     * @return the artiestNummers
     */
    public ArrayList<Nummer> getArtiestNummers() {
        ArrayList<Nummer> artiestNummers = new ArrayList<>();
        for (Album album : this.albums) {
            artiestNummers.addAll(album.getAlbumNummers());
        }
        return artiestNummers;
    }

    /**
     * @return the albums
     */
    public ArrayList<Album> getAlbums() {
        return albums;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

}
