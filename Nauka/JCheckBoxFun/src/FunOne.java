import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FunOne {
	JCheckBox check;
	JFrame frame;
	JPanel panel;
	Label label = new Label();
	

	public static void main(String[] args){
		FunOne gui = new FunOne();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		check = new JCheckBox("Czy lubisz placki?");
		check.addItemListener(new checkBoxListener());
		frame.getContentPane().add(BorderLayout.NORTH,check);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	class checkBoxListener implements ItemListener{
		public void itemStateChanged(ItemEvent event){
			if(check.isSelected())
				label = new Label("W istocie lubie placki!");
			else
				label = new Label("Placki to nie moja para kaloszy");
			panel.removeAll();
			panel.add(label);
			panel.validate();
		}
	}



}


