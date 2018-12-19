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

    player.hand.addCard(deck);
    dealer.hand.addCard(deck);

    player.hand.addCard(deck);
    dealer.hand.addCard(deck, false);
  }

  public String checkScores(Graphics pen) {
    if (player.hand.total > 21) {
      return "You busted!!";
    }

    if (player.hand.total == 21) {
      return "BlackJack!!";
    }

    if (!this.isOver) {
      return null;
    }

    if (dealer.hand.total > 21) {
      return "Dealer Busts";
    }

    if (dealer.hand.total == 21 || dealer.hand.total > player.hand.total) {
      return "Dealer Wins!!";
    }

    if (dealer.hand.total > 21 || player.hand.total > dealer.hand.total) {
      return "You win!!";
    }

    if (player.hand.total == dealer.hand.total) {
      return "Tie!!";
    }

    return null;
  }
}
