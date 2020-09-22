package org.kenavo.finder.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    public void navigateToCreateProject(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent createProject = FXMLLoader.load(getClass().getResource("/resources/fxml/createProject.fxml"));
        primaryStage.setScene(new Scene(createProject));
        primaryStage.show();
    }

    @FXML
    public void navigateToListProjects(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent listProjects = FXMLLoader.load(getClass().getResource("/resources/fxml/listProjects.fxml"));
        primaryStage.setScene(new Scene(listProjects));
        primaryStage.show();
    }
}
