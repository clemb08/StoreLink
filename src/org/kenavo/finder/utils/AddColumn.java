package org.kenavo.finder.utils;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.kenavo.finder.Main;
import org.kenavo.finder.models.Link;
import org.kenavo.finder.services.LinkService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddColumn {

    private static final Navigation nav = new Navigation();
    private static final LinkService linkService = new LinkService();

    public static Callback<TableColumn<Link, Void>, TableCell<Link, Void>> addDeleteButton(TableView<Link> table) {

        return new Callback<>() {
            @Override
            public TableCell call(final TableColumn<Link, Void> param) {
                return new TableCell<Link, String>() {

                    final Button btn = new Button("Delete");

                    {
                        btn.setOnAction(event -> {
                            List<Link> links = Main.links;
                            links.clear();
                            ObservableList<Link> observableLinks = table.getItems();
                            links = new ArrayList<>(observableLinks);
                            linkService.refreshLinks(links);
                        });
                    }

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                        setText(null);
                    }
                };
            }
        };
    }

    public static Callback<TableColumn<Link, Void>, TableCell<Link, Void>> addEditButton(TableView<Link> table) {

        return new Callback<>() {
            @Override
            public TableCell call(final TableColumn<Link, Void> param) {
                return new TableCell<Link, String>() {

                    final Button btn = new Button("Edit");

                    {
                        btn.setOnAction(event -> {
                            Link link = table.getItems().get(getIndex());
                            try {
                                nav.navigateToEditLink(event, link);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                        setText(null);
                    }
                };
            }
        };
    }

    public static void addLinkButton(TableColumn column) {
        column.setCellFactory(param -> new TableCell<Link, String>() {
            private final Button linkButton = new Button("Go To");

            @Override
            public void updateItem(String data, boolean empty) {
                super.updateItem(data, empty);

                if (data == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(linkButton);
                linkButton.setOnAction(event -> {
                    OpenUrl browser = new OpenUrl();
                    browser.openUrl(data);
                });

            }
        });
    }
}
