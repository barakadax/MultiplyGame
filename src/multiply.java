/*Code by Barakadax*/
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class multiply extends Frame implements WindowListener, ActionListener {
	private Label ex;
	private Button mightBe1;
	private Button mightBe2;
	private Button mightBe3;
	private Button exit;
	private Button again;
	private Random grimoire;
	private int number1;
	private int number2;
	private int result;
	
	public multiply() {
		super("Exercise");
		this.setSize(500, 300);
		this.grimoire = new Random();
		this.setLayout(new GridLayout(2,1));
		this.ex = new Label();
		this.ex.setFont(new Font("Times New Roman", Font.ITALIC,20));
		this.add(ex);
		Panel question = new Panel();
		question.setLayout(new GridLayout(0,3));
		this.mightBe1 = new Button();
		this.mightBe2 = new Button();
		this.mightBe3 = new Button();
		this.exit = new Button("Exit");
		this.again = new Button("Again");
		createNumbers();
		shuffleNfill();
		question.add(this.mightBe1);
		question.add(this.mightBe2);
		question.add(this.mightBe3);
		question.add(this.exit);
		question.add(this.again);
		this.add(question);
		this.addWindowListener(this);
		this.exit.addActionListener(this);
		this.again.addActionListener(this);
		this.mightBe1.addActionListener(this);
		this.mightBe2.addActionListener(this);
		this.mightBe3.addActionListener(this);
		this.setLocation(200,200);
		this.setVisible(true);
	}//O(1)
	
	public void createNumbers() {
		this.number1 = grimoire.nextInt(11);
		this.number2 = grimoire.nextInt(11);
		this.result = this.number1 * this.number2;
		this.ex.setText(this.number1 + " * " + this.number2 + " =");
	}//O(1)
	
	public void shuffleNfill() {
		int[] options = {this.result, (this.number1 / 2 + this.number2 / 2) * 9 + 3, this.number1 % 5 + this.number2 % 5};
		for (int shuffle = 0; shuffle < options.length; shuffle -= -1) {
			this.number1 = grimoire.nextInt(options.length);
			this.number2 = options[this.number1];
			options[this.number1] = options[shuffle];
			options[shuffle] = this.number2;
		}	
		this.mightBe1.setLabel(Integer.toString(options[0]));
		this.mightBe2.setLabel(Integer.toString(options[1]));
		this.mightBe3.setLabel(Integer.toString(options[2]));
	}//O(N)

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.exit)
			this.dispose();
		else if (arg0.getSource() == this.again) {
			createNumbers();
			shuffleNfill();
			this.ex.setBackground(UIManager.getColor("Panel.background"));
		}
		else if (Integer.parseInt(arg0.getActionCommand()) == result)
			this.ex.setBackground(Color.green);
		else
			this.ex.setBackground(Color.red);
	}//O(1)
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		multiply some = new multiply();
	}//O(1)
}