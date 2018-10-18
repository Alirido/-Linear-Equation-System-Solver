import java.util.Scanner;
import java.io.File;

public class MatAug { // Matrix Augmented

	// Atribut
	double[][] mt;
	int row, col;
	double[] result;

	MatAug (int m, int n) {
		mt = new double[m+1][n+1];
		row = m;
		col = n;
		result = new double[n];
	}

	// Getter
	public double get(int i, int j) {
		return mt[i][j];
	}

	// Filling Matrix Augmented from input
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

		Scanner scan = null;
		try {
			scan = new Scanner(f);
	
			for (int i=0;i<this.row; i++) {
				for (int j=0; j<this.col; j++) {
					this.mt[i][j]=scan.nextDouble();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Matrix augmented is successfully created!");
			if (scan != null)
				scan.close();
		}

	}

	public void fillUsingPI() { // Polynomial Interpolation
		Scanner in = new Scanner(System.in);
		for (int i=0; i<this.row; i++) {
			double x = in.nextDouble(), y = in.nextDouble();
			this.mt[i][0] = 1; this.mt[i][this.col-1]=y;
			for (int j=1; j<(this.col-1); j++) {
				this.mt[i][j] = this.mt[i][j-1]*x;
			}
		}

		System.out.println("Matrix augmented is successfully created!");
		// in.close();
	}

	public void fillUsingPIFile() { // Polynomial Interpolation
		File f = new File("pi.txt");

		Scanner scan = null;
		try {
			scan = new Scanner(f);
	
			for (int i=0; i<this.row; i++) {
				
				double x = scan.nextDouble(), y = scan.nextDouble();
				
				this.mt[i][0] = 1; this.mt[i][this.col-1]=y;
				
				for (int j=1; j<(this.col-1); j++) {
					this.mt[i][j] = this.mt[i][j-1]*x;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Matrix augmented is successfully created!");
			if (scan != null)
				scan.close();
		}
	}

	// Algorithm for Gauss and Gauss-jordan elimination
	public void runGaussElimination() {
		// Searching row with the main one

		for (int j=0; j<(this.col-1); j++) {
			int i=j;
			boolean found=false;
			while (!found && i<this.row) {
				if (mt[i][j]!=0) {
					this.swap(i, j);
					this.simplify(j);
					found=true;
				} else i++;
			}
			if (found) {
				for (i=j+1; i<this.row; i++) {
					this.minusRow(i, j);
				}
			}
		}

		byte solution = this.checkLastRow();
		if (solution==-1)
			System.out.println("This system has no solution");
		else if (solution==0) {
			String ans = new String[this.col-1];
			char ex = 'a'; // Example
			for (int i=this.row-1; i>=0; i--) {
				for ()
			}
		} else {
			// System.out.println("This system has a solution");
			this.substitute();

		}

	}

	public void runGaussJordanElimination() {
		
	}

	// Display Matrix Augmented
	public void printM() {
		System.out.println("Size of Matrix Augmented = " + this.row + " x " + this.col); // Debugging
		for (int i=0; i<this.row; i++) {
			for (int j=0; j<this.col; j++)
				System.out.print(mt[i][j] + " ");
			System.out.println();
		}
	}
}