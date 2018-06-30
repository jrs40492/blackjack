/** Jacob Swanson
 *  5/13/12
 *  BlackJack program
 */
import java.awt.Font;//import needed utilities
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BlackJack extends JPanel//start class
{
	List<String> deck = Arrays.asList("HA","H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ","HQ","HK",
			"DA","D2","D3","D4","D5","D6","D7","D8","D9","D10","DJ","DQ","DK",
			"SA","S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ","SQ","SK",
			"CA","C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ","CQ","CK");
	public final static String[] drawn = new String[52];
	public final static String[] text = new String[52];
	public final static int[] value = new int[52];
	private JButton Hit, Stay, Hit2, Hit3;//create JButtons
	public boolean drawHit = false, drawHit2 = false, drawHit3 = false, drawDealer = false;//create booleans
	String tSuit;//create String tSuit
	int c = 0, P1, D, suit, num;//create ints
	Random card = new Random();//create random generator
	
	public BlackJack()//start method
	{
	Collections.shuffle(deck);//rearrange the cards
	for (int c = 0; c < 52; c++)//for each card
	{
	if (deck.get(c).contains("H"))//check what it contains
	{
		tSuit = "Hearts"; //set tSuit equal to the suit
	} else if (deck.get(c).contains("D"))
	{
		tSuit = "Diamonds";
	} else if (deck.get(c).contains("C"))
	{
		tSuit = "Clubs";
	} else if (deck.get(c).contains("S"))
	{
		tSuit = "Spaids";
	} else { tSuit = "Error"; }//else say theres an error
	text[c] = tSuit;
	}
	
	for (int s = 0; s < drawn.length; s++)//for s is less than drawn length
	{
	if (deck.get(s).contains("A"))//if deck index contains this
		value[s] = 11;//set the value equal to this
	else if (deck.get(s).contains("2"))
		value[s] = 2;
	else if (deck.get(s).contains("3"))
		value[s] = 3;
	else if (deck.get(s).contains("4"))
		value[s] = 4;
	else if (deck.get(s).contains("5"))
		value[s] = 5;
	else if (deck.get(s).contains("6"))
		value[s] = 6;
	else if (deck.get(s).contains("7"))
		value[s] = 7;
	else if (deck.get(s).contains("8"))
		value[s] = 8;
	else if (deck.get(s).contains("9"))
		value[s] = 9;
	else if (deck.get(s).contains("10"))
		value[s] = 10;
	else if (deck.get(s).contains("J"))
		value[s] = 10;
	else if (deck.get(s).contains("Q"))
		value[s] = 10;
	else if (deck.get(s).contains("K"))
		value[s] = 10;
	}
		ButtonListener listener = new ButtonListener();//create a buttonlistener called listener
		Hit = new JButton("Hit");//create JButton labeled Hit
		Hit.setActionCommand("Hit");//set command to Hit
		Hit.addActionListener(listener);//add listener to button
		Stay = new JButton("Stay");//create Jbutton Stay
		Stay.setActionCommand("Stay");//set command to Stay
		Stay.addActionListener(listener);//add listener to button
		add(Stay);//add Stay and Hit to panel
		add(Hit);
	}
	public void paintComponent(Graphics pen)//start paint component
	{
		super.paintComponents(pen);
		
		pen.drawString("Dealer:", 5, 15);//draw these strings
		pen.drawString("Player1:", 10, 212);
		
		pen.setFont(new Font("Arial", Font.BOLD, 20));//change font size
		
		pen.drawRoundRect(10, 20, 150, 175, 10, 10);//draw initial cards
		pen.drawRoundRect(175, 20, 150, 175, 10, 10);
		pen.drawRoundRect(10, 220, 150, 175, 10, 10);
		pen.drawRoundRect(175, 220, 150, 175, 10, 10);
		
		pen.drawString(text[0], 50, 110);//draw card 0
		pen.drawString(deck.get(0).substring(1), 20, 40);
		pen.drawString(deck.get(0).substring(1), 135, 40);
		pen.drawString(deck.get(0).substring(1), 20, 190);
		pen.drawString(deck.get(0).substring(1), 135, 190);
		//skip card for dealers second card
		
		pen.drawString(text[2], 50, 320);//draw card 2
		pen.drawString(deck.get(2).substring(1), 20, 240);
		pen.drawString(deck.get(2).substring(1), 135, 240);
		pen.drawString(deck.get(2).substring(1), 20, 390);
		pen.drawString(deck.get(2).substring(1), 135, 390);
		
		pen.drawString(text[3], 220, 320);//draw card 3
		pen.drawString(deck.get(3).substring(1), 180, 240);
		pen.drawString(deck.get(3).substring(1), 305, 240);
		pen.drawString(deck.get(3).substring(1), 180, 390);
		pen.drawString(deck.get(3).substring(1), 305, 390);
		
		pen.drawString("Dealer Total:", 60, 17);//show dealers total
		D = value[0];
		pen.drawString(D + "", 200, 17);
		
		P1 = value[2] + value[3];//calculate players total
		if (P1 == 21)
		{
			pen.drawString("BlackJack!!", 300, 215);//check for blackjack
			Hit.setVisible(false);
			Stay.setVisible(false);
		}
		pen.drawString("Player Total:", 60, 215);//show players total
		pen.drawString(P1 + "", 200, 215);
		
		if (drawHit)//if hit button is clicked
		{
			pen.drawRoundRect(340, 220, 150, 175, 10, 10);//draw and show card 4
			pen.drawString(text[4], 390, 320);
			pen.drawString(deck.get(4).substring(1), 350, 240);
			pen.drawString(deck.get(4).substring(1), 470, 240);
			pen.drawString(deck.get(4).substring(1), 350, 390);
			pen.drawString(deck.get(4).substring(1), 470, 390);
			P1 = P1 + value[4];//show new total
			pen.drawString(P1 + "", 240, 215);
		}
		if (drawHit2)//if hit again
		{
			pen.drawRoundRect(500, 220, 150, 175, 10, 10);//draw and show card 5
			pen.drawString(text[5], 550, 320);
			pen.drawString(deck.get(5).substring(1), 510, 240);
			pen.drawString(deck.get(5).substring(1), 630, 240);
			pen.drawString(deck.get(5).substring(1), 510, 390);
			pen.drawString(deck.get(5).substring(1), 630, 390);
			P1 = P1 + value[5];//show new total
			pen.drawString(P1 + "", 280, 215);
		}
		if (drawHit3)//if hit again
		{
			pen.drawRoundRect(660, 220, 150, 175, 10, 10);//draw and show card 6
			pen.drawString(text[6], 710, 320);
			pen.drawString(deck.get(6).substring(1), 660, 240);
			pen.drawString(deck.get(6).substring(1), 790, 240);
			pen.drawString(deck.get(6).substring(1), 670, 390);
			pen.drawString(deck.get(6).substring(1), 790, 390);
			P1 = P1 + value[6];//show new total
			pen.drawString(P1 + "", 320, 215);
			
			if (P1 < 21)//if player is less than 21, you win
			{
				pen.drawString("You Win!", 350, 215);
			}
		}
		if (P1 > 21)//if player is more than 21, you bust
		{
			pen.drawString("Busted!", 350, 215);
		}
		if (drawDealer)//if stay is clicked
		{
			D = D + value[8];//show dealer total
			pen.drawString(D + "", 250, 17);
			pen.drawString(text[8], 210, 110);//show second card
			pen.drawString(deck.get(8).substring(1), 180, 40);
			pen.drawString(deck.get(8).substring(1), 305, 40);
			pen.drawString(deck.get(8).substring(1), 180, 190);
			pen.drawString(deck.get(8).substring(1), 305, 190);
			if (D <= 16)
			{
				pen.drawRoundRect(340, 20, 150, 175, 10, 10);//if dealer hits gain
				D = D + value[9];//show new total
				pen.drawString(D + "", 300, 17);
				pen.drawString(text[9], 370, 110);//draw card nine
				pen.drawString(deck.get(9).substring(1), 345, 40);
				pen.drawString(deck.get(9).substring(1), 470, 40);
				pen.drawString(deck.get(9).substring(1), 345, 190);
				pen.drawString(deck.get(9).substring(1), 470, 190);
				if (D <= 16)//if dealer hits again
				{
					pen.drawRoundRect(500, 20, 150, 175, 10, 10);//draw card 10
					D = D + value[10];//show new total
					pen.drawString(D + "", 350, 17);
					pen.drawString(text[10], 530, 110);
					pen.drawString(deck.get(10).substring(1), 505, 40);
					pen.drawString(deck.get(10).substring(1), 630, 40);
					pen.drawString(deck.get(10).substring(1), 505, 190);
					pen.drawString(deck.get(10).substring(1), 630, 190);
					if (D <= 16)//if dealer hits again
					{
						pen.drawRoundRect(660, 20, 150, 175, 10, 10);//draw new card
						D = D + value[11];//show dealers new total
						pen.drawString(D + "", 400, 17);
						pen.drawString(text[11], 690, 110);
						pen.drawString(deck.get(11).substring(1), 665, 40);
						pen.drawString(deck.get(11).substring(1), 790, 40);
						pen.drawString(deck.get(11).substring(1), 665, 190);
						pen.drawString(deck.get(11).substring(1), 790, 190);
					}
				}
			} 
			if (D > P1 && D <= 21)//if dealer is higher than player and dealer is less than 21
			{
				pen.drawString("Dealer Wins", 350, 215);//dealer wins
			} 		else if (D == P1)//else if dealer equals player
			{
				pen.drawString("Tie, Dealer Wins", 350, 215);//tie, dealer wins
			} else if (D > 21)//else if dealer is over
			{
				pen.drawString("Dealer Busts, You Win!", 350, 215);//dealer busts, you win
			} else if (D < 21 && P1 > D && P1 <= 21)//else if dealer is less than 21 and player 
				//is higher than dealer and player is less than or equal to 21
			{
				pen.drawString("You Win!", 350, 215);//player wins
			}
		}
	}
	class ButtonListener implements ActionListener//start buttonlistener
	{
		public void actionPerformed(ActionEvent buttonClick)//create actionevent
		{
			String Click = buttonClick.getActionCommand();//create string Click
			if (Click.equals("Hit"))//if click equals Hit
			{
				drawHit = true;//draw hit 1
				Hit.setVisible(false);//hide hit button
				ButtonListener listener = new ButtonListener();//create listener
				Hit2 = new JButton("Hit");//create hit button 2
				Hit2.setActionCommand("Hit2");//set action to hit2
				Hit2.addActionListener(listener);//add listener
				add(Hit2);//add hit2 to panel
				repaint();//repaint panel
			}
			if (Click.equals("Hit2"))//if click equals hit2
			{
				drawHit2 = true;//draw hit2
				Hit2.setVisible(false);//hide hit2 button
				ButtonListener listener = new ButtonListener();//create buttonlistener
				Hit3 = new JButton("Hit");//create hit button 3
				Hit3.setActionCommand("Hit3");//set action to hit3
				Hit3.addActionListener(listener);//add listener to button
				add(Hit3);//add hit3 to panel
				repaint();//repaint
			}
			if (Click.equals("Hit3"))//if click equals hit3
			{
				drawHit3 = true;//draw hit3
				Hit3.setVisible(false);//hide hit3 button
				repaint();//repaint
			}
			if (Click.equals("Stay"))//if click equals stay
			{
				drawDealer = true;//draw dealer
				Hit.setVisible(false);//disable both buttons
				Stay.setVisible(false);
				repaint();//repaint
			}
		}
	}
}//end program