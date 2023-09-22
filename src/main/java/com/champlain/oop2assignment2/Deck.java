package com.champlain.oop2assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;

/**
 * Constructs a deck of cards by populating it with all possible card combinations.
 */
public class Deck implements CardSource, Comparable<Deck>, Iterable<Card> {
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

    public Card draw() {
        int last = this.aCards.size()-1;
        Card myCard = this.aCards.get(last);
        this.aCards.remove(last);
        return myCard;
    }

    /**
     * Sorts the cards in the deck.
     */
    public void sort() {
        Collections.sort(aCards);
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
    public int compareTo(Deck otherDeck) {
        // Compare decks based on the top card they would draw
        if (this.isEmpty() && otherDeck.isEmpty()) {
            return 0; // Both decks are empty and considered equal
        } else if (this.isEmpty()) {
            return -1; // This deck is empty, so it's considered less than the other
        } else if (otherDeck.isEmpty()) {
            return 1; // The other deck is empty, so it's considered less than this one
        } else {
            return this.draw().compareTo(otherDeck.draw());
        }
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
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return aCards.get(currentIndex++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported.");
        }

    }
}
