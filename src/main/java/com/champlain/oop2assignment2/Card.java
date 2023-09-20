package com.champlain.oop2assignment2;

public class Card implements Comparable<Card>{
    private final Suit aSuit;

    private final Rank aRank;

    public Card (Rank pRank, Suit pSuit) {
        if(pRank == null || pSuit == null) {
            throw new IllegalArgumentException();
        }
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

    @Override
    public int compareTo(Card pCard) {
        if(pCard != null) {
            int suitComparison = this.aSuit.compareTo(pCard.aSuit);

            if (suitComparison != 0) {
                return suitComparison;
            }
            return this.aRank.compareTo(pCard.aRank);
        }
        throw new IllegalArgumentException();
    }
}
