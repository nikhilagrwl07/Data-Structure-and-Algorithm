

package deckOfCards;

public class Playing {

    public static void main(String[] args) {
        
       DeckOfCards cards = new DeckOfCards();
       cards.printDeckOfCards();
       cards.startShuffling();
       cards.printDeckOfCards();
    }

}
