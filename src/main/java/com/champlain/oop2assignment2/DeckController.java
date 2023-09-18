package com.champlain.oop2assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;
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

    /**
     * Sort the deck by suit using the override method
     */
    @FXML
    protected void onSortButtonClick() {
        this.aDeck.sort();
        this.displayDeck();
    }

    /**
     * Method to show each card in the deck using the iterator method
     */
    @FXML
    protected void onShowButtonClick() {
        Iterator<Card> itr = aDeck.iterator();
        while (itr.hasNext()){
            JOptionPane.showMessageDialog(null, itr.next());
        }
    }

    private void displayDeck () {
        this.aDeckTextArea.setText(this.aDeck.toString());
    }
}