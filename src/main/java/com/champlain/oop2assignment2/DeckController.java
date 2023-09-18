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
        aDeck.sort();
        this.displayDeck();
    }

    @FXML
    protected void onShowButtonClick() {
        StringBuilder message = new StringBuilder();
        Iterator<Card> iterator = aDeck.iterator();
        int cardCount = 0;

        while (iterator.hasNext()) {
            Card card = iterator.next();
            
            message.append("Going through cards with confirmation messages (").append(++cardCount).append(" times): ")
                    .append(card).append("\n");
        }

        aDeckTextArea.setText(message.toString());
    }

    private void displayDeck () {
        this.aDeckTextArea.setText(this.aDeck.toString());
    }
}