package org.kenavo.finder.utils;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.kenavo.finder.loaders.EditLoader;
import org.kenavo.finder.models.Link;

public class AddColumn {

    public static Callback<TableColumn<Link, Void>, TableCell<Link, Void>> addDeleteButton(TableView<Link> table) {

        return new Callback<>() {
            @Override
            public TableCell call(final TableColumn<Link, Void> param) {
                return new TableCell<Link, String>() {

                    final Button btn = new Button("Delete");

                    {
                        btn.setOnAction(event -> table.getItems().remove(getIndex()));
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
                            EditLoader loader = new EditLoader();
                            Link link = table.getItems().get(getIndex());
                            loader.showPersonEditDialog(link);
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
