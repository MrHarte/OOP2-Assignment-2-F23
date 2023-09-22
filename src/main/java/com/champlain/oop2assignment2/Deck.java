/**
 * This is the deck where it holds all the cards
 */
package com.champlain.oop2assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

/**
 * This holds all the cards in a deck, going from big value to small.
 */
public class Deck implements CardSource, Iterable<Card>{
    private final List<Card> aCards = new ArrayList<Card>();
    public Deck() {
        for (Rank currentRank : Rank.values()) {
            for (Suit currentSuit : Suit.values()) {
                this.aCards.add(new Card(currentRank, currentSuit));
            }
        }
    }
    /**
     * This shuffles all the cards inside the deck
     */
    public void shuffle() {
        Collections.shuffle(this.aCards);
    }
    /**
     *This draws a card from the deck. If there is no more cards,
     * It will give an error saying there's no more cards.
     */
    public Card draw() {
        if (isEmpty()) {
            throw new IllegalStateException("Deck is empty. Cannot draw a card.");
        }

        int last = this.aCards.size() - 1;
        Card myCard = this.aCards.get(last);
        this.aCards.remove(last);
        return myCard;
    }
    /**
     * This tells the user that the deck is empty
     */
    public boolean isEmpty() {
        return this.aCards.isEmpty();
    }

    /**
     * This returns a string value to represent the cards
     */
    public String toString() {
        String result = "";
        for (Card currentCard : this.aCards) {
            result += currentCard.toString() + "\n";
        }
        return result;
    }
    /**
     * This sorts the cards in the deck
     */
    public void sort()
    {
        Collections.sort(this.aCards);
    }


    /**
     * This makes it so that deck is iteratable
     */
    @Override
    public Iterator<Card> iterator() {
        return new DeckIterator();
    }

    /**
     * This goes through the iterated deck that holds the cards.
     * If it has next, it will increase the Current index value by one to check the next card
     * till there is no more cards remaining.
     */
    private class DeckIterator implements Iterator<Card> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < aCards.size();
        }

        @Override
        public Card next() {
            if (hasNext()) {
                return aCards.get(currentIndex++);
            } else {
                throw new IllegalStateException("No more cards in the deck");
            }
        }
    }
}
