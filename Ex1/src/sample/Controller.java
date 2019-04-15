package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private Button incrementButton;

    @FXML
    private Label counterLabel;

    private int counter = 0;

    public void setCounterNumber(int value) {
        counterLabel.setText("counter = " + value);
    }

    public void countUp() {
        counter++;
        setCounterNumber(counter);
    }

    @FXML
    private void handleIncrementClick(MouseEvent event) {
        if (event.getButton() != MouseButton.PRIMARY) return;
        countUp();
    }
}
