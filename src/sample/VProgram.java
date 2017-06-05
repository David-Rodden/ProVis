package sample;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import memory.Memory;
import parse.DeclParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by David on 6/2/2017.
 */
public class VProgram {
    private final DeclParser parser;
    private final VBox box;
    private Button next;
    private Label stepNotifier;
    private int focused;
    private String focusedStyle, unfocusedStyle;

    public VProgram(final Label programLabel, final VBox box, final VBox stack, final VBox heap, final Path refPath, final Button next, final Label stepNotifier, final String path) {
        focused = 0;
        parser = new DeclParser(new Memory(stack, heap, refPath));
        next.setOnMouseClicked(e -> step());
        this.next = next;
        this.stepNotifier = stepNotifier;
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
        compilationCheck();
        readInput();
    }

    private void compilationCheck() {
        for (final Node n : box.getChildren()) {
            final Label current = (Label) n;
            if (parser.checkLine(current.getText())) continue;
            current.setStyle("-fx-background-color: indianred; -fx-border-color: black");
            if (next.isDisabled()) continue;
            next.setDisable(true);
//            throw new Error("Compilation error - " + current.getText());
        }
    }

    public void step() {
        if (focused + 1 >= box.getChildren().size()) return;
        box.getChildren().get(focused++).setStyle(unfocusedStyle);
        readInput();
        box.getChildren().get(focused).setStyle(focusedStyle);
    }

    private void readInput() {

    }
}
