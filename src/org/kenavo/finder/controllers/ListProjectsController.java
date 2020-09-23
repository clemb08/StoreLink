package org.kenavo.finder.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.kenavo.finder.models.Link;
import org.kenavo.finder.services.LinkService;
import org.kenavo.finder.utils.AddColumn;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListProjectsController implements Initializable {

    @FXML private TableView<Link> tableLinks;
    @FXML private TableColumn<Link, String> columnTitle;
    @FXML private TableColumn<Link, Void> columnGoTo;
    @FXML private TableColumn<Link, String> columnDescription;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Populating the TableView
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        //TODO:Ajouter Colonnes Edit et Delete
        ObservableList<Link> links = getLinks();
        tableLinks.setItems(links);

        //Creation buttons "Go To"
        Link link = null;
        for(int i = 1; i < links.size(); i++)
            link = tableLinks.getItems().get(i);
            String address = link.getLink();
            AddColumn.addButtonToTable(columnGoTo, address);
    }

    //Helper method converting links in ObservableList
    public ObservableList<Link> getLinks() {
        LinkService linkService = new LinkService();
        List<Link> foundLinks = linkService.findAllLinks();

        ObservableList<Link> links = FXCollections.observableArrayList();
        for(int i = 0; i < foundLinks.size(); i++) {
            links.add(foundLinks.get(i));
        }
        return links;
    }

}
