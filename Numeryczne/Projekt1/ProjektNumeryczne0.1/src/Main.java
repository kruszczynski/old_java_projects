public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		float[][] a = {{3,5,5,3,3},{3,3,3},{3,3,3},{3,3,3}};
//		System.out.print(a.length + " " + a[0].length);
		
		double[][] A = {{2,1,1},{1,2,1},{1,1,2}};
		for(int i = 0; i<A.length; i++){
			for(int j = 0; j<A[i].length; j++){
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		DecompHelper helper = new DecompHelper(A);
		helper.decompMatrix();
		double[][] L = helper.getL();
		double[][] LT = helper.getLT();
		for(int i = 0; i<L.length; i++){
			for(int j = 0; j<L[i].length; j++){
				System.out.print(L[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 0; i<LT.length; i++){
			for(int j = 0; j<LT[i].length; j++){
				System.out.print(LT[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
