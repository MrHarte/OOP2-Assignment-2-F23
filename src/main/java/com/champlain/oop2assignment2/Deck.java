package com.champlain.oop2assignment2;

import java.util.*;
import java.util.function.Consumer;

public class Deck implements CardSource, Iterable {
    private final List<Card> aCards = new ArrayList<Card>();
    private final int currentSize;

    public Deck() {
        for (Rank currentRank : Rank.values()) {
            for (Suit currentSuit : Suit.values()) {
                this.aCards.add(new Card(currentRank, currentSuit));
            }
        }
        this.currentSize = aCards.size();
    }

    public void shuffle() {
        Collections.shuffle(this.aCards);
    }

    public void sort() {
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
    public Iterator iterator() {
        Iterator it = new Iterator() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && aCards.get(currentIndex) != null;
            }
            @Override
            public Object next() {
                return aCards.get(currentIndex++);
            }
        };
        return it;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}
