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

    /**
     * Returns a string of the card, including rank and suit.
     *
     * @return A string of the card.
     */
    @Override
    public String toString() {
        return this.aRank + " of " + this.aSuit;
    }

    /**
     * Compares card to another card based on rank and suit.
     *
     * @param otherCard The card to compare to.
     * @return A negative integer if this card is less than the other card,
     *         a positive integer if this card is greater than the other card,
     *         and zero if they are equal.
     */
    @Override
    public int compareTo(Card otherCard) {
        // Compare cards based on rank and suit
        int rankComparison = this.aRank.compareTo(otherCard.getRank());
        if (rankComparison != 0) {
            return rankComparison;
        }

        return this.aSuit.compareTo(otherCard.getSuit());
    }
}
