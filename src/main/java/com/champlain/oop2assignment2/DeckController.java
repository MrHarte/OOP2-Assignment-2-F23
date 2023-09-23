package com.champlain.oop2assignment2;

import javafx.fxml.FXML;
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
        this.aDeck.sort();
        this.displayDeck();
    }

    @FXML
    protected void onShowButtonClick() {
        Iterator<Card> iterator = aDeck.iterator();

        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    private void displayDeck () {
        this.aDeckTextArea.setText(this.aDeck.toString());
    }
}