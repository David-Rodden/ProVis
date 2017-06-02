package sample;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Stack;

/**
 * Created by David on 6/1/2017.
 */
public class VStack extends Stack<Label> {
    private final VBox box;

    public VStack(final VBox box) {
        this.box = box;
    }

    public void push(final String label) {
        box.getChildren().add(new Label(label));
    }

    public void pull() {
        final ObservableList<Node> children = box.getChildren();
        children.remove(children.size() - 1);
    }
}
