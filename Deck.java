import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
  public final static String[] suits = new String[] { "Hearts", "Diamonds", "Clubs", "Spades" };
  public final static String[] ranks = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q",
      "K" };
  public ArrayList<Card> cards = new ArrayList<Card>();
  private Card card;
  private int cardIndex = 0;

  public void buildDeck() {
    for (String suit : suits) {
      for (String rank : ranks) {
        Card card = new Card(suit, rank);
        this.cards.add(card);
      }
    }

    // Shuffle cards
    Collections.shuffle(this.cards);
  }

  public Card nextCard() {
    card = this.cards.get(cardIndex);
    cardIndex += 1;
    return card;
  }
}