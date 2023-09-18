package com.champlain.oop2assignment2;

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

    // added
    @Override
    public int compareTo(Card other) {
        // Compare cards based on rank and then suit
        int rankComparison = this.aRank.compareTo(other.aRank);
        if (rankComparison != 0) {
            return rankComparison;
        }
        return this.aSuit.compareTo(other.aSuit);
    }
}