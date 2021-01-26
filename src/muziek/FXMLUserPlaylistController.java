/**
 * Caren Groenhuijzen
 * NOVI Hogeschool - Eindopdracht OOP
 * 30-03-2020
 */
package muziek;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import muziek.model.Album;
import muziek.model.Artiest;
import muziek.model.Muziek;
import muziek.model.Nummer;
import muziek.model.UserPlaylist;

/**
 * FXML Controller class
 *
 * @author Caren
 */
public class FXMLUserPlaylistController implements Initializable {

    private Muziek muziek = Muziek.getMuziek();

    @FXML
    private ListView<Artiest> artiestenList;
    @FXML
    private ListView<Nummer> nummerList;
    @FXML
    private ListView<Album> albumList;
    @FXML
    private ListView<Nummer> userPlayList;
    @FXML
    private TextField playListNaam;
    @FXML
    private TitledPane nummersAccordion;
    @FXML
    private TitledPane albumsAccordion;
    @FXML
    private Accordion uPAccordion;

    /**
     * Initializes the controller class.
     * Listviews of the view are set here.
     * Override of setCellFactory() is used to be able to store objects in a listview.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Artiest> artiesten = FXCollections.observableArrayList(
                muziek.getArtiesten());
        ObservableList<Album> albums = FXCollections.observableArrayList();
        ObservableList<Nummer> nummers = FXCollections.observableArrayList();

        artiestenList.setCellFactory(param -> new ListCell<Artiest>() {
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
        nummerList.setCellFactory(param -> new ListCell<Nummer>() {
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
        albumList.setCellFactory(param -> new ListCell<Album>() {
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
        userPlayList.setCellFactory(param -> new ListCell<Nummer>() {
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
        for (Artiest huidigeArtiest : muziek.getArtiesten()) {
            for (Album huidigeAlbum : huidigeArtiest.getAlbums()) {
                albums.add(huidigeAlbum);
                for (Nummer huidigeNummer : huidigeAlbum.getAlbumNummers()) {
                    nummers.add(huidigeNummer);
                }
            }
        }
        artiestenList.setItems(artiesten);
        albumList.setItems(albums);
        nummerList.setItems(nummers);
        muziek.setUserPlaylist(new UserPlaylist("unnamed"));

    }

    /**
     * Tries to load FXMLDocumentRoot.fxml, in order to switch view screens.
     * Catches and IOException if not possible.
     */
    @FXML
    private void userOpenMenu(ActionEvent event) {
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
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText(
                    "Hoofdmenu kan niet geladen worden, controleer het bestand.");
            alert.showAndWait();
        }
    }

    /**
     * First checks if created UserPlaylist is not empty.
     * Then checks if created UserPlaylist has a name.
     * If both are true, then:
     * Tries to load FXMLAfspelen.fxml, in order to switch view screens.
     * Catches and IOException if not possible.
     */
    @FXML
    private void userOpenAfspelen(ActionEvent event) {
        if (!muziek.getUserPlaylist().getAlbumNummers().isEmpty()) {
            if (!"".equals(playListNaam.getText())) {
                String naam = playListNaam.getText();
                muziek.getUserPlaylist().setTitel(naam);
                muziek.getUserPlaylists().add(muziek.getUserPlaylist());
                try {
                    Stage stage;
                    Parent root;
                    stage = (Stage) ((Button) (event.getSource())).getScene().
                            getWindow();

                    FXMLLoader loader = new FXMLLoader();
                    root = loader.load(getClass().getResource(
                            "view/FXMLAfspelen.fxml"));

                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentRootController.class.getName()).
                            log(Level.SEVERE, "Caught an IOException", ex);
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setContentText(
                            "Het afspelen menu kan niet geladen worden, controleer het bestand.");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setContentText(
                        "Je bent vergeten de playlist een naam te geven. "
                        + "Voer een naam in en probeer het opnieuw.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText(
                    "De Playlist is nog leeg. Voeg eerst een album of "
                    + " losse nummers toe, probeer het daarna opnieuw.");
            alert.showAndWait();
        }
    }

    /**
     * Method to add a song to a UserPlaylist.
     * Calls method toevoegen() of class UserPlaylist.
     */
    @FXML
    private void toevoegen(ActionEvent event) {
        ObservableList<Nummer> userNummers = FXCollections.observableArrayList();

        if (uPAccordion.getExpandedPane() == albumsAccordion
                && albumList.getSelectionModel().getSelectedItem() != null) {
            Album gekozenAlbum = albumList.getSelectionModel().getSelectedItem();
            muziek.getUserPlaylist().toevoegen(gekozenAlbum);
        } else if (uPAccordion.getExpandedPane() == nummersAccordion
                && nummerList.getSelectionModel().getSelectedItem() != null) {
            Nummer gekozenNummer = nummerList.getSelectionModel().
                    getSelectedItem();
            muziek.getUserPlaylist().toevoegen(gekozenNummer);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText(
                    "Selecteer een album of nummer voordat je op toevoegen klikt.");
            alert.showAndWait();
        }

        userNummers.addAll(muziek.getUserPlaylist().getAlbumNummers());
        userPlayList.setItems(userNummers);
    }

    /**
     * Method to delete a song to a UserPlaylist.
     * Calls method verwijderen() of class UserPlaylist.
     */
    @FXML
    private void verwijderen(ActionEvent event) {
        ObservableList<Nummer> userNummers = FXCollections.observableArrayList();

        if (userPlayList.getSelectionModel().getSelectedItem() != null) {
            Nummer gekozenNummer = userPlayList.getSelectionModel().
                    getSelectedItem();
            muziek.getUserPlaylist().verwijderen(gekozenNummer);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText(
                    "Selecteer een nummer uit de rechter lijst voordat je op verwijderen klikt");
            alert.showAndWait();
        }

        userNummers.addAll(muziek.getUserPlaylist().getAlbumNummers());
        userPlayList.setItems(userNummers);
    }

     /**
     * When an artist is clicked, corresponding Album and Nummer objects
     * are set in the right listviews. Used to filter based on Artiest.
     */
    @FXML
    private void artiestClick(MouseEvent event) {
        ObservableList<Album> albums = FXCollections.observableArrayList();
        ObservableList<Nummer> nummers = FXCollections.observableArrayList();
        Artiest gekozenArtiest = artiestenList.getSelectionModel().
                getSelectedItem();

        muziek.setHuidigeArtiest(gekozenArtiest);
        albums.addAll(gekozenArtiest.getAlbums());
        for (Album album : albums) {
            nummers.addAll(album.getAlbumNummers());
        }

        albumList.setItems(albums);
        nummerList.setItems(nummers);

        uPAccordion.setExpandedPane(albumsAccordion);
    }

    /**
     * When an album is clicked, corresponding Nummer objects
     * are set in the right listview. Used to filter based on Album.
     */
    @FXML
    private void albumClick(MouseEvent event) {
        Album gekozenAlbum = albumList.getSelectionModel().getSelectedItem();
        ObservableList<Nummer> nummers = FXCollections.observableArrayList();

        nummers.addAll(gekozenAlbum.getAlbumNummers());

        nummerList.setItems(nummers);
    }

}
