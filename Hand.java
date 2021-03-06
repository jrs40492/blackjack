import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Hand {
  public ArrayList<Card> cards = new ArrayList<Card>();
  public int total = 0;
  public int softTotal = 0;
  public boolean hasAce = false;
  private Card card;

  public void addCard(Deck deck, Boolean visible) {
    card = deck.nextCard();
    card.visible = visible;

    if (visible) {
      addTotal(card);
    }

    cards.add(card);
  }

  public void addTotal(Card card) {
    if (card.rank == "A") {
      this.hasAce = true;
      this.softTotal++;
    } else {
      this.softTotal += card.value;
    }
    this.total += card.value;
  }

  public void drawHand(String type, Graphics pen) {
    final int cardWidth = 150;
    final int cardHeight = 175;
    final int cardXSpacing = 165;
    final int yDealer = 30;
    final int yPlayer = 210 + yDealer;
    final int xStart = 10;

    int offsetX = 0;
    int offsetY = 0;
    int index = 0;
    pen.setColor(Color.white);

    String scoreText = "Total: " + this.total;
    if (this.hasAce && this.total != 21) {
      scoreText += " OR " + this.softTotal;
    }

    switch (type) {
    case "Dealer":
      offsetY = yDealer;
      String dealerText = "Dealer " + scoreText;
      pen.drawString(dealerText, xStart, yDealer - 5);
      break;

    case "Player":
      offsetX = (cardXSpacing * index) + xStart;
      offsetY = yPlayer;
      String playerText = "Player " + scoreText;
      pen.drawString(playerText, xStart, yPlayer - 5);
      break;

    default:
      return;
    }

    for (Card card : cards) {
      offsetX = (cardXSpacing * index) + xStart;
      index++;

      pen.setColor(Color.WHITE);
      pen.fillRoundRect(offsetX, offsetY, cardWidth, cardHeight, 10, 10);

      pen.setColor(Color.black);
      pen.drawRoundRect(offsetX, offsetY, cardWidth, cardHeight, 10, 10);

      // Check if card should show
      if (!card.visible) {
        return;
      }

      pen.setColor(card.color);

      int cardCenterWidth = cardWidth / 2;
      int cardCenterHeight = cardHeight / 2;

      int rankOffsetX = (offsetX + cardCenterWidth) - 10;
      int rankOffsetY = (offsetY + cardCenterHeight) + 10;

      // Draw value
      pen.drawString(card.rank, rankOffsetX, rankOffsetY);

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
