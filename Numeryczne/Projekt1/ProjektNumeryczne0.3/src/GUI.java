import javax.swing.*;
import java.awt.event.*;

public class GUI {
	private JFrame frame;
	private JPanel mainPanel;
	
	private JLabel space = new JLabel("  ");
	
	private JTextArea areaOne;
	private JPanel areaPanelOne;
	
	private JTextArea areaTwo;
	private JPanel areaPanelTwo;
	
	private JPanel allAreaPanel;

	
	private JLabel topLabelOne;
	private JLabel topLabelTwo;
	private JPanel topLabelPanel;
	
	private JButton calcButton;
	
	private SystemHelper helper;
	
	private JPanel resultPanel;
	
	
	public void go(){
		frame = new JFrame("Cholesky Banachiewicz");
		
		topLabelPanel = new JPanel();
		topLabelPanel.setLayout(new BoxLayout( topLabelPanel,BoxLayout.X_AXIS));
		topLabelOne = new JLabel("Podaj macierz A i wektor b, do macierzy uzyj skladni \"listy list\"");
		topLabelTwo = new JLabel("");
		topLabelPanel.add(topLabelOne);
		topLabelPanel.add(topLabelTwo);
		
		
		areaOne = new JTextArea(10,20);
		areaOne.setText("Macierz A");
		areaOne.setLineWrap(true);
		areaTwo = new JTextArea(10,5);
		areaTwo.setText("Wektor b");
		areaTwo.setLineWrap(true);
		areaPanelOne = new JPanel();
		areaPanelOne.add(areaOne);
		areaPanelTwo = new JPanel();
		areaPanelTwo.add(areaTwo);
		allAreaPanel = new JPanel();
		allAreaPanel.setLayout(new BoxLayout(allAreaPanel, BoxLayout.X_AXIS));
		allAreaPanel.add(areaPanelOne);
		allAreaPanel.add(space);
		allAreaPanel.add(areaPanelTwo);
		
		calcButton = new JButton("Policz!");
		calcButton.addActionListener(new calcButtonActionListener());
		
		resultPanel = new JPanel();
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.add(topLabelPanel);
		mainPanel.add(allAreaPanel);
		mainPanel.add(calcButton);
		
		
		
		frame.getContentPane().add(mainPanel);
		
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class calcButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String mat = areaOne.getText();
			String vec = areaTwo.getText();
			Double[][] A = Double.parseDouble(mat);
			
		}
	}
}
