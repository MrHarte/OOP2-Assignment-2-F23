package com.champlain.oop2assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.util.Iterator;

public class DeckController {
    @FXML
    private TextArea aDeckTextArea;

    private final Deck aDeck = new Deck();

    /**
     * Initializes and checks if deck exists.
     */
    public void initialize() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(aDeck.isEmpty()){
            alert.setContentText("No deck exists.");
            alert.show();
        }
        this.displayDeck();
    }

    @FXML
    protected void onShuffleButtonClick() {
        this.aDeck.shuffle();
        this.displayDeck();
    }

    /**
     * Sort cards in ascending order by Rank then Suit.
     */
    @FXML
    protected void onSortButtonClick() {
        this.aDeck.sort();
        this.displayDeck();
    }

    /**
     * Iterates each cards one by one in an alert window in order of the ArrayList.
     */
    @FXML
    protected void onShowButtonClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        for(Iterator<Card> iter = aDeck.iterator(); iter.hasNext(); ){
            Card card = iter.next();
            if(card != null){
                alert.setContentText(card.toString());
                alert.showAndWait();
            }
            else{
                alert.setContentText("No cards in deck.");
            }
        }
    }

    private void displayDeck () {
        this.aDeckTextArea.setText(this.aDeck.toString());
    }
}