package org.kenavo.finder.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.kenavo.finder.models.Link;
import org.kenavo.finder.services.LinkService;

import java.util.Collections;

public class CreateProjectController {

    @FXML private TextField newTitle;
    @FXML private TextField newLink;
    @FXML private TextArea newDescription;
    @FXML private TextField newKeywords;

    public CreateProjectController() {
    }


    @FXML
    private void handleCreateProject(ActionEvent event){
        Link link = new Link();
        link.setId(newTitle.getText());
        link.setTitle(newTitle.getText());
        link.setLink(newLink.getText());
        link.setDescription(newDescription.getText());
        link.setKeywords(Collections.singletonList(newKeywords.getText()));

        LinkService linkService = new LinkService();

        linkService.createLink(link);
    }

}
