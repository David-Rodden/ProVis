package memory;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

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

    protected Label alloc(final String text, final int bytes) {
        final ObservableList<Node> cells = box.getChildren();
        for (int i = 0, adjacent = 0; i < cells.size(); i++) {
            if (adjacent == bytes) {
                final int startCell = i - adjacent;
                for (int j = startCell; j < i; j++)
                    ((Label) cells.get(j)).setText(text.substring((j - startCell) * text.length() / bytes, (j - startCell + 1) * text.length() / bytes));
                return (Label) cells.get(startCell);
            }
            final Label currentCell = (Label) cells.get(i);
            currentCell.setStyle("-fx-border-color: black;-fx-background-color: #e3a8f4");
            adjacent = currentCell == null || currentCell.getText().equals("") ? adjacent + 1 : 0;
        }
        return null;
    }
}
