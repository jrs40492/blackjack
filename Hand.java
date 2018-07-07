import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Hand {
  public ArrayList<Card> cards = new ArrayList<Card>();
  public int total = 0;
  private Card card;

  // Vars for drawing cards
  private static final int cardWidth = 150;
  private static final int cardHeight = 175;
  private int xStart = 10;
  private int yDealer = 20;
  private int yPlayer = 220;
  private int cardXSpacing = 165;

  public void addCard(Deck deck) {
    card = deck.nextCard();
    addTotal(card);
    cards.add(card);
  }

  public void addCard(Deck deck, Boolean visible) {
    card = deck.nextCard();
    card.visible = visible;

    if (visible) {
      addTotal(card);
    }

    cards.add(card);
  }

  public void addTotal(Card card) {
    this.total += card.value;
  }

  public void drawHand(String type, Graphics pen) {
    int offsetX = 0;
    int offsetY = 0;
    int index = 0;
    pen.setColor(Color.black);

    switch (type) {
    case "Dealer":
      offsetY = yDealer;
      String dealerText = "Dealer Total: " + this.total;
      pen.drawString(dealerText, 5, 15);
      break;

    case "Player":
      offsetX = (cardXSpacing * index) + xStart;
      offsetY = yPlayer;
      String playerText = "Player Total: " + this.total;
      pen.drawString(playerText, 5, 215);
      break;

    default:
      return;
    }

    for (Card card : cards) {
      offsetX = (cardXSpacing * index) + xStart;
      index++;

      pen.setColor(card.color);

      pen.drawRoundRect(offsetX, offsetY, cardWidth, cardHeight, 10, 10);

      // Check if card should show
      if (!card.visible) {
        return;
      }

      int cardCenterWidth = cardWidth / 2;
      int cardCenterHeight = cardHeight / 2;

      int rankOffsetX = (offsetX + cardCenterWidth) - 10;
      int rankOffsetY = (offsetY + cardCenterHeight) + 10;

      // Draw value
      pen.drawString(Integer.toString(card.value), rankOffsetX, rankOffsetY);

      int suitOffsetXLeft = offsetX + 10;
      int suitOffsetXRight = offsetX + 125;

      int suitOffsetYTop = offsetY + 20;
      int suitOffsetYBottom = offsetY + 170;

      // Draw suit on top side corners
      pen.drawString(card.display, suitOffsetXLeft, suitOffsetYTop);
      pen.drawString(card.display, suitOffsetXRight, suitOffsetYTop);

      // Draw suit on bottom side corners
      pen.drawString(card.display, suitOffsetXLeft, suitOffsetYBottom);
      pen.drawString(card.display, suitOffsetXRight, suitOffsetYBottom);
    }
  }
}