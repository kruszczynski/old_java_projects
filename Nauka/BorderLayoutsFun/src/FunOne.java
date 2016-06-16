import java.awt.*;
import javax.swing.*;

public class FunOne {
	
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout layout = new BorderLayout();
		JPanel panel = new JPanel(layout);
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JButton button = new JButton("Tesco");
		panel.add(BorderLayout.NORTH,button);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
