/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import muziek.model.Artiest;
import muziek.model.Muziek;
import muziek.model.Album;
import muziek.model.Nummer;
import muziek.model.UserPlaylist;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;

/**
 * FXML Controller class
 *
 * @author Caren
 */
public class FXMLAfspelenController implements Initializable {
    
    private Muziek muziek = Muziek.getMuziek();

    @FXML
    private ListView<String> afspelenGenreList;
    @FXML
    private ListView<Artiest> afspelenArtiestenList;
    @FXML
    private ListView<Album> afspelenAlbumsList;
    @FXML
    private ListView<Nummer> afspelenNummersList;
    @FXML
    private ListView<UserPlaylist> afspelenUserList;
    @FXML
    private ListView<Nummer> afspelenHuidigeList;

    @FXML
    private Label afspelenDuratieLabel;
    @FXML
    private Label afspelenHuidigeLabel;
    @FXML
    private Label afspelenNummerLabel;
    @FXML
    private Label jaartalLabel;

    @FXML
    private Accordion afspelenAccordion;
    @FXML
    private TitledPane artiestenAccordion;
    @FXML
    private TitledPane albumsAccordion;
    @FXML
    private TitledPane nummersAccordion;

    /**
     * Initializes the controller class.
     * Listviews of the view are set here.
     * Override of setCellFactory() is used to be able to store objects in a listview.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableSet<String> genres = FXCollections.observableSet();
        ObservableList<Artiest> artiesten = FXCollections.observableArrayList(
                muziek.getArtiesten());
        ObservableList<Album> albums = FXCollections.observableArrayList();
        ObservableList<Nummer> nummers = FXCollections.observableArrayList();
        ObservableList<UserPlaylist> userLists = FXCollections.
                observableArrayList();

        for (Artiest huidigeArtiest : muziek.getArtiesten()) {
            genres.add(huidigeArtiest.getGenre());
        }

        afspelenArtiestenList.setCellFactory(param -> new ListCell<Artiest>() {
            @Override
            protected void updateItem(Artiest artiest, boolean empty) {
                super.updateItem(artiest, empty);

                if (empty || artiest == null || artiest.getNaam() == null) {
                    setText(null);
                } else {
                    setText(artiest.getNaam());
                }
            }
        });
        afspelenAlbumsList.setCellFactory(param -> new ListCell<Album>() {
            @Override
            protected void updateItem(Album album, boolean empty) {
                super.updateItem(album, empty);

                if (empty || album == null || album.getTitel() == null) {
                    setText(null);
                } else {
                    setText(album.getTitel());
                }
            }
        });
        afspelenNummersList.setCellFactory(param -> new ListCell<Nummer>() {
            @Override
            protected void updateItem(Nummer nummer, boolean empty) {
                super.updateItem(nummer, empty);

                if (empty || nummer == null || nummer.getTitel() == null) {
                    setText(null);
                } else {
                    setText(nummer.getTitel());
                }
            }
        });
        afspelenUserList.setCellFactory(param -> new ListCell<UserPlaylist>() {
            @Override
            protected void updateItem(UserPlaylist uPlaylist, boolean empty) {
                super.updateItem(uPlaylist, empty);

                if (empty || uPlaylist == null || uPlaylist.getTitel() == null) {
                    setText(null);
                } else {
                    setText(uPlaylist.getTitel());
                }
            }
        });
        afspelenHuidigeList.setCellFactory(param -> new ListCell<Nummer>() {
            @Override
            protected void updateItem(Nummer item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getTitel() == null) {
                    setText(null);
                } else {
                    setText(item.getTitel());
                }
            }
        });

        for (Artiest currentArtiest : muziek.getArtiesten()) {
            for (Album huidigeAlbum : currentArtiest.getAlbums()) {
                albums.add(huidigeAlbum);
                for (Nummer huidigeNummer : huidigeAlbum.getAlbumNummers()) {
                    nummers.add(huidigeNummer);
                }
            }
        }
        for (UserPlaylist userList : muziek.getUserPlaylists()) {
            userLists.add(userList);
        }
        afspelenGenreList.setItems(FXCollections.observableArrayList(genres));
        afspelenArtiestenList.setItems(artiesten);
        afspelenAlbumsList.setItems(albums);
        afspelenNummersList.setItems(nummers);
        afspelenUserList.setItems(userLists);
    }

    /**
     * Tries to load FXMLDocumentRoot.fxml, in order to switch view screens.
     * Catches and IOException if not possible.
     */
    @FXML
    private void afspelenOpenMenu(ActionEvent event) {
        try {
            Stage stage;
            Parent root;
            stage = (Stage) ((Button) (event.getSource())).getScene().
                    getWindow();

            FXMLLoader loader = new FXMLLoader();
            root = loader.load(getClass().getResource(
                    "view/FXMLDocumentRoot.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentRootController.class.getName()).log(
                    Level.SEVERE, "Caught an IOException", ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText(
                    "Het hoofdmenu kan niet geladen worden, controleer het bestand.");
            alert.showAndWait();
        }
    }

    /**
     * Tries to load FXMLUserPlaylist.fxml, in order to switch view screens.
     * Catches and IOException if not possible.
     */
    @FXML
    private void afspelenOpenUser(ActionEvent event) {
        try {
            Stage stage;
            Parent root;
            stage = (Stage) ((Button) (event.getSource())).getScene().
                    getWindow();

            FXMLLoader loader = new FXMLLoader();
            root = loader.load(getClass().getResource(
                    "view/FXMLUserPlaylist.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentRootController.class.getName()).log(
                    Level.SEVERE, "Caught an IOException", ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText(
                    "Het user playlist menu kan niet geladen worden, controleer het bestand.");
            alert.showAndWait();
        }
    }

    /**
     * When a genre is clicked, corresponding Artiest, Album and Nummer objects
     * are set in the right listviews. Used to filter based on genre.
     */
    @FXML
    private void genreClick(MouseEvent event) {
        String gekozenGenre = afspelenGenreList.getSelectionModel().
                getSelectedItem();
        ObservableList<Artiest> artiesten = FXCollections.observableArrayList();
        for (Artiest huidigeArtiest : muziek.getArtiesten()) {
            if (gekozenGenre == huidigeArtiest.getGenre()) {
                artiesten.add(huidigeArtiest);
            }
        }
        afspelenArtiestenList.setItems(artiesten);
        afspelenAccordion.setExpandedPane(artiestenAccordion);
    }

    /**
     * When an artist is clicked, corresponding Album and Nummer objects
     * are set in the right listviews. Used to filter based on Artiest.
     * Current Playlist is set to all songs of the Artiest.
     * Current playlist length in seconds is calculated.
     */
    @FXML
    private void artistClick(MouseEvent event) {
        ObservableList<Album> albums = FXCollections.observableArrayList();
        ObservableList<Nummer> nummers = FXCollections.observableArrayList();
        ArrayList<Nummer> artiestNummers = new ArrayList<>();
        Artiest gekozenArtiest = afspelenArtiestenList.getSelectionModel().
                getSelectedItem();

        muziek.setHuidigeArtiest(gekozenArtiest);
        albums.addAll(gekozenArtiest.getAlbums());
        for (Album album : albums) {
            nummers.addAll(album.getAlbumNummers());
            artiestNummers.addAll(album.getAlbumNummers());
        }

        UserPlaylist playlistArtiest = new UserPlaylist(artiestNummers);
        muziek.setHuidigePlaylist(playlistArtiest);
        playlistArtiest.berekenDuur();

        afspelenHuidigeList.setItems(nummers);
        afspelenAlbumsList.setItems(albums);
        afspelenNummersList.setItems(nummers);

        afspelenDuratieLabel.setText(Integer.toString(playlistArtiest.
                getAlbumDuur()) + " seconden");
        muziek.setHuidigeNummerIndex(0);
        afspelenNummerLabel.setText(muziek.getHuidigeNummerTitel());
        afspelenHuidigeLabel.setText(gekozenArtiest.getNaam());
        jaartalLabel.setText("");

        afspelenAccordion.setExpandedPane(albumsAccordion);
    }

    /**
     * When an album is clicked, corresponding Nummer objects
     * are set in the right listview. Used to filter based on Album.
     * Current Playlist is set to all songs of the Album.
     */
    @FXML
    private void albumClick(MouseEvent event) {
        Album gekozenAlbum = afspelenAlbumsList.getSelectionModel().
                getSelectedItem();
        ObservableList<Nummer> nummers = FXCollections.observableArrayList();

        nummers.addAll(gekozenAlbum.getAlbumNummers());
        muziek.setHuidigePlaylist(gekozenAlbum);

        afspelenNummersList.setItems(nummers);

        afspelenHuidigeLabel.setText(gekozenAlbum.getTitel());
        jaartalLabel.setText("Album jaartal: " + gekozenAlbum.getJaartal());
        afspelenHuidigeList.setItems(nummers);
        afspelenDuratieLabel.setText(Integer.toString(gekozenAlbum.
                getAlbumDuur()) + " seconden");
        muziek.setHuidigeNummerIndex(0);
        afspelenNummerLabel.setText(muziek.getHuidigeNummerTitel());

        afspelenAccordion.setExpandedPane(nummersAccordion);
    }

    /**
     * When a song is clicked, the current playlist is set to this song.
     */
    @FXML
    private void nummerClick(MouseEvent event) {
        ArrayList<Nummer> nummers = new ArrayList<>();
        ObservableList<Nummer> nummersList = FXCollections.observableArrayList();

        Nummer gekozenNummer = afspelenNummersList.getSelectionModel().
                getSelectedItem();
        nummers.add(gekozenNummer);
        nummersList.add(gekozenNummer);

        afspelenDuratieLabel.setText(Integer.toString(gekozenNummer.
                getAfspeelDuur()) + " seconden");
        afspelenHuidigeLabel.setText(gekozenNummer.getTitel());
        afspelenNummerLabel.setText(gekozenNummer.getTitel());
        jaartalLabel.setText("");

        muziek.setHuidigePlaylist(new UserPlaylist(nummers));
        afspelenHuidigeList.setItems(nummersList);
    }

    /**
     * When a UserPlaylist is clicked, 
     * the current Playlist is set to this UserPlaylist.
     */
    @FXML
    private void userClick(MouseEvent event) {
        ObservableList<Nummer> userNummers = FXCollections.observableArrayList();

        UserPlaylist user = afspelenUserList.getSelectionModel().
                getSelectedItem();
        userNummers.addAll(user.getAlbumNummers());

        muziek.setHuidigePlaylist(user);
        afspelenHuidigeList.setItems(userNummers);

        afspelenHuidigeLabel.setText(user.getTitel());
        user.berekenDuur();
        afspelenDuratieLabel.setText(
                Integer.toString(user.getAlbumDuur()) + " seconden");
        muziek.setHuidigeNummerIndex(0);
        afspelenNummerLabel.setText(muziek.getHuidigeNummerTitel());
        jaartalLabel.setText("");
    }

    /**
     * Method to shuffle the songs of the current Playlist.
     * Calls shuffle() of the class Playlist.
     * If there is no current Playlist: catch an exception.
     */
    @FXML
    private void shuffle(ActionEvent event) {
        try {
            muziek.getHuidigePlaylist().shuffle();
            ObservableList<Nummer> nummers = FXCollections.observableArrayList();
            nummers.addAll(muziek.getHuidigePlaylist().getAlbumNummers());
            afspelenHuidigeList.setItems(nummers);
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText(
                    "Kies eerst een playlist of album om af te spelen.");
            alert.showAndWait();
        }
    }

    /**
     * Method to play the previous song in the current Playlist.
     * Uses huidigeNummerIndex of class Muziek to select the song.
     * If there is no current Playlist: catch an exception.
     */
    @FXML
    private void vorige(ActionEvent event) {
        try {
            int index = muziek.getHuidigeNummerIndex();
            muziek.setHuidigeNummerIndex(Math.max(index - 1, 0));
            afspelenNummerLabel.setText(muziek.getHuidigeNummerTitel());
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText(
                    "Kies eerst een playlist of album om af te spelen.");
            alert.showAndWait();
        }
    }

    /**
     * Method to play the next song in the current Playlist.
     * Uses huidigeNummerIndex of class Muziek to select the song.
     * If there is no current Playlist: catch an exception.
     */
    @FXML
    private void volgende(ActionEvent event) {
        try {
            int index = muziek.getHuidigeNummerIndex();
            muziek.setHuidigeNummerIndex(Math.min(index + 1, muziek.
                    getHuidigePlaylist().getAlbumNummers().size() - 1));
            afspelenNummerLabel.setText(muziek.getHuidigeNummerTitel());
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText(
                    "Kies eerst een playlist of album om af te spelen.");
            alert.showAndWait();
        }
    }

}
