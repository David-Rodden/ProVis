package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import memory.Memory;
import memory.VHeap;
import memory.VStack;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private VBox programBox;
    @FXML
    private Label programLabel;
    @FXML
    private VBox stackContainer;
    @FXML
    private Label stackLabel;
    @FXML
    private VBox stackBox;
    @FXML
    private VBox heapContainer;
    @FXML
    private Label heapLabel;
    @FXML
    private VBox heapBox;
    @FXML
    private Button stepButton;
    @FXML
    private Path refPath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new VProgram(programLabel, programBox, stackBox, heapBox, refPath, stepButton, "test.txt");
    }
}
