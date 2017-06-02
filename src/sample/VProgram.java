package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by David on 6/2/2017.
 */
public class VProgram {
    private final VBox box;

    public VProgram(final VBox box, final String path) {
        try {
            Files.readAllLines(Paths.get("src/input/" + path)).stream().filter(s -> !s.isEmpty()).collect(Collectors.toList()).forEach(l -> {
                final Label label = new Label(l);
                label.setStyle("-fx-border-color: black; -fx-background-color: #f2d6a9");
                label.prefWidthProperty().bind(box.prefWidthProperty());
                box.getChildren().add(label);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.box = box;
    }
}
