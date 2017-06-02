package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by David on 6/1/2017.
 */
public class VStack {
    private final VBox box;

    public VStack(final VBox box) {
        this.box = box;
    }

    public void push(final String text) {
        final Label label = new Label(text);
        label.setStyle("-fx-border-color: black; -fx-background-color: #c1e4ff");
        label.prefWidthProperty().bind(box.prefWidthProperty());
        box.getChildren().add(0, label);
    }

    public void pop() {
        final ObservableList<Node> children = box.getChildren();
        children.remove(0);
    }
}
