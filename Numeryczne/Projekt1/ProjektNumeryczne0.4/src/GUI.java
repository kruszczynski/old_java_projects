import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.util.*;


public class GUI {
	// INNE
	private double[][] matDou;
	private double[] vecDou;
	private SystemHelper helper;
	
	//SWINGOWE
	private JFrame frame;
	private JPanel panel;
	private JPanel mastaPanel;
	private JFileChooser chooser;
	private JButton openButton;
	private File openFile;
	private JTextField fileNameTF;
	private ArrayList<JPanel> panelArray;
	private JPanel temp;
	private JTextArea instructionsTA;
	private JTextArea inputMatrixTA;
	private JTextArea inputVectorTA;
	private JScrollPane inputMatrixScroller;
	private JScrollPane inputVectorScroller;
	private JButton calcButton;
	private JTextArea outputMatrixTA;
	private JTextArea outputVectorTA;
	private JScrollPane outputMatrixScroller;
	private JScrollPane outputVectorScroller;
	
	
	public void go(){
		//FRAME I GL PANEL
		frame = new JFrame("cholban");
		mastaPanel = new JPanel();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panelArray = new ArrayList<JPanel>();
		
		//OTWIERANIE PLIKU
		openButton = new JButton("Open");
		openButton.addActionListener(new OpenButtonActionListener());
		
		fileNameTF = new JTextField(15);
		fileNameTF.setEditable(false);
		
		
		// INSTRUKCJE DLA USERA
		temp = new JPanel();
		instructionsTA = new JTextArea();
		instructionsTA.setEditable(false);
		instructionsTA.setText("Potrzebny jest plik .txt. \nMacierz podana z rozdzieleniem wierszy \";\" i elementow \",\"\npo czym rozdzielona od wektora \"&\"");
		temp.add(instructionsTA);
		panelArray.add(temp);
		
		
		//PANEL OTWIERANIA
		temp = new JPanel();
		temp.add(openButton);
		temp.add(fileNameTF);
		panelArray.add(temp);

		
		//SEKCJA WYSWIETLANIA MACIERZY I WEKTORA
		inputMatrixTA=new JTextArea(20,20);
		inputMatrixTA.setEditable(false);
		inputVectorTA=new JTextArea(20,6);
		inputVectorTA.setEditable(false);
		inputMatrixScroller = new JScrollPane(inputMatrixTA);
		inputVectorScroller = new JScrollPane(inputVectorTA);
		inputMatrixScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		inputVectorScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		inputMatrixScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		inputVectorScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		temp = new JPanel();
		temp.add(inputMatrixScroller);
		temp.add(inputVectorScroller);
		panelArray.add(temp);
		
		//panel na guziczek do liczenia
		calcButton = new JButton("Policz to");
		calcButton.addActionListener(new CalcButtonActionListener());
		temp = new JPanel();
		temp.add(calcButton);
		panelArray.add(temp);
		
		//PANEL Z WYNIKAMI
		outputMatrixTA=new JTextArea(20,20);
		outputMatrixTA.setEditable(false);
		outputVectorTA=new JTextArea(20,6);
		outputVectorTA.setEditable(false);
		outputMatrixScroller = new JScrollPane(outputMatrixTA);
		outputVectorScroller = new JScrollPane(outputVectorTA);
		outputMatrixScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		outputVectorScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		outputMatrixScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		outputVectorScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		temp = new JPanel();
		temp.add(outputVectorScroller);
		temp.add(outputMatrixScroller);
		panelArray.add(temp);
		
		//WSZYSTEK PANELI DODANY DO GL PANELU
		for(JPanel lilpanel : panelArray){
			panel.add(lilpanel);
		}
		mastaPanel.add(panel);
		frame.add(mastaPanel);
		
		frame.setSize(500,850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void file2Double(){
		TextConverter TC = new TextConverter();
		String matStr = null;
		
		try{
			FileReader openFR =  new FileReader(openFile);
			BufferedReader openBR = new BufferedReader(openFR);
			
			
			String line = null;
			while (( line = openBR.readLine()) != null) {
					matStr = matStr + line;
			}
			openBR.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		matStr = matStr.replace("null", "");
		TC.convertText(matStr);
		matDou = TC.getMatrix();
		vecDou = TC.getVector();
		
//		System.out.println(matDou[2][1]);
		
		for(int i =0; i< vecDou.length;i++){
			System.out.print(vecDou[i] + " ");
		}
		System.out.println();
		
		double[][] I = matDou;
		for(int i = 0; i<I.length; i++){
			for(int j = 0; j<I.length; j++){
				System.out.print(I[i][j]+", ");
			}
			System.out.println();
		}  
		
	}
	
	public void calculate(){
		helper = new SystemHelper(matDou,vecDou);
		helper.solveSystem();
		outputVectorTA.setText(dispVec(helper.getSolution()));
		outputMatrixTA.setText(dispMat(helper.getInverse()));
	}
	
	public String dispMat(double[][] mat){
		String r = "";
		for(double[] row : mat){
			for(double e : row){
				r=r+" "+e;
			}
			r=r+"\n";
		}
		
		return r;
	}
	
	public String dispVec(double[] vec){
		String r= "";
		for(double e : vec){
			r=r+e+"\n";
		}
		return r;
	}
	
	class OpenButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			chooser = new JFileChooser();
			
			int retval = chooser.showOpenDialog(frame);
			if( retval == JFileChooser.APPROVE_OPTION){
				openFile = chooser.getSelectedFile();
				fileNameTF.setText(openFile.getName());
				try{
					file2Double();
					inputMatrixTA.setText(dispMat(matDou));
					inputVectorTA.setText(dispVec(vecDou));
					
				}catch(Exception ex){ex.printStackTrace();}
			}
		}
	}

	class CalcButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			try{
				calculate();
				
			}catch(Exception ex){ex.printStackTrace();}
			
		}
	}

}
