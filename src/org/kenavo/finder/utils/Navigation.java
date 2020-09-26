package org.kenavo.finder.utils;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    public void navigateToListProjects(Event event) throws IOException {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent listProjects = FXMLLoader.load(getClass().getResource("/resources/fxml/listLinks.fxml"));
        primaryStage.setScene(new Scene(listProjects));
        primaryStage.show();
    }

    public void navigateToCreateProject(Event event) throws IOException {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent createProject = FXMLLoader.load(getClass().getResource("/resources/fxml/createLinks.fxml"));
        primaryStage.setScene(new Scene(createProject));
        primaryStage.show();
    }
}
