import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.*;

public class JListFun {
	JList list;
	JFrame frame;
	JPanel panel;
	String wynik="";
	Label label2;
	MyDrawPanel mdp;
	
	
	public static void main(String[] args){
		JListFun gui = new JListFun();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame("Test wspanialosci Bartka");
		panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mdp = new MyDrawPanel();
		frame.setContentPane(mdp);
		
		mdp.setLayout(new BoxLayout(mdp,BoxLayout.Y_AXIS));

		Label label = new Label("Co w Bartku najwspaniajsze jest?");
		label.setBackground(Color.WHITE);
		mdp.add(label);
		
		String[] cechy = {"wspanialy","piekny","dziki","inteligentny","kochany","czarujacy"};
		list = new JList(cechy);
		JScrollPane scroller = new JScrollPane(list);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		list.setVisibleRowCount(6);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		list.addListSelectionListener(new myListSelectionListener());
		
		JButton triggerButton = new JButton("Skonczylem!");
		triggerButton.addActionListener(new triggerButtonListener());
		
		label2 = new Label( "Bartek twoim zadniem jest: ");
		label2.setBackground(Color.white);
		
		mdp.add(scroller);
		mdp.add(triggerButton);
		mdp.add(label2);
		
		frame.setSize(350,350);
		frame.setVisible(true);
	}
	class myListSelectionListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent lse){
			if(!lse.getValueIsAdjusting()){
				wynik =  (String) list.getSelectedValue();
				System.out.println(wynik);
			}
		}
	}
	class triggerButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			label2.setText( "Bartek twoim zadniem jest: "+wynik);
			label2.validate();
			mdp.validate();
			mdp.repaint();
		}
	}
}
