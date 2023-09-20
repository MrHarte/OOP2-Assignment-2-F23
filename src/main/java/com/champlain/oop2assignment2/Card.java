package com.champlain.oop2assignment2;

/**
 * Represent the cards of the deck
 */
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
     * Compares the card to another card for sorting
     * @param other the card to be compared to.
     * @return -1,0,1 if the card is less then, equal to, or greater than the card compared.
     */
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