package com.champlain.oop2assignment2;

import java.util.Collections;
import java.util.Comparator;

public class Card implements Comparable<Card> {
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

    public int compareTo(Card pCard){
        int rankComparison = aRank.ordinal() - pCard.aRank.ordinal();

        if (rankComparison == 0) {

            return aSuit.ordinal() - pCard.aSuit.ordinal();
        } else {
            return rankComparison;
        }
    }
}
