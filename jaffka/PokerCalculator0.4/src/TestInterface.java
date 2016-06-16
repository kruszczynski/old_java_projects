import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TestInterface{
	JButton colorButton;
	JButton labelButton;
	JFrame frame;
	JLabel label;

	public void test() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		labelButton = new JButton("Zmien etykiete");
		colorButton = new JButton("Zmien kolor");
		
		labelButton.addActionListener(new LabelListener());
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("pari biri bom");
		MyDrawPanel MDP = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
		frame.getContentPane().add(BorderLayout.CENTER,MDP);
		frame.getContentPane().add(BorderLayout.EAST,labelButton);
		frame.getContentPane().add(BorderLayout.WEST,label);
		
		frame.setSize(450,300);
		frame.setVisible(true);
		

	}
	
	class LabelListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			label.setText("O w pytolonga!");
		}
	}
	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			frame.repaint();
		}
	}
}

