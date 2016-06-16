
public class TextConverter {
	private double[][] innerMat;
	private double[] innerVec;
	
	public void convertText(String text){
//		System.out.println(text);
		text = text.replace(" ","").replace("/n","");
		
		// rozdzial na macierz i wektor
		String[] system = text.split("&");
		
		// parsowanie macierzy
		
		String[] rows = null;

		rows=system[0].split(";");
		
		int dim = rows.length;
		
	//	System.out.print(rows.length);
		
		String[][] mat = new String[dim][dim];
		innerMat = new double[dim][dim];
		
		int iterator = 0;
		for( String row : rows){
			
			String temp = null;
			temp = row.replace("{", "").replace("}","");
			mat[iterator] = temp.split(",");
			
			iterator ++;
		}
		
/*		System.out.println(mat[0][0]);
		for(String[] row : mat){
			for(String e : row){
				System.out.print(e);
			}
			System.out.println("");
		}*/
		
/*		int rowator = 0;
		int elementor = 0;
		
		for(String[] row : mat){
			
			for(String e : row){
				
				innerMat[rowator][elementor] = Double.parseDouble( e );
				System.out.print(innerMat[rowator][elementor]);
				elementor++;
			}
			rowator++;
		} */
		
		for(int i =0; i<dim;i++){
			for(int j=0;j<dim;j++){
				innerMat[i][j] = Double.parseDouble(mat[i][j]);
				
//				System.out.print(mat[i][j]);
				
				
			}
		}
		
		
		// parsowanie wektora
		
		String vec = null;
		vec = system[1];
		vec = vec.replace("{", "").replace("}","");
		String vecSplit[] = null;
		vecSplit = vec.split(",");
		
		innerVec = new double[dim];
		
		for(int i =0; i<dim; i++){
			innerVec[i] = Double.parseDouble(vecSplit[i]);
		}
		
		
	}
	
	public double[][] getMatrix(){
		return innerMat;
	}
	
	public double[] getVector(){
		return innerVec;
	}
	
	
}
