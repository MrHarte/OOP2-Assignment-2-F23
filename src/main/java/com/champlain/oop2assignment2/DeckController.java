package com.champlain.oop2assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.util.Iterator;

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
        aDeckTextArea.setText("This does not sort anything yet.");
    }

    @FXML
    protected void onShowButtonClick() {

        for(Iterator<Card> iter = aDeck.iterator(); iter.hasNext(); ){
            Card card = iter.next();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText(card.toString());
            alert.showAndWait();
        }
    }

    private void displayDeck () {
        this.aDeckTextArea.setText(this.aDeck.toString());
    }
}