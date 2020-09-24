package org.kenavo.finder.utils;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;

public class OpenUrl extends Application {
    @Override
    public void start(Stage stage) {

    }

    public void openUrl(String url){
        HostServices hostServices = getHostServices();
        hostServices.showDocument(url);
    }
}
