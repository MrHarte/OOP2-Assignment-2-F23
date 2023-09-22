package com.champlain.oop2assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    /**
     * This sort's the cards inside the deck
     * and then displays it to the user
     */
    @FXML
    protected void onSortButtonClick() {
        aDeckTextArea.setText("This does not sort anything yet.");
        // added code
        aDeck.sort();
        displayDeck();
    }

    /**
     * This method makes it so when you click show/confirm button,
     * A message box will pop up saying whether the deck is sorted in the way it wants or not.
     */
    @FXML
    protected void onShowButtonClick() {
        // Show confirmation alert for card
        for (Card card : this.aDeck) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION, "Confirmation " + card);
            errorAlert.showAndWait();
        }
    }

    private void displayDeck () {
        this.aDeckTextArea.setText(this.aDeck.toString());
    }
}