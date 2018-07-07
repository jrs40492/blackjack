
/** Jacob Swanson
 *  5/13/12
 *  BlackJack program
 */
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.awt.Color;

import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BlackJack extends JPanel {
	private static final long serialVersionUID = 1;
	Game game = new Game();
	Card card;

	private JButton hit, stay, newGame;

	public BlackJack() {
		game.newGame();

		ButtonListener listener = new ButtonListener();
		hit = new JButton("Hit");
		hit.setActionCommand("hit");
		hit.addActionListener(listener);
		add(hit);

		stay = new JButton("Stay");
		stay.setActionCommand("stay");
		stay.addActionListener(listener);
		add(stay);

		newGame = new JButton("New Game");
		newGame.setActionCommand("newGame");
		newGame.addActionListener(listener);
		add(newGame);
	}

	public void paintComponent(Graphics pen) {
		super.paintComponents(pen);

		pen.setFont(new Font("Arial", Font.BOLD, 20));

		game.dealer.hand.drawHand("Dealer", pen);

		game.player.hand.drawHand("Player", pen);

		String message = game.checkScores(pen);

		if (message != null) {
			game.player.setAllowHit(false);
			game.player.setAllowStay(false);
			
			pen.setColor(Color.black);
			pen.drawString(message, 300, 215);
		}

		hit.setVisible(game.player.allowHit());
		stay.setVisible(game.player.allowStay());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent buttonClick) {
			String Click = buttonClick.getActionCommand();

			if (Click.equals("hit")) {
				game.player.hand.addCard(game.deck);
			} else if (Click.equals("stay")) {
				game.dealer.showHand(game.deck);
				game.isOver = true;
			} else if (Click.equals("newGame")) {
				game.newGame();
			}
			
			repaint();
		}
	}
}