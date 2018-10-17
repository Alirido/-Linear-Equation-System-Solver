import java.util.Scanner;

public class MatAug { // Matrix Augmented

	// Atribut
	double[][] mt;

	MatAug (int m, int n) {
		mt = new double[m+1][n+1];
	}

	// Getter
	public double get(int i, int j) {
		return mt[i][j];
	}

	public void fillUsingSPL(int m, int n) {
		Scanner in = new Scanner(System.in);
		for (int i=0; i<m; i++) {
			for (int j=0; j<=n; j++) {
				this.mt[i][j] = in.nextDouble();
			}
		}

		System.out.println("Matrix augmented is successfully created!");
		in.close();
	}

	public void fillWithSPLFile() {

	}

	public void fillUsingPI(int n) { // Polynomial Interpolation
		Scanner in = new Scanner(System.in);
		for (int i=0; i<n; i++) {
			double x = in.nextDouble(), y = in.nextDouble();
			this.mt[i][0] = 1; this.mt[i][n+1]=y;
			for (int j=1; j<=n; j++) {
				this.mt[i][j] = this.mt[i][j-1]*x;
			}
		}

		System.out.println("Matrix augmented is successfully created!");
		in.close();
	}

	public void fillWithPIFile() { // Polynomial Interpolation

	}



	public void runGaussElimination() {

	}

	public void runGaussJordanElimination() {
		
	}
}