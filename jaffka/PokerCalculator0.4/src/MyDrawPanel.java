import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {
	
	public void paintComponent(Graphics g){
	/*	g.setColor(Color.orange);
		g.fillRect(20, 50, 100, 100);  */
		
		Graphics2D g2d = (Graphics2D) g;
		int red = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		Color endColor = new Color(red,green,blue);

		red = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		Color startColor = new Color(red,green,blue);
		
		GradientPaint gradient = new GradientPaint(0,0 , startColor , 300,300,endColor);
		g2d.setPaint(gradient);
		g2d.fillRect(0, 0, 300, 300);
	}
}
