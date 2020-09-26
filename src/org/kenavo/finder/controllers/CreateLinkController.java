package org.kenavo.finder.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.kenavo.finder.models.Link;
import org.kenavo.finder.services.LinkService;
import org.kenavo.finder.utils.MessageDialog;
import org.kenavo.finder.utils.Navigation;

import java.io.IOException;

public class CreateLinkController {

    @FXML private TextField newTitle;
    @FXML private TextField newLink;
    @FXML private TextArea newDescription;
    @FXML private TextField newKeyword;
    @FXML private ListView<String> listViewKeywords;

    private ObservableList<String> keywords = FXCollections.observableArrayList();

    private Navigation navigation = new Navigation();

    @FXML
    private void handleCreateProject(ActionEvent event){
        Link link = new Link();
        link.setId(newTitle.getText());
        link.setTitle(newTitle.getText());
        link.setLink(newLink.getText());
        link.setDescription(newDescription.getText());
        link.setKeywords(listViewKeywords.getItems());

        LinkService linkService = new LinkService();
        linkService.createLink(link);

        try {
            navigation.navigateToListProjects(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelProject(ActionEvent event){
        try {
            navigation.navigateToListProjects(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addKeywords(){
        String keyword = newKeyword.getText();
        System.out.println(keyword);
        if(keyword.trim().isEmpty()){
            MessageDialog.alertMessage("Add Failed", "Please provide a key-word");
        }
        keywords.add(keyword);
        listViewKeywords.setItems(keywords);
        newKeyword.clear();
    }

    @FXML
    private void deleteKeywords(){
        int selectedKeyword = listViewKeywords.getSelectionModel().getSelectedIndex();
        String selectedKeywordValue = listViewKeywords.getSelectionModel().getSelectedItem();
        if (selectedKeyword >= 0) {
            listViewKeywords.getItems().remove(selectedKeyword);
            MessageDialog.infoMessage("Keyword deleted", "You have successfully deleted the keyword " + selectedKeywordValue);
        }
    }
}
