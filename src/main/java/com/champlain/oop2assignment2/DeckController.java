package com.champlain.oop2assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class DeckController {
    @FXML
    private TextArea aDeckTextArea;

    private final Deck aDeck = new Deck();

    public void initialize() {
        this.displayDeck();
    }

    /**
     * Event handler for the Shuffle button.
     * Shuffles the deck and updates the displayed deck.
     */
    @FXML
    protected void onShuffleButtonClick() {
        this.aDeck.shuffle();
        this.displayDeck();
    }

    /**
     * Event handler for the Sort button.
     * Sorts the deck and updates the displayed deck.
     */
    @FXML
    protected void onSortButtonClick() {
        aDeck.sort(); // Sort the deck
        displayDeck(); // Update the text area
    }


    /**
     * Event handler for the Show button.
     * Draws and displays the next card or shows a message if the deck is empty.
     */
    @FXML
    protected void onShowButtonClick() {
        if (!aDeck.isEmpty()) {
            Card nextCard = aDeck.draw(); // Draw the next card
            String confirmationMessage = nextCard.toString();

            // Show a confirmation dialog
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Card Drawn");
            alert.setHeaderText(null);
            alert.setContentText(confirmationMessage);
            alert.showAndWait();
        } else {
            aDeckTextArea.setText("Deck is empty.");
        }
    }

    private void displayDeck () {
        this.aDeckTextArea.setText(this.aDeck.toString());
    }

}