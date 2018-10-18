import java.util.Scanner;
import java.lang.*;
import java.io.File;

public class Main {

	public static void main(String[] args) {

		// Loading segment
		System.out.println();
		System.out.println();
		System.out.print("\t");
		for (int i=0; i<50; i++) {
			System.out.print('~');

			try {
				Thread.sleep(10);
			} catch(Exception e) {
				System.out.println(e);
				Thread.currentThread().interrupt();
			}
		}
		System.out.println();

		byte menu = Option.chooseMenu();
		System.out.println();

		Scanner in = new Scanner(System.in);
		if (menu==1) { // Linear Equation System
			byte input = Option.chooseInput();

			if (input == 1) { // Input from keyboard
				int m = in.nextInt(), n = in.nextInt();
				MatAug mt = new MatAug(m,n+1);
				mt.fillUsingSPL();
				System.out.println();

				// Choosing method
				byte method = Option.chooseMethod();

				if (method == 1) {
					mt.runGaussElimination();
				} else {
					mt.runGaussJordanElimination();
				}

			} else { // Input From file
				File f = new File("tes.txt");
				int col=1, row=1;
				Scanner scan = null;
				try {
					scan = new Scanner(f);
					String str = scan.nextLine();
					for (int i=0; i<str.length(); i++) {
						if (str.charAt(i)==' ')
							col++;
					}
					while (scan.hasNextLine()) {
						scan.nextLine();
						row++;
					}
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					if (scan != null)
						scan.close();
				}
				MatAug mt = new MatAug(row, col);

				mt.fillUsingSPLFile();

				// Choosing method
				byte method = Option.chooseMethod();

				if (method == 1) {
					mt.runGaussElimination();
				} else {
					mt.runGaussJordanElimination();
				}
			}

		} else if (menu==2) { // Polynomial Interpolation
			byte input = Option.chooseInput();

			if (input == 1) { // Input from keyboard
				int n = in.nextInt();
				MatAug mt = new MatAug(n+1,n+2);
				mt.fillUsingPI();

				// Testing: display PI
				mt.printM();

				// Choose method
				byte method = Option.chooseMethod();

				if (method == 1) {
					mt.runGaussElimination();
				} else {
					mt.runGaussJordanElimination();
				}
			} else { // Input from file
				File f = new File("pi.txt"); // pi = polynomial interpolation
				int col=0, row=0;
				Scanner scan = null;
				try {
					scan = new Scanner(f);
					while (scan.hasNextLine()) {
						scan.nextLine();
						row++;
					}
					col = row+1;
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					if (scan != null)
						scan.close();
				}
				MatAug mt = new MatAug(row, col);

				mt.fillUsingPIFile();

				// Testing: Display MatAug
				mt.printM();

				// Choose method
				byte method = Option.chooseMethod();

				if (method == 1) {
					mt.runGaussElimination();
				} else {
					mt.runGaussJordanElimination();
				}
			}

		} else { // Exit
			System.out.println();
			for (int i=0; i<14; i++) {
				if (i==0)
					System.out.print('E');
				else if (i==1)
					System.out.print('X');
				else if (i==2)
					System.out.print('I');
				else if (i==3)
					System.out.print('T');
				else System.out.print('.');

				try {
					Thread.sleep(100);
				} catch(Exception e) {
					System.out.println(e);
					Thread.currentThread().interrupt();
				}
			}
			System.out.println();
			System.exit(0);
		}

		in.close();
	}
}