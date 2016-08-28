/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package deckOfCards;

/**
 *
 * @author nikhil.agrawal
 */
public class Cards {
    
    private Suites suites;
    private Rank rank;

    public Cards(Suites suites, Rank rank) {
        this.suites = suites;
        this.rank = rank;
    }

    @Override
    public String toString() {
       return suites.name() + " "+ rank.name();
    }
    
    
    
}
