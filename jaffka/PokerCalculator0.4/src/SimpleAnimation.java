import javax.swing.*;
import java.awt.*;


public class SimpleAnimation {
	
	int x = -10;
	int y = -10;
	
	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		InnerMyDrawPanel drawPanel = new InnerMyDrawPanel();
		
		frame.getContentPane().add(drawPanel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		for( int i = 0; i<290;i++){
			x++;
			y++;
			if(i == 288){
				i=0;
				x=-10;
				y=-10;
			}
			
			drawPanel.repaint();
			
			try{
				Thread.sleep(19);
			}catch(Exception ex){}
		}
		
	}
	
	class InnerMyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.black);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.blue);
			g.fillOval(x,y,40,40);
		}
	}
}
