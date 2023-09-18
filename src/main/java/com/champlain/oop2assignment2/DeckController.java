package com.champlain.oop2assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

public class DeckController {
    @FXML
    private TextArea aDeckTextArea;

    private final Deck aDeck = new Deck();

    public void initialize() {
        this.displayDeck();
    }

    @FXML
    protected void onShuffleButtonClick() {
        this.aDeck.shuffle();
        this.displayDeck();
    }

    @FXML
    protected void onSortButtonClick() {
        aDeck.sort();
        this.displayDeck();
    }

    @FXML
    protected void onShowButtonClick() {
        for (Card card : aDeck) {
            String message = card.toString();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Confirmation");
            alert.setHeaderText("Confirmation");

            alert.setContentText(message);

            ButtonType result = alert.showAndWait().orElse(null);

            if (result == ButtonType.CANCEL) {
                break;
            }
        }

    }

    private void displayDeck () {
        this.aDeckTextArea.setText(this.aDeck.toString());

    }
}