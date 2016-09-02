/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package deckOfCards;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author nikhil.agrawal
 */
public class DeckOfCards {
    static final int numberOfCards = 52;
    
    public Cards[] deck;

    public DeckOfCards() {
        
        deck = new Cards[numberOfCards];
        
//        for(int i=0;i<numberOfCards;i++)
//        {
//            Cards c = new Cards();
//            
//        }
        int i=0;
        
        for(Suites s : Suites.values())
        {
            for(Rank r : Rank.values())
            {
                Cards cards = new Cards(s, r);
                deck[i]=cards;
              // System.out.println(deck[i].toString());
               i++;
            }
        }
       
    }
    
    public void printDeckOfCards()
    {
        
        for(int i=0;i<numberOfCards;i++)
        {
            Cards c=deck[i];
            System.out.println(c.toString());
            
        }
    }
    
     public void startShuffling()
    {
         System.out.println("***** Cards shuffled started****");
       Collections.shuffle(Arrays.asList(deck) );
         System.out.println("***** Cards shuffled completed****");
    }

}
