package org.kenavo.finder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kenavo.finder.models.Link;
import org.kenavo.finder.services.LinkService;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private static LinkService linkService = new LinkService();
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static final List<Link> links = linkService.findAllLinks();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/sample.fxml"));
        primaryStage.setTitle("Projects Management");
        primaryStage.setScene(new Scene(root, 900, 450));

        primaryStage.show();
    }


    public static void main(String[] args) {

        logger.setLevel(Level.FINE);

        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        logger.addHandler(consoleHandler);
        launch(args);
    }
}
