import java.awt.Color;

public class Card {
  public String suit;
  public String rank;
  public String display;
  public int value;
  public int softValue = 0;
  public boolean visible;
  public Color color;

  public Card(String suit, String rank) {
    this.suit = suit;
    this.rank = rank;
    this.visible = true;

    switch (suit) {
    case "Hearts":
      this.display = "\u2665";
      this.color = Color.red;
      break;

    case "Diamonds":
      this.display = "\u2666";
      this.color = Color.red;
      break;

    case "Clubs":
      this.display = "\u2663";
      this.color = Color.black;
      break;

    case "Spades":
      this.display = "\u2660";
      this.color = Color.black;
      break;

    default:
      break;
    }

    switch (rank) {
    case "A":
      this.value = 11;
      this.softValue = 1;
      break;

    case "2":
      this.value = 2;
      break;

    case "3":
      this.value = 3;
      break;

    case "4":
      this.value = 4;
      break;

    case "5":
      this.value = 5;
      break;

    case "6":
      this.value = 6;
      break;

    case "7":
      this.value = 7;
      break;

    case "8":
      this.value = 8;
      break;

    case "9":
      this.value = 9;
      break;

    case "10":
    case "J":
    case "Q":
    case "K":
      this.value = 10;
      break;
    default:
      break;
    }

  }
}
