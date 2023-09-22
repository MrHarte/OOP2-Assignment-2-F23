/**
 * This class holds all the suits and ranks of a card.
 * IT will also compare the cards
 */
package com.champlain.oop2assignment2;

/**
 * This holds all the values of a card, such as rank and suit and it also holds the equal/compare
 */
public class Card implements Comparable <Card> {

    private final Suit aSuit;

    private final Rank aRank;

    /**
     * A card has a rank and a suit.
     * This methods holds the values in a card such as Suit or Rank
     * @param pRank equals the Rank in rank class
     * @param pSuit equals Suit in the suit class
     */
    public Card (Rank pRank, Suit pSuit) {
        this.aRank = pRank;
        this.aSuit = pSuit;
    }

    /**
     * Getter method to get the aRank value
     * @return aRank to get the initiale value.
     */
    public Rank getRank() {
        return this.aRank;
    }

    /**
     * Getter method to get the aSuit value
     * @return aSuit to get the initiale value
     */
    public Suit getSuit() {
        return this.aSuit;
    }

    /**
     *  * Returns a string representation of the card.
     * @return a string value to represent the cards
     */
    @Override
    public String toString() {
        return this.aRank + " of " + this.aSuit;
    }

    /**
     * Checks to see if there is any card equal
     * @param obj obj The object to compare with this card.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Card)) return false;
        return this.aSuit == ((Card) obj).aSuit && this.aRank == ((Card) obj).getRank();
    }

    /**
     * Compares this card to another card based on their suits and ranks.
     * @param o The card to compare to.
     * @return 0 if the cards are equal, a positive value if this card is greater,
     *  a negative value if this card is smaller.
     */
    @Override
    public int compareTo(Card o) {
        if(this.equals(o)) {
            return 0;
        }
        if(this.aSuit.ordinal() > o.getSuit().ordinal()) {
            return 1;
        }
        else if(this.aSuit.ordinal() < o.getSuit().ordinal())
        {
            return -1;
        }
        if(this.aRank.ordinal() > o.getRank().ordinal()) {
            return 1;
        }
            return -1;

    }

}