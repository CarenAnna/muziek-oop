/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek.model;

import java.util.ArrayList;

/**
 * Band class, extends Artiest
 * 
 * @author Caren
 */
public class Band extends Artiest {

    private ArrayList<String> bandLeden;

    /**
     * Constructor of class Band.
     *
     * @param naam String: name of the Band.
     * @param genre String: genre of the Band.
     * @param bandLeden ArrayList of Strings: list of all members of the band.
     */
    public Band(String naam, String genre, ArrayList<String> bandLeden) {
        super(naam, genre);
        this.bandLeden = bandLeden;
    }

    /**
     * Implementation of abstract method of superclass. 
     * Method to get info on a Band.
     *
     * @return the info
     */
    @Override
    public String bekijkArtiest() {
        String info;
        ArrayList<Album> albums = this.getAlbums();
        ArrayList<String> albumTitels = new ArrayList<>();
        ArrayList<String> leden = this.getBandLeden();

        for (Album album : albums) {
            albumTitels.add(album.getTitel());
        }

        info = "Deze artiest is een band "
                + "en maakt muziek onder de naam " + this.getNaam() + ".\n"
                + "Het genre van deze artiest is " + this.getGenre() + ".\n"
                + "De band bestaat uit de volgende leden: "
                + String.join(", ", leden) + ".\n"
                + "De volgende albums zijn beschikbaar om af te spelen: "
                + String.join(", ", albumTitels);

        return info;
    }

    /**
     * @return the bandLeden
     */
    public ArrayList getBandLeden() {
        return bandLeden;
    }

}
