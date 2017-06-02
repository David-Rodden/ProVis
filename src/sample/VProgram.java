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
    private int focused;
    private String focusedStyle, unfocusedStyle;

    public VProgram(final Label programLabel, final VBox box, final String path) {
        focused = 0;
        focusedStyle = "-fx-border-color: red; -fx-background-color: #f2d6a9";
        unfocusedStyle = "-fx-border-color: black; -fx-background-color: #f2d6a9";
        programLabel.setText(String.format("%s - %s", programLabel.getText(), path));
        try {
            Files.readAllLines(Paths.get("src/input/" + path)).stream().filter(s -> !s.isEmpty()).collect(Collectors.toList()).forEach(l -> {
                final Label label = new Label(l);
                label.setStyle(box.getChildren().size() == 0 ? focusedStyle : unfocusedStyle);
                label.prefWidthProperty().bind(box.prefWidthProperty());
                box.getChildren().add(label);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.box = box;
    }

    public void step() {
        if (focused + 1 >= box.getChildren().size()) return;
        box.getChildren().get(focused++).setStyle(unfocusedStyle);
        box.getChildren().get(focused).setStyle(focusedStyle);
    }
}
