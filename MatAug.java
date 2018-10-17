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

	public void fillWithPI() { // Polynomial Interpolation
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of points: ");
		int n = in.nextInt();
		System.out.println("Enter " + n + " points: ");

	}

	public void fillWithPIFile() { // Polynomial Interpolation

	}



	public void runGaussElimination() {
		
	}
}