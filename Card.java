import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class Card {
  public String suit;
  public String rank;
  public String display;
  public int value;
  public boolean visible;
  public Color color;

  public Card(String suit, String rank) {
    this.suit = suit;
    this.rank = rank;
    this.visible = true;

    switch (suit) {
    case "Hearts":
      this.display = "H";
      this.color = Color.red;
      break;

    case "Diamonds":
      this.display = "D";
      this.color = Color.red;
      break;

    case "Clubs":
      this.display = "C";
      this.color = Color.black;
      break;

    case "Spades":
      this.display = "S";
      this.color = Color.black;
      break;

    default:
      break;
    }

    switch (rank) {
    case "A":
      this.value = 11;
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