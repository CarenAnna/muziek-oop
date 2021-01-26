/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek.model;

import java.util.ArrayList;

/**
 * Solist class, extends Artiest
 * 
 * @author Caren
 */
public class Solist extends Artiest {

    /**
     * Constructor of class Solist.
     *
     * @param naam String: name of the Solist.
     * @param genre String: genre of the Solist.
     */
    public Solist(String naam, String genre) {
        super(naam, genre);
    }

    /**
     * Implementation of abstract method of superclass. 
     * Method to get info on a Solist.
     *
     * @return the info
     */
    @Override
    public String bekijkArtiest() {
        String info;
        ArrayList<Album> albums = this.getAlbums();
        ArrayList<String> albumTitels = new ArrayList<>();
        for (Album album : albums) {
            albumTitels.add(album.getTitel());
        }

        info = "De geselecteerde artiest is " + this.getNaam() + ".\n"
                + "Het genre van deze artiest is " + this.getGenre() + ".\n"
                + "De volgende albums zijn beschikbaar om af te spelen: "
                + String.join(",", albumTitels);
        return info;
    }

}
