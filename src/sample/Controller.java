package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    private Label stepNotifier;
    @FXML
    private Path refPath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new VProgram(programLabel, programBox, stackBox, heapBox, refPath, stepButton, stepNotifier, "test.txt");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(Integer.toString(3472).split("")));
    }
}
