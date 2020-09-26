package org.kenavo.finder.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.kenavo.finder.Main;
import org.kenavo.finder.models.Link;
import org.kenavo.finder.services.LinkService;
import org.kenavo.finder.utils.MessageDialog;
import org.kenavo.finder.utils.Navigation;

import java.util.List;
import java.util.function.Predicate;

public class EditLinkController {

    @FXML private TextField editId;
    @FXML private TextField editTitle;
    @FXML private TextField editLink;
    @FXML private TextArea editDescription;
    @FXML private TextField editKeyword;
    @FXML private ListView<String> editListViewKeywords;

    private ObservableList<String> keywords = FXCollections.observableArrayList();
    private LinkService linkService = new LinkService();

    public void setLink(Link link) {
        editId.setText(link.getId());
        editTitle.setText(link.getTitle());
        editLink.setText(link.getLink());
        editDescription.setText(link.getDescription());
        ObservableList<String> observableKeywords = FXCollections.observableArrayList();
        observableKeywords.addAll(link.getKeywords());
        editListViewKeywords.setItems(observableKeywords);
    }

    @FXML
    private void editLink(ActionEvent event){
        Link link = linkService.findById(editId.getText());
        List<Link> links = Main.links;

        link.setId(editId.getText());
        link.setTitle(editTitle.getText());
        link.setLink(editLink.getText());
        link.setDescription(editDescription.getText());
        link.setKeywords(editListViewKeywords.getItems());

        Predicate<Link> condition = removedLink -> (removedLink.getId() == link.getId());
        links.removeIf(condition);
        links.add(link);

        System.out.println(links);
        linkService.editLink(links);

        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelEditLink(ActionEvent event){
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addKeywords(){
        String keyword = editKeyword.getText();
        System.out.println(keyword);
        if(keyword.trim().isEmpty()){
            MessageDialog.alertMessage("Add Failed", "Please provide a key-word");
        }
        keywords.add(keyword);
        editListViewKeywords.setItems(keywords);
        editKeyword.clear();
    }

    @FXML
    private void deleteKeywords(){
        int selectedKeyword = editListViewKeywords.getSelectionModel().getSelectedIndex();
        String selectedKeywordValue = editListViewKeywords.getSelectionModel().getSelectedItem();
        if (selectedKeyword >= 0) {
            editListViewKeywords.getItems().remove(selectedKeyword);
            MessageDialog.infoMessage("Keyword deleted", "You have successfully deleted the keyword " + selectedKeywordValue);
        }
    }
}
