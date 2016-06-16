public class SystemHelper {
	private DecompHelper helper;
	private double[] x;
	private double[] b;
	private double[][] L;
	private double[][] LT;
	private int size;
	
	public SystemHelper(double[][] A, double[] ba){
		if(checkSizes(A,b)){
			helper = new DecompHelper(A);
			b = ba;
			size = helper.getSize();
		}
	}
	
	public boolean checkSizes(double[][] A, double[] b){
		return true;
	}
	
	public void solveSystem(){
		helper.decompMatrix();
		L = helper.getL();
		LT = helper.getLT();
		
		double[] y;
		
		y = lowerSolve(L,b);
		
		x = upperSolve(LT,y);
		
		
	}
	
	public double[] getSolution(){
		return x;
	}
	
	public double[] lowerSolve(double[][] L, double[] b){
		double[] r = new double[size];
		for(int i = 0; i<size; i++){
			double s=0;
			for(int j = 0; j<i; j++)
				s = s+r[j]*L[i][j];
			r[i] = (b[i] - s)/L[i][i];
		}
		return r;
	}
	
	public double[] upperSolve(double[][] LT, double[] b){
		double[] r = new double[size];
		for( int i = size - 1; i>-1; i--){
			double s = 0;
			for(int j = size-1; j>i; j--)
				s= s+r[j]*LT[i][j];
			r[i]=(b[i] -s)/LT[i][i];
		}
		return r;
	}
	
	public double[][] lowerInverse(double[][] L){
		double[][] R = new double[size][size];
		for(int i = 0; i< size; i++){
			for(int j = 0; j<i+1; j++){
				if(i!=j){
					double s = 0;
					for(int k=0;k<i;k++)
						s = s+ L[i][k]*R[k][j];
					R[i][j]=1/L[i][i]*s;
				}else{
					R[i][j]=1/L[i][j];
				}
			}
		}
		return R;
	}
	
	public double[][] matrixMulti(double[][] A, double[][] B){
		double[][] R = new double[size][size];
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				for(int k = 0; k<size; k++){
					R[i][j] = R[i][j]+A[i][k]*B[k][j];
				}
			}
		}
		return R;
	}
	
	public double[][] getInverse(){		
		double[][] R = new double[size][size];
		for(int i = 0; i<size; i++){
			double[] temp = new double[size];
			temp[i]=1;
			double[] y = lowerSolve(L,temp);
			double[] x = upperSolve(LT,y);
			for(int j = 0; j<size; j++)
				R[j][i] = x[j];
		}
		return R;
	}
	
	
}
