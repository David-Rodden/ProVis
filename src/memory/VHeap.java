package memory;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by David on 6/2/2017.
 */
public class VHeap {
    protected static final int HEAP_SIZE = 100;
    private final VBox box;

    protected VHeap(final VBox box) {
        this.box = box;
        for (int i = 0; i < HEAP_SIZE; i++) {
            final Label emptyLabel = new Label();
            emptyLabel.setStyle("-fx-border-color: black; -fx-background-color: white");
            emptyLabel.prefWidthProperty().bind(box.prefWidthProperty());
            box.getChildren().add(emptyLabel);
        }
    }

    protected Label alloc(final String text) {
        final Label label = ((Label) box.getChildren().stream().filter(node -> ((Label) node).getText().equals("")).findAny().get());
        if (label == null) return null;
        label.setText(text);
        label.setStyle("-fx-border-color: black;-fx-background-color: #e3a8f4");
        return label;
    }
}
