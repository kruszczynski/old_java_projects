
public class Main {

	public static void main(String[] args) {
		double[][] A={{3,1,1},{1,3,1},{1,1,3}};
		double[] b = {4,5,6};
		SystemHelper helper = new SystemHelper(A,b);
		helper.solveSystem();
		double[] x = helper.getSolution();
		for(int i = 0; i<x.length;i++)
			System.out.print(x[i] + ", ");
		System.out.println();
		double[][] I = helper.getInverse();
		for(int i = 0; i<I.length; i++){
			for(int j = 0; j<I.length; j++){
				System.out.print(I[i][j]+", ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
