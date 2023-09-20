package com.champlain.oop2assignment2;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Iterator;
import java.util.List;

/**
 * Represent a deck of playing card
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

    public void shuffle() {
        Collections.shuffle(this.aCards);
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

    /**
     * Return a String representation of the deck
     * @return String of deck for each card on separate line
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Card currentCard : this.aCards) {
            result.append(currentCard.toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * Return an iterator over the card in the deck
     * @return an Iterator over the card
     */
    @Override
    public Iterator<Card> iterator() {
        return aCards.iterator();
    }

    /**
     * Sort the card in the deck in order of ranks and suits
     */
    public void sort() {
        Collections.sort(aCards);
    }
}