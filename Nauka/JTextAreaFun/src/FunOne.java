import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FunOne implements ActionListener{
	JFrame frame;
	JPanel panel;
	JTextArea text;
	
	public static void main(String[] args){
		FunOne gui = new FunOne();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame();
		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		JButton button = new JButton("Just click it!");
		button.addActionListener(this);
		text = new JTextArea(10,20);
		text.setText("Wpisywac!");
		text.setLineWrap(true);
		JScrollPane scroller = new JScrollPane(text);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel.add(scroller);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		
		frame.setSize(350,300);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ev){
		text.append("button clicked \n");
	}

}
