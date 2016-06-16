import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gradient = new GradientPaint(0,50 , Color.white ,0, getHeight(),new Color(50,50,50));
		g2d.setPaint(gradient);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
}
