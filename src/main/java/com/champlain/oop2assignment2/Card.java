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

    @Override
    public int compareTo(Card pCard){
        if(aSuit.ordinal() > pCard.aSuit.ordinal()){
            return 1;
        }
        else if(aSuit.ordinal() < pCard.aSuit.ordinal()){
            return -1;
        }
        else{
            if(aRank.ordinal() > pCard.aRank.ordinal()){
             return 1;
            }
            else if(aRank.ordinal() < pCard.aRank.ordinal()){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}
