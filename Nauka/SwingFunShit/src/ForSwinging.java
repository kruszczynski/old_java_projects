import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ForSwinging {
	JFrame frame;
	JPanel panel;
	JTextField myField;
	String importedFromField;
	
	public static void main (String[] args){
		ForSwinging gui = new ForSwinging();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame("To wazny tekst?");
		panel = new JPanel();
		panel.setBackground(Color.darkGray);
	//	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		myField = new JTextField(20);
		myField.setText("Wpisz pan cos");
		myField.addActionListener(new myFieldActionListener());
		
	//	panel.add(myField);
		
		JButton clear = new JButton("Wyczysc");
		clear.addActionListener(new clearingButtonActionListener());
		frame.getContentPane().add(BorderLayout.SOUTH,clear);
		
		
		frame.getContentPane().add(BorderLayout.NORTH, myField);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250,300);
		frame.setVisible(true);
	}
	
	public void makeButton(){
		JButton newButton = new JButton(importedFromField);
		newButton.addActionListener(new newButtonActionListener());
		panel.add(newButton);
	}
	
	class myFieldActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			importedFromField = myField.getText();
			makeButton();
			frame.getContentPane();
		//	frame.setVisible(false);
		//	frame.setVisible(true);
		}
	}
	
	class newButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			myField.setText("");
		}
	}
	
	class clearingButtonActionListener implements ActionListener{
		public void actionPerformed( ActionEvent event){
			frame.getContentPane().remove(panel);
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			frame.getContentPane().add(BorderLayout.CENTER,panel);
			frame.setVisible(false);
			frame.setVisible(true);
		}
	}
}
