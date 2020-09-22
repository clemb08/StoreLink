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

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListProjectsController implements Initializable {

    @FXML private TableView<Link> tableLinks;
    @FXML private TableColumn<Link, String> columnTitle;
    @FXML private TableColumn<Link, String> columnLink;
    @FXML private TableColumn<Link, String> columnDescription;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columnTitle.setCellValueFactory(new PropertyValueFactory<Link, String>("Title"));
        columnLink.setCellValueFactory(new PropertyValueFactory<Link, String>("Link"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<Link, String>("Description"));

        tableLinks.setItems(getLinks());
    }

    public ObservableList<Link> getLinks() {
        LinkService linkService = new LinkService();
        List<Link> foundLinks = linkService.findAllLinks();

        ObservableList<Link> links = FXCollections.observableArrayList();
        for(int i = 0; i < foundLinks.size(); i++) {
            links.add(foundLinks.get(i));
        }
        System.out.println(links);
        return links;
    }
}
