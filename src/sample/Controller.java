package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private VBox stack;
    @FXML
    private VBox heap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final VStack vStack = new VStack(stack);
    }
}
