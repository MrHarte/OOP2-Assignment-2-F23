package com.champlain.oop2assignment2;

public class Card implements Comparable<Card> {
    private final Suit aSuit;

    private final Rank aRank;

    public Card(Rank pRank, Suit pSuit) {
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
    public int compareTo(Card o) {
        if (this.aRank.compareTo(o.aRank) != 0) {
            return this.aRank.compareTo(o.aRank);
        } else if (this.aSuit.compareTo(o.aSuit) != 0) {
            return this.aSuit.compareTo(o.aSuit);
        }
        return 0;
    }
}
