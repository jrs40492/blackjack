public class Dealer {
  Hand hand = new Hand();

  public void showHand(Deck deck) {
    // Set dealers second card to visible
    hand.cards.get(1).visible = true;

    // Add second card to total
    hand.addTotal(hand.cards.get(1));

    // Dealer has to draw while 16 and under
    while (hand.total <= 16) {
      hand.addCard(deck);
    }

    return;
  }
}