package org.kenavo.finder.utils;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kenavo.finder.controllers.EditLinkController;
import org.kenavo.finder.models.Link;

import java.io.IOException;

public class Navigation {

    public void navigateToListLinks(Event event) throws IOException {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent listProjects = FXMLLoader.load(getClass().getResource("/resources/fxml/listLinks.fxml"));
        primaryStage.setScene(new Scene(listProjects));
        primaryStage.show();
    }

    public void navigateToCreateLink(Event event) throws IOException {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent createProject = FXMLLoader.load(getClass().getResource("/resources/fxml/createLinks.fxml"));
        primaryStage.setScene(new Scene(createProject));
        primaryStage.show();
    }

    public void navigateToEditLink(Event event, Link link) throws IOException {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/editLink.fxml"));
        // Load the fxml file and create a new stage for the popup dialog.
        Parent edit = loader.load();

        Scene editScene = new Scene(edit);
        primaryStage.setScene(editScene);

        EditLinkController controller = loader.getController();
        controller.setLink(link);

        primaryStage.show();
    }
}
