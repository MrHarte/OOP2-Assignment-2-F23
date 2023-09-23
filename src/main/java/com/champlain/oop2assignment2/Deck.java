package com.champlain.oop2assignment2;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck implements CardSource, Iterable<Card>{
    private final List<Card> aCards = new ArrayList<Card>();

    public Deck() {
        for (Rank currentRank : Rank.values()) {
            for (Suit currentSuit : Suit.values()) {
                this.aCards.add(new Card(currentRank, currentSuit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.aCards);
    }

    public void sort(){
        Collections.sort(this.aCards);
    }


    public Card draw() {
        int last = this.aCards.size()-1;
        Card myCard = this.aCards.get(last);
        this.aCards.remove(last);
        return myCard;
    }

    public boolean isEmpty() {
        return this.aCards.isEmpty();
    }

    public String toString() {
        String result = "";
        for (Card currentCard : this.aCards) {
            result += currentCard.toString() + "\n";
        }
        return result;
    }

    @Override
    public Iterator<Card> iterator() {
        return new DeckIterator();
    }

    private class DeckIterator implements Iterator<Card> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < aCards.size();
        }

        @Override
        public Card next() {
            Card nextCard = aCards.get(currentIndex);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(nextCard.toString());
            alert.showAndWait();

            currentIndex++;

            return nextCard;
        }
    }
}
