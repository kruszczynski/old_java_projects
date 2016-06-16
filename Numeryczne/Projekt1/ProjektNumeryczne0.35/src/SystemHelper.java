
public class SystemHelper {
	private DecompHelper mainHelper;
//	private DecompHelper detHelper;
	private double[] x;
	private double[] b;
	private double[][] L;
	private double[][] LT;
	private double[][] mat;
	private double[][] inv;
	private int size;
	
	public SystemHelper(double[][] A, double[] ba){
		if(checkSystem(A,ba)){
			mat = A;
			mainHelper = new DecompHelper(A);
			b = ba;
			size = mainHelper.getSize();
		}
	}
	
	public boolean checkSystem(double[][] A, double[] b){
		
		return isSymetrical(A) && checkSizes(A,b);
	}
	
/*	public boolean isPositive(double[][] A){
		boolean test = true;
		
		for(int i = 0; i<A.length; i++){
			double[][] temp = new double[i][i];
			temp = getMinor(A,i);
			if(getDet(temp) <=0){
				test = false;
				break;
			}
		}
		
		return test;
	}*/
	
	public double[][] getMinor(double[][] A, int n){
		double[][] temp = new double[n][n];
		for(int i = 0; i<n;i++){
			for(int j=0;j<n;j++){
				temp[i][j]=A[i][j];
			}
		}
		return temp;
	}
	
	
	public boolean checkSizes(double[][] A, double[] b){
		boolean test = true;
		int dim = b.length;
		if(dim != A.length){
			test = false;
		}
		else{
			for(double row[] : A){
				if(dim != row.length){
					test = false;
					break;
				}
			}
		}
		return test;
	}
	
	public boolean isSymetrical(double[][] A){
		boolean test = true;
		boolean iBreak = false;
		for(int i = 0; i< A.length; i++){
			for( int j = 0; j<i;j++){
				if(A[i][j] != A[j][i]){
					iBreak=true;
					test =false;
					break;
				}
			}
			if(iBreak)
				break;
		}
		return test;
	}
	
	public void solveSystem(){
		mainHelper.decompMatrix();
		L = mainHelper.getL();
		LT = mainHelper.getLT();
		
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
		inv = new double[size][size];
		for(int i = 0; i<size; i++){
			double[] temp = new double[size];
			temp[i]=1;
			double[] y = lowerSolve(L,temp);
			double[] x = upperSolve(LT,y);
			for(int j = 0; j<size; j++)
				inv[j][i] = x[j];
		}
		return inv;
	}

	
	public double getVNorm(double[] b){
		double s = 0;
		for(double d : b){
			s=s+d*d;
		}
		return Math.sqrt(s);
	}
	
	public double getNorm(double[][] A){
		double temp = 0;		
		for(int i =0; i<A.length;i++){
			double s = 0;
			for(int j = 0; j<A.length;j++){
				s = s + Math.abs(A[i][j]);
			}
			if(s>temp)
				temp=s;
		}
		return temp;
	}
	
	public double[] substractVec(double[] a, double[] b){
		double[] r = new double[a.length];
		if(a.length == b.length){
			for(int i = 0; i<a.length;i++){
				r[i]=a[i]-b[i];
			}
		}
		return r;
	}
	
	public double[] matVecMulti(double[][] A, double[] b){
		double[] r = new double[b.length];
		for(int i=0;i<A.length;i++){
			double s = 0;
			for(int j =0; j<b.length;j++){
				s= s + A[i][j]*b[j];
			}
			r[i] = s;
		}
		return r;
	}
	
	
	public String getErrors(){
		double WU = getNorm(inv)*getNorm(mat);
		double BW = getVNorm(substractVec(x,matVecMulti(inv,b)))/getVNorm(matVecMulti(inv,b));
		double WP = getVNorm(substractVec(b, matVecMulti(mat,x)))/(Double.MIN_VALUE*getNorm(mat)*getVNorm(x));
		double temp = Double.MIN_VALUE*WU;
		double WS = BW/temp;
		
		
		return String.format("WU = %e, BW = %e, WP = %e, WS = %e",WU,BW,WP,WS);
	}
	
}
