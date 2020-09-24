package org.kenavo.finder.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import org.kenavo.finder.utils.Navigation;

import java.io.IOException;

public class MainController {

    private Navigation navigation = new Navigation();

    @FXML
    public void navigateToCreateProject(MouseEvent event) throws IOException {
        navigation.navigateToCreateProject(event);
    }

    @FXML
    public void navigateToListProjects(MouseEvent event) throws IOException {
        navigation.navigateToListProjects(event);
    }
}
