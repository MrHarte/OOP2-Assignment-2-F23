package com.champlain.oop2assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck implements CardSource, Iterable<Card> {
    private final List<Card> aCards = new ArrayList<Card>();

    /**
     * Iterator override to iterate the Card ArrayList one by one.
     * @see Card Iterator is made up of List of Cards.
     * @return aCards as an iterator type
     */
    @Override
    public Iterator<Card> iterator(){
        return aCards.iterator();
    }

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

    /**
     * Sort method to call sort from Collections to sort cards in ascending order.
     */
    public void sort() {Collections.sort(this.aCards);}

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
}
