import java.util.Scanner;

public class MatAug { // Matrix Augmented

	// Atribut
	double[][] mt;

	MatAug (int n, int m) {
		mt = new double[n+1][m+1]; 
	}

	MatAug (int n) {
		mt = new double[n+1][n+1];
	}

	public void fillWithSPL() {
		System.out.println("Enter the size of matrix augmented:")
		Scanner in = new Scanner(System.in);
		int m=in.nextInt(),n=in.nextInt();
		System.out.println("Enter the matrix augmented:");
		for (int i=0; i<m; i++) {
			for (int j=0; j<=n; j++) {
				this.mt[i][j] = in.nextDouble();
			}
		}

		System.out.println("Matrix augmented is successfully created!")
	}

	public void fillWithSPLFile() {

	}

	public void fillWithPI() { // Polynomial Interpolation

	}

	public void fillWithPIFile() { // Polynomial Interpolation

	}
}