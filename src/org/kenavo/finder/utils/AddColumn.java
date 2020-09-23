package org.kenavo.finder.utils;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import org.kenavo.finder.models.Link;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AddColumn {

    public static void addButtonToTable(TableColumn<Link, Void> goToColumn, String url) {

        Callback<TableColumn<Link, Void>, TableCell<Link, Void>> cellFactory = new Callback<TableColumn<Link, Void>, TableCell<Link, Void>>() {
            @Override
            public TableCell<Link, Void> call(final TableColumn<Link, Void> param) {
                final TableCell<Link, Void> cell = new TableCell<Link, Void>() {

                    private final Button btn = new Button("Go To");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                                OpenUrl browser = new OpenUrl();
                                browser.openUrl(url);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        goToColumn.setCellFactory(cellFactory);

    }
}
