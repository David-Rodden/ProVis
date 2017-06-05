package memory;

import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.*;

/**
 * Created by David on 6/1/2017.
 */
public class VStack {
    private final VBox box;
    private final Path refPath;

    protected VStack(final VBox box, final Path refPath) {
        this.box = box;
        this.refPath = refPath;
    }

    protected void push(final String text, final Label heapLabel) {
        final Label label = new Label(text);
        label.setStyle("-fx-border-color: black; -fx-background-color: #c1e4ff");
        label.prefWidthProperty().bind(box.prefWidthProperty());
        label.hoverProperty().addListener((observed, oldVal, newVal) -> {
            refPath.getElements().clear();
            if (!newVal) return;
            final Bounds labelNode = label.localToScene(label.getBoundsInLocal());
            final Bounds heapNode = heapLabel.localToScene(heapLabel.getBoundsInLocal());
            final double labelNodeY = labelNode.getMinY() + label.getHeight() / 2;
            refPath.getElements().add(new MoveTo(labelNode.getMaxX() + 2, labelNodeY));
            refPath.getElements().add(new HLineTo(labelNode.getMaxX() + (heapNode.getMinX() - labelNode.getMaxX()) / 2));
            refPath.getElements().add(new VLineTo(labelNodeY + (heapNode.getMaxY() - labelNode.getMaxY())));
            refPath.getElements().add(new HLineTo(heapNode.getMinX() - 2));
        });
        box.getChildren().add(0, label);
    }

    protected void pop() {
        final ObservableList<Node> children = box.getChildren();
        children.remove(0);
    }
}
