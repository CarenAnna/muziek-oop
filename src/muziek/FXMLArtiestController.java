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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import muziek.model.Artiest;
import muziek.model.Muziek;

/**
 * FXML Controller class
 *
 * @author Caren
 */
public class FXMLArtiestController implements Initializable {

    private Muziek muziek = Muziek.getMuziek();

    @FXML
    private ListView<Artiest> artiestList;
    @FXML
    private Label artiestLabel;
    @FXML
    private Label artiestInfo;

    /**
     * Initializes the controller class.
     * Listview of the view is set here.
     * Override of setCellFactory() is used to be able to store objects in a listview.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        artiestList.setCellFactory(param -> new ListCell<Artiest>() {
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
        ObservableList<Artiest> artiesten = FXCollections.observableArrayList(
                muziek.getArtiesten());
        artiestList.setItems(artiesten);
    }

    /**
     * Method to show info about selected Artiest.
     * Calls bekijkArtiest() of the class Solist or Band, based on selected Artiest.
     */
    @FXML
    private void artiestSelectie(MouseEvent event) {
        Artiest gekozenArtiest = artiestList.getSelectionModel().
                getSelectedItem();
        artiestInfo.setText(gekozenArtiest.bekijkArtiest());
        artiestLabel.setText(gekozenArtiest.getNaam());
    }

    /**
     * Tries to load FXMLAfspelen.fxml, in order to switch view screens.
     * Catches and IOException if not possible.
     */
    @FXML
    private void openAfspelen(ActionEvent event) {
        try {
            Stage stage;
            stage = (Stage) ((Button) (event.getSource())).getScene().
                    getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "view/FXMLAfspelen.fxml"));

            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentRootController.class.getName()).log(
                    Level.SEVERE, "Caught an IOException", ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText(
                    "Het afspelen menu kan niet geladen worden, controleer het bestand.");
            alert.showAndWait();
        }
    }

    /**
     * Tries to load FXMLUserPlaylist.fxml, in order to switch view screens.
     * Catches and IOException if not possible.
     */
    @FXML
    private void openUser(ActionEvent event) {
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

}
