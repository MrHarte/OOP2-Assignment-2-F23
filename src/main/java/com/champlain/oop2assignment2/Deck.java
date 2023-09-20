package com.champlain.oop2assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Represents a deck of playing cards.
 * This class implements the CardSource and Iterable interfaces.
 * @author Gonzalo Erian Barrera Gonzalez - Tyler Ouillet
 */
public class Deck implements CardSource, Iterable<Card> {

    /** The list of cards in the deck. */
    private final List<Card> aCards = new ArrayList<Card>();

    /**
     * Constructs a new deck by initializing it with all possible combinations of ranks and suits.
     */
    public Deck() {
        for (Rank currentRank : Rank.values()) {
            for (Suit currentSuit : Suit.values()) {
                this.aCards.add(new Card(currentRank, currentSuit));
            }
        }
    }

    /**
     * Shuffles the cards in the deck, randomizing their order.
     */
    public void shuffle() {
        Collections.shuffle(this.aCards);
    }

    /**
     * Sorts the cards in the deck by both rank and suit.
     */
    public void sort() {
        Collections.sort(this.aCards);
    }

    /**
     * Draws a card from the top of the deck.
     *
     * @return The drawn card.
     * @throws IllegalStateException if the deck is empty.
     */
    public Card draw() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        int last = this.aCards.size()-1;
        Card myCard = this.aCards.get(last);
        this.aCards.remove(last);
        return myCard;
    }

    /**
     * Checks if the deck is empty.
     *
     * @return true if the deck is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.aCards.isEmpty();
    }

    /**
     * Returns a string representation of the cards in the deck.
     *
     * @return A string containing the cards' information.
     */
    public String toString() {
        String result = "";
        for (Card currentCard : this.aCards) {
            result += currentCard.toString() + "\n";
        }
        return result;
    }

    /**
     * Returns an iterator for iterating over the cards in the deck.
     *
     * @return An iterator for the deck's cards.
     */
    @Override
    public Iterator<Card> iterator() {
        return aCards.iterator();
    }

    /**
     * An inner class representing an iterator for the deck's cards.
     */
    private class DeckIterator implements Iterator<Card> {
        private int currentIndex = 0;

        /**
         * Checks if there is a next card in the deck.
         *
         * @return true if there is a next card, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return currentIndex < aCards.size();
        }

        /**
         * Gets the next card from the deck.
         *
         * @return The next card.
         * @throws NoSuchElementException if there are no more cards to iterate.
         */
        @Override
        public Card next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return aCards.get(currentIndex++);
        }
    }
}
