package com.champlain.oop2assignment2;

import javax.swing.*;
import java.util.NoSuchElementException;

public class Card implements Comparable<Card>{
    private final Suit aSuit;

    private final Rank aRank;

    public Card (Rank pRank, Suit pSuit) {
        this.aRank = pRank;
        this.aSuit = pSuit;
    }

    public Rank getRank() {
        return this.aRank;
    }

    public Suit getSuit() {
        return this.aSuit;
    }

    @Override
    public String toString() {
        return this.aRank + " of " + this.aSuit;
    }

    /**
     * Override the compareTo method
     * @author Joshua and Zach
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Card o) {
        try {
            int compareSuit;
            compareSuit = this.aSuit.compareTo(o.getSuit());

            if (compareSuit == 0) {
                return this.aRank.compareTo(o.getRank());
            }
            return compareSuit;
        }
        catch (NullPointerException e){
            return 0;
        }
    }
}
