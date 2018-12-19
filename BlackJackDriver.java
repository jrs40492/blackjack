
/** Jacob Swanson
 *  5/13/12
 *  BlackJack Driver
 */
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BlackJackDriver {
	static JFrame window = new JFrame();
	static JPanel panel = new JPanel();

	public static void main(String[] args) {
		window.setSize(850, 450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("BlackJack");
		BlackJack panel = new BlackJack();
		window.add(panel);
		window.setVisible(true);
	}
}
