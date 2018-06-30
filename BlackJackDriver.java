/** Jacob Swanson
 *  5/13/12
 *  BlackJack Driver
 */
import javax.swing.JFrame;//import needed utilities
import javax.swing.JPanel;

public class BlackJackDriver//start class
{
	static JPanel panel = new JPanel();//create new Jpanel called panel
	static JFrame window = new JFrame();//create JFrame called window
	
	public static void main(String[] args)//start main argument
	{
		window.setSize(850, 450);//set window size to 850 by 450
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close program on window exit
		window.setTitle("BlackJack");//set title to BlackJack
		BlackJack panel = new BlackJack();//create new BlackJake game on panel
		window.add(panel);//add panel to window
		window.setVisible(true);//display window
	}
}//end class