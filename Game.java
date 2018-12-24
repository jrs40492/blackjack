import java.awt.Graphics;

public class Game {
  public Dealer dealer;
  public Player player;
  public boolean isOver;

  public void newGame(Deck deck) {
    this.dealer = new Dealer();
    this.player = new Player();
    this.isOver = false;

    deck.shuffle();

    this.player.hand.addCard(deck, true);
    this.dealer.hand.addCard(deck, true);

    this.player.hand.addCard(deck, true);
    this.dealer.hand.addCard(deck, false);
  }

  public String checkScores(Graphics pen) {
    int playerTotal = player.hand.total;
    int playerSoftTotal = player.hand.softTotal;

    int dealerTotal = dealer.hand.total;
    int dealerSoftTotal = dealer.hand.softTotal;

    // If player doesn't have ace, set soft total to 22 (always busts)
    if (!player.hand.hasAce) {
      playerSoftTotal = 22;
    } else if (playerTotal > 21) {
      playerTotal = playerSoftTotal;
    }

    // If dealer doesn't have ace, set soft total to 22 (always busts)
    if (!dealer.hand.hasAce) {
      dealerSoftTotal = 22;
    } else if (dealerTotal > 21) {
      dealerTotal = dealerSoftTotal;
    }

    if (playerTotal > 21) {
      return "You busted!!";
    }

    if (playerTotal == 21) {
      return "BlackJack!!";
    }

    if (dealerTotal == 21) {
      return "Dealer Blackjack!";
    }

    // Check if the game is over
    if (!this.isOver) {
      return null;
    }

    if (dealerTotal > 21) {
      return "Dealer Busts. You win!";
    }

    if (dealerTotal > playerTotal) {
      return "Dealer Wins!!";
    }

    if (playerTotal > dealerTotal) {
      return "You win!";
    }

    if (playerTotal == dealerTotal) {
      return "Tie!!";
    }

    return null;
  }
}
