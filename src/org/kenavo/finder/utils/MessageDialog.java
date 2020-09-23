package org.kenavo.finder.utils;

import javafx.scene.control.Alert;

public class MessageDialog {

    public static void alertMessage(String object, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(object);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void infoMessage(String object, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information");
        alert.setHeaderText(object);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
