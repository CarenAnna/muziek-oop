/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Muziek class
 * 
 * @author Caren
 */
public class Muziek {

    private static Muziek muziek = new Muziek();

    /**
     * Band, Solist, Nummer and Album objects are created here.
     */
    public Muziek() {
        ArrayList<String> nirvanaLeden = new ArrayList<>(Arrays.asList(
                "Kurt Cobain", "Krist Novoselic", "Chad Channing"));
        ArrayList<String> metallicaLeden = new ArrayList<>(Arrays.asList(
                "Lars Ulrich", "James Hetfield", "Kirk Hammett"));

        Band nirvana = new Band("Nirvana", "Grunge", nirvanaLeden);
        Band metallica = new Band("Metallica", "Metal", metallicaLeden);
        Solist maria = new Solist("Maria Mena", "Pop");
        Solist miley = new Solist("Miley Cyrus", "Pop");

        Nummer blew = new Nummer("Blew", 175);
        Nummer about = new Nummer("About a Girl", 168);
        Nummer dumb = new Nummer("Dumb", 192);
        Nummer apologies = new Nummer("All Apologies", 231);
        Nummer blackened = new Nummer("Blackened", 402);
        Nummer die = new Nummer("To Live Is To Die", 588);
        Nummer hold = new Nummer("Just Hold Me", 264);
        Nummer nevermind = new Nummer("Nevermind Me", 235);
        Nummer malibu = new Nummer("Malibu", 231);
        Nummer mood = new Nummer("Bad Mood", 179);

        ArrayList<Nummer> bleachNummers = new ArrayList<>();
        bleachNummers.add(about);
        bleachNummers.add(blew);

        ArrayList<Nummer> uteroNummers = new ArrayList<>();
        uteroNummers.add(apologies);
        uteroNummers.add(dumb);

        ArrayList<Nummer> justiceNummers = new ArrayList<>();
        justiceNummers.add(blackened);
        justiceNummers.add(die);

        ArrayList<Nummer> unaffectedNummers = new ArrayList<>();
        unaffectedNummers.add(hold);
        unaffectedNummers.add(nevermind);

        ArrayList<Nummer> youngerNummers = new ArrayList<>();
        youngerNummers.add(malibu);
        youngerNummers.add(mood);

        Album bleach = new Album("Bleach", 1989, bleachNummers);
        Album utero = new Album("In Utero", 1993, uteroNummers);
        Album justice = new Album("…And Justice for All", 1988, justiceNummers);
        Album unaffected = new Album("Apparently Unaffected", 2005,
                unaffectedNummers);
        Album younger = new Album("Younger Now", 2017, youngerNummers);

        nirvana.addAlbum(bleach);
        nirvana.addAlbum(utero);
        metallica.addAlbum(justice);
        maria.addAlbum(unaffected);
        miley.addAlbum(younger);
        
        artiesten.add(maria);
        artiesten.add(metallica);
        artiesten.add(miley);
        artiesten.add(nirvana);

        albums.add(unaffected);
        albums.add(justice);
        albums.add(younger);
        albums.add(bleach);
        albums.add(utero);
    }

    private ArrayList<Artiest> artiesten = new ArrayList<>();
    private ArrayList<Album> albums = new ArrayList<>();
    private int huidigeNummerIndex;
    private Playlist huidigePlaylist;
    private UserPlaylist userPlaylist;
    private Artiest huidigeArtiest;
    private ArrayList<UserPlaylist> userPlaylists = new ArrayList<>();

    /**
     * @return the HuidigeNummerTitel
     */
    public String getHuidigeNummerTitel() {
        String titel = this.huidigePlaylist.getAlbumNummers().get(
                this.huidigeNummerIndex).getTitel();
        return titel;
    }

    /**
     * @return the UserPlaylist
     */
    public UserPlaylist getUserPlaylist() {
        return userPlaylist;
    }

    /**
     * @param userPlaylist the userPlaylist to set
     */
    public void setUserPlaylist(UserPlaylist userPlaylist) {
        this.userPlaylist = userPlaylist;
    }

    /**
     * @return the huidigePlaylist
     */
    public Playlist getHuidigePlaylist() {
        return huidigePlaylist;
    }

    /**
     * @param huidigePlaylist the huidigePlaylist to set
     */
    public void setHuidigePlaylist(Playlist huidigePlaylist) {
        this.huidigePlaylist = huidigePlaylist;
    }

    /**
     * @return the userPlaylists
     */
    public ArrayList<UserPlaylist> getUserPlaylists() {
        return userPlaylists;
    }

    /**
     * @param userPlaylists the userPlaylists to set
     */
    public void setUserPlaylists(ArrayList<UserPlaylist> userPlaylists) {
        this.userPlaylists = userPlaylists;
    }

    /**
     * @return the albums
     */
    public ArrayList<Album> getAlbums() {
        return albums;
    }

    /**
     * @param albums the albums to set
     */
    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    /**
     * @return the artiesten
     */
    public ArrayList<Artiest> getArtiesten() {
        return artiesten;
    }

    /**
     * @param artiesten the artiesten to set
     */
    public void setArtiesten(ArrayList<Artiest> artiesten) {
        this.artiesten = artiesten;
    }

    /**
     * @return the huidigeArtiest
     */
    public Artiest getHuidigeArtiest() {
        return huidigeArtiest;
    }

    /**
     * @param huidigeArtiest the huidigeArtiest to set
     */
    public void setHuidigeArtiest(Artiest huidigeArtiest) {
        this.huidigeArtiest = huidigeArtiest;
    }

    /**
     * @return the muziek
     */
    public static Muziek getMuziek() {
        return muziek;
    }

    /**
     * @return the huidigeNummerIndex
     */
    public int getHuidigeNummerIndex() {
        return huidigeNummerIndex;
    }

    /**
     * @param huidigeNummerIndex the huidigeNummerIndex to set
     */
    public void setHuidigeNummerIndex(int huidigeNummerIndex) {
        this.huidigeNummerIndex = huidigeNummerIndex;
    }
}
