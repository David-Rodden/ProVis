package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private VBox programBox;
    @FXML
    private Label programLabel;
    @FXML
    private VBox stackBox;
    @FXML
    private VBox heapBox;
    @FXML
    private Button stepButton;

    private VStack stack;
    private VHeap heap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final VProgram program = new VProgram(programLabel, programBox, stepButton, "test.txt");

        stack = new VStack(stackBox);
        heap = new VHeap(heapBox);
        stack.push("ref: abc_int");
        stack.push("ref: abc2_String");
        stack.pop();
        stack.push("ref: abc2_char");
        heap.alloc("one");
        heap.alloc("two");
        heap.alloc("three");
        heap.alloc("four");
        heap.alloc("five");
        heap.alloc("six");
    }
}
