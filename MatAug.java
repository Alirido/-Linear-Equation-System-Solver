import java.util.*;
import java.io.File;

public class MatAug { // Matrix Augmented

	// Atribut
	double[][] mt;
	int row, col;
	String[] result;

	MatAug (int m, int n) {
		mt = new double[m+1][n+1];
		row = m;
		col = n;
		result = new String[n-1];
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

		System.out.println("Matrix augmented is successfully created!\n");
		// in.close();
	}

	public void fillUsingSPLFile() {
		File f = new File("tes.txt");

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
			System.out.println("Matrix augmented is successfully created!\n");
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

		System.out.println("Matrix augmented is successfully created!\n");
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
			System.out.println("Matrix augmented is successfully created!\n");
			if (scan != null)
				scan.close();
		}
	}

	// Algorithm for Gauss and Gauss-jordan elimination
	public void _swap(int i, int j) { // j higher than i (row)
		if (i!=j) {

			double[] temp = new double[this.col];
			// for (int i=0; i<)
			temp = mt[i];
			mt[i]=mt[j];
			mt[j]=temp;
		}
	}

	public void _simplify(int i) {
		int j=0;
		while (mt[i][j]==0)
			j++;
		double divisor=mt[i][j];
		for (; j<this.col; j++) {
			mt[i][j]/=divisor;
		}
	}

	public void _minusRow(int i, int j, int checkpoint) {
		if (mt[i][checkpoint]!=0) {
			double multipler = mt[i][checkpoint];
			for (int idx=checkpoint; idx<this.col; idx++) {
				mt[i][idx] -= multipler*mt[j][idx];
			}
		}
	}

	public byte _checkRow() {
		int i = this.row-1, j=0, check=-1;
		while (i>=0 && check == -1) {
			while (j<this.col && check == -1) {
				if (mt[i][j]!=0)
					check = j;
				else j++;
			}
			i--;
		}
		if (check==this.col-1)
			return 0;
		else return 1;

	}

	public int _findMainOne(int r) {
		int ans = -1, j=0;
		while (ans==-1 && j<this.col-1) {
			if (mt[r][j]==1)
				ans = j;
			else j++;
		}
		return ans;
	}

	public void runGaussElimination() {

		// Make matriks Echelon
		int current_row=0;
		for (int j=0; j<(this.col-1); j++) {
			int i=current_row;
			boolean found=false;
			while (!found && i<this.row) {
				if (mt[i][j]!=0) {
					this._swap(i, j);
					this._simplify(j);
					found=true;
				} else i++;
			}
			if (found) {
				for (i=current_row+1; i<this.row; i++) {
					this._minusRow(i, current_row, j);
				}
				current_row++;
			}
		}

		//Testing
		System.out.println("The result of Gauss Elimination method: ");
		this.printM();

		byte solution = this._checkRow();

		if (solution==0) // No solution
			System.out.println("This system has no solution");
		else if (solution==1) { // There is solution
			// String[] ans = new String[this.col];
			char ex = 'a'; // Example
			for (int i=this.row-1; i>=0; i--) {
				int firstNum=-1, j=0;

				while (firstNum==-1 && j<this.col-1) {
					if (mt[i][j]!=0)
						firstNum = j;
					else j++;
				}

				if (firstNum!=-1) {
					double value = mt[i][this.col-1];
					String variable = "";
					for (j=firstNum+1; j<this.col-1; j++) {
						if (mt[i][j]==0) {
							if (result[j]==null) {
								result[j] = "" + ex;
								ex++;
							}
						} else {
							if (result[j]==null) {
								result[j] = "" + ex;
								ex++;
							}
							try {
								double tempf = Double.parseDouble(result[j]);
								value -= (tempf*mt[i][j]);
							} catch (Exception e) {
								variable += (mt[i][j]>0? " - "+mt[i][j]+"("+result[j]+")" : " + "+(mt[i][j]*(-1))+"("+result[j]+")");
							}
						}
					}
					result[firstNum] = "" + value + variable;
				}
			}
			System.out.println("Solution of this system is :");
			for (int i=0; i<this.col-1; i++)
				System.out.println("x" + (i+1) + " = " + result[i]);
		} 

	}

	public void runGaussJordanElimination() {
		// Make matriks Echelon
		int current_row=0;
		for (int j=0; j<(this.col-1); j++) {
			int i=current_row;
			boolean found=false;
			while (!found && i<this.row) {
				if (mt[i][j]!=0) {
					this._swap(i, j);
					this._simplify(j);
					found=true;
				} else i++;
			}
			if (found) {
				for (i=current_row+1; i<this.row; i++) {
					this._minusRow(i, current_row, j);
				}
				current_row++;
			}
		}

		// Make Matriks Reduction-Echelon
		current_row = this.row-1;
		while (current_row>0) {	
			int j = this._findMainOne(current_row);
			while (j==-1) {
				current_row--;
				j = this._findMainOne(current_row);
			}
			for (int i=current_row-1; i>=0; i--) {
				this._minusRow(i, current_row, j);
			}
			current_row--;
		}

		//Testing
		System.out.println("The result of Gauss-Jordan Elimination method: ");
		this.printM();

		byte solution = this._checkRow();

		if (solution==0) // No solution
			System.out.println("This system has no solution");
		else if (solution==1) { // There is solution
			char ex = 'a'; // Example
			for (int i=this.row-1; i>=0; i--) {
				int firstNum=-1, j=0;

				while (firstNum==-1 && j<this.col-1) {
					if (mt[i][j]!=0)
						firstNum = j;
					else j++;
				}

				if (firstNum!=-1) {
					double value = mt[i][this.col-1];
					String variable = "";
					for (j=firstNum+1; j<this.col-1; j++) {
						if (mt[i][j]==0) {
							if (result[j]==null) {
								result[j] = "" + ex;
								ex++;
							}
						} else {
							if (result[j]==null) {
								result[j] = "" + ex;
								ex++;
							}
							try {
								double tempf = Double.parseDouble(result[j]);
								value -= (tempf*mt[i][j]);
							} catch (Exception e) {
								variable += (mt[i][j]>0? " - "+mt[i][j]+"("+result[j]+")" : " + "+(mt[i][j]*(-1))+"("+result[j]+")");
							}
						}
					}
					result[firstNum] = "" + value + variable;
				}
			}
			System.out.println("Solution of this system is :");
			for (int i=0; i<this.col-1; i++)
				System.out.println("x" + (i+1) + " = " + result[i]);
		}
	}

	public void printFunction() {
		
	}

	public double fResult(double x) {
		double multipler=1,ans=0;
		for (int i=0; i<this.col-1; i++) {
			double temp = Double.parseDouble(result[i]);
			ans += (temp*multipler);
			multipler *= x;
		}
		return ans;
	}

	// Display Matrix Augmented
	public void printM() {
		for (int i=0; i<this.row; i++) {
			for (int j=0; j<this.col; j++)
				System.out.print(mt[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
}