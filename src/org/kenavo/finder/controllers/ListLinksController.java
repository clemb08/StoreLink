package org.kenavo.finder.controllers;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.kenavo.finder.models.Link;
import org.kenavo.finder.services.LinkService;
import org.kenavo.finder.utils.AddColumn;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListLinksController implements Initializable {

    @FXML private TableView<Link> tableLinks;

    @FXML private TableColumn<Link, String> columnTitle;
    @FXML private TableColumn<Link, String> columnGoTo;
    @FXML private TableColumn<Link, String> columnDescription;
    @FXML private TableColumn<Link, Void> columnEdit;
    @FXML private TableColumn<Link, Void> columnDelete;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Link> links = getLinks();
        //Populating the TableView
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        //Add Button Go To Link
        columnGoTo.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLink()));
        AddColumn.addLinkButton(columnGoTo);
        //Add Button Delete
        columnDelete.setCellValueFactory(new PropertyValueFactory<>(""));
        Callback<TableColumn<Link, Void>, TableCell<Link, Void>> cellDelete
                = AddColumn.addDeleteButton(tableLinks);
        columnDelete.setCellFactory(cellDelete);
        //Add Button Edit
        columnEdit.setCellValueFactory(new PropertyValueFactory<>(""));
        Callback<TableColumn<Link, Void>, TableCell<Link, Void>> cellEdit
                = AddColumn.addEditButton(tableLinks);
        columnEdit.setCellFactory(cellEdit);

        tableLinks.setItems(links);
    }

    //Helper method converting links in ObservableList
    public ObservableList<Link> getLinks() {
        LinkService linkService = new LinkService();
        List<Link> foundLinks = linkService.findAllLinks();

        ObservableList<Link> observableLinks = FXCollections.observableArrayList();
        observableLinks.addAll(foundLinks);
        return observableLinks;
    }

}
