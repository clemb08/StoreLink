package org.kenavo.finder.loaders;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kenavo.finder.controllers.EditLinkController;
import org.kenavo.finder.models.Link;

import java.io.IOException;

public class EditLoader {

    public void showPersonEditDialog(Link link) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/editLink.fxml"));
            // Load the fxml file and create a new stage for the popup dialog.
            Parent edit = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Link");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(edit);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            EditLinkController controller = loader.getController();
            controller.setLink(link);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
