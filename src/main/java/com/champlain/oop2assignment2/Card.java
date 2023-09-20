package com.champlain.oop2assignment2;

/**
 * Represents a playing card with a rank and a suit.
 * This class implements the Comparable interface to allow card comparison.
 */
public class Card implements Comparable<Card>{

    /** The suit of the card. */
    private final Suit aSuit;

    /** The rank of the card. */
    private final Rank aRank;

    /**
     * Constructs a new Card with the specified rank and suit.
     *
     * @param pRank The rank of the card.
     * @param pSuit The suit of the card.
     * @throws IllegalArgumentException if either pRank or pSuit is null.
     */
    public Card (Rank pRank, Suit pSuit) {
        if(pRank == null || pSuit == null) {
            throw new IllegalArgumentException();
        }
        this.aRank = pRank;
        this.aSuit = pSuit;
    }

    /**
     * Gets the rank of the card.
     *
     * @return The rank of the card.
     */
    public Rank getRank() {
        return this.aRank;
    }

    /**
     * Gets the suit of the card.
     *
     * @return The suit of the card.
     */
    public Suit getSuit() {
        return this.aSuit;
    }

    /**
     * Returns a string representation of the card in the format "Rank of Suit."
     *
     * @return A string representing the card.
     */
    @Override
    public String toString() {
        return this.aRank + " of " + this.aSuit;
    }

    /**
     * Compares this card to another card based on their suits and ranks.
     *
     * @param pCard The card to compare to.
     * @return A negative integer, zero, or a positive integer if this card is less than, equal to, or greater than
     *         the specified card.
     * @throws IllegalArgumentException if pCard is null.
     */
    @Override
    public int compareTo(Card pCard) {
        if(pCard != null) {
            int suitComparison = this.aSuit.compareTo(pCard.aSuit);

            if (suitComparison != 0) {
                return suitComparison;
            }
            return this.aRank.compareTo(pCard.aRank);
        }
        throw new IllegalArgumentException("Cannot compare to a null card.");
    }
}
