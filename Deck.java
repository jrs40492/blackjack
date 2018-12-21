import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  public final static String[] suits = new String[] { "Hearts", "Diamonds", "Clubs", "Spades" };
  public final static String[] ranks = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q",
      "K" };
  public ArrayList<Card> cards = new ArrayList<Card>();
  private Card card;
  private int cardIndex = 0;

  public void build() {
    for (String suit : suits) {
      for (String rank : ranks) {
        Card card = new Card(suit, rank);
        this.cards.add(card);
      }
    }
  }

  public void shuffle() {
    // Shuffle cards
    Collections.shuffle(this.cards);

    // Reset place in deck
    cardIndex = 0;
  }

  public Card nextCard() {
    card = this.cards.get(cardIndex);

    // Increase place in deck
    cardIndex += 1;
    return card;
  }
}
