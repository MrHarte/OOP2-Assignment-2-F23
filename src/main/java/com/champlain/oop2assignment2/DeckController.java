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
     * Handles the "Sort" button click event by displaying card information in correct order.
     */
    @FXML
    protected void onSortButtonClick() {
        //aDeckTextArea.setText("This does not sort anything yet.");
        this.aDeck.sort();
        this.displayDeck();
    }

    /**
     * Handles the "Show" button click event by displaying card information in a confirmation dialog.
     */
    @FXML
    protected void onShowButtonClick() {
        //aDeckTextArea.setText("This does not step through anything yet.");
        for (Card card : aDeck) {
            showAlert("Confirmation", "Card Information", card.toString());
        }
    }

    /**
     * Displays a confirmation alert dialog with the specified title, header, and content.
     *
     * @param title   The title of the alert dialog.
     * @param header  The header text of the alert dialog.
     * @param content The content text of the alert dialog.
     */
    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void displayDeck () {
        this.aDeckTextArea.setText(this.aDeck.toString());
    }
}