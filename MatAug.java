import java.util.Scanner;

public class MatAug { // Matrix Augmented

	// Atribut
	double[][] mt;
	int row, col;

	MatAug (int m, int n) {
		mt = new double[m+1][n+1];
		row = m;
		col = n;
	}

	// Getter
	public double get(int i, int j) {
		return mt[i][j];
	}

	public void fillUsingSPL() {
		Scanner in = new Scanner(System.in);
		for (int i=0; i<this.row; i++) {
			for (int j=0; j<this.col; j++) {
				this.mt[i][j] = in.nextDouble();
			}
		}

		System.out.println("Matrix augmented is successfully created!");
		// in.close();
	}

	public void fillUsingSPLFile() {
		File f = new File("spl.txt");

		Scanner scan = new Scanner(f);

		for (int i=0;i<this.row; i++) {
			for (int j=0; j<this.col; j++) {
				this.mt[i][j]=scan.nextDouble();
			}
		}

		scan.close();

	}

	public void fillUsingPI() { // Polynomial Interpolation
		Scanner in = new Scanner(System.in);
		for (int i=0; i<this.row; i++) {
			double x = in.nextDouble(), y = in.nextDouble();
			this.mt[i][0] = 1; this.mt[i][n+1]=y;
			for (int j=1; j<=this.col; j++) {
				this.mt[i][j] = this.mt[i][j-1]*x;
			}
		}

		System.out.println("Matrix augmented is successfully created!");
		// in.close();
	}

	public void fillWithPIFile() { // Polynomial Interpolation

	}



	public void runGaussElimination() {

	}

	public void runGaussJordanElimination() {
		
	}

	public void printM() {
		for (int i=0; i<this.row; i++) {
			for (int j=0; j<this.col; j++)
				System.out.print(mt[i][j] + " ");
			System.out.println();
		}
	}
}