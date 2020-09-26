package org.kenavo.finder.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import org.kenavo.finder.services.LinkService;
import org.kenavo.finder.utils.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Navigation navigation = new Navigation();
    private LinkService linkService = new LinkService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        linkService.findAllLinks();
    }

    @FXML
    public void navigateToCreateProject(MouseEvent event) throws IOException {
        navigation.navigateToCreateLink(event);
    }

    @FXML
    public void navigateToListProjects(MouseEvent event) throws IOException {
        navigation.navigateToListLinks(event);
    }
}
