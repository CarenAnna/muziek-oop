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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Caren
 */
public class FXMLDocumentRootController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * Tries to load FXMLAfspelen.fxml, in order to switch view screens.
     * Catches and IOException if not possible.
     */
    @FXML
    private void openAlbumSelectie(ActionEvent event) {
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
    private void openUserPlaylist(ActionEvent event) {
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
     * Tries to load FXMLArtiest.fxml, in order to switch view screens.
     * Catches and IOException if not possible.
     */
    @FXML
    private void openArtiest(ActionEvent event) {
        try {
            Stage stage;
            stage = (Stage) ((Button) (event.getSource())).getScene().
                    getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "view/FXMLArtiest.fxml"));

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
                    "Het artiest menu kan niet geladen worden, controleer het bestand.");
            alert.showAndWait();
        }
    }

}
