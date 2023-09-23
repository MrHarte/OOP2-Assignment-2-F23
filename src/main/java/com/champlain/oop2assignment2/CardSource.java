package com.champlain.oop2assignment2;

import java.util.Iterator;

public interface CardSource {
    /**+
     * Returns a card from the source.
     *
     * @return The next available card.
     * @pre !isEmpty()
     */
    Card draw();

    /**
     *
     * @return True if there is no card in the source.
     */
    boolean isEmpty();

    Iterator<Card> iterator();
}
