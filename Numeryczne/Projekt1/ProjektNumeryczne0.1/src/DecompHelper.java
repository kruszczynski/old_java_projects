
public class DecompHelper {
	private double[][] L;
	private double[][] LT;
	private int size;
	private double[][] M2D;
	
	public DecompHelper(double[][] A){
		size = A.length;
		L= new double[size][size];
		LT = new double[size][size];
		M2D=A;
	}
	
/*	public boolean matrixVerification(float[][] A){
		A.
	} */
	
	public void decompMatrix(){
		
		for(int i =0; i<size; i++){
			for(int j = 0; j<i+1; j++){
				L[i][j] = getElement(i,j);
				System.out.println(L[i][j]);
			}
		}
		
		
		transL();
	}
	
	public double getElement(int i, int j){
		double a;
		
		if(i==j){
			double s=0;
			if(i>0){
				for(int k=0;k<j;k++){
					s=s+L[j][k]*L[j][k];
				}
			}

			a = Math.sqrt(M2D[j][j]-s); 
		}else{
			double s=0;
			if(j>0){
				for(int k=0;k<j;k++){
					s=s+L[i][k]*L[j][k];
				}
			}
			a=1/L[j][j]*(M2D[i][j]-s);
			
		}
		return a;
	}
	
	public double[][] getL(){
		return L;
	}
	
	public double[][] getLT(){
		return LT;
	}
	
	
	//jak uzyskamy macierz L to zrobi LT jej transponowanatosc
	public void transL(){
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				LT[i][j] = L[j][i];
			}
		}
	}
	
	
}
