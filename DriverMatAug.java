import java.util.Scanner;
import java.lang.*;

public class DriverMatAug {

	// public byte chooseMenu() {
	// 	// MENU 
	// 	System.out.println("MENU");
	// 	System.out.println("1. Linear Equation System");
	// 	System.out.println("2. Polynomial Interpolation");
	// 	System.out.println("3. Exit");
	// 	System.out.print("Select menu: ");
	// 	Scanner in = new Scanner(System.in);

	// 	while (!in.hasNextByte()) {
	// 		System.out.println();
	// 		System.out.println("Invalid input. Please enter 1, 2 or 3 for your choice!");				
	// 		in.next();
	// 		System.out.println();
	// 		System.out.print("Select menu: ");
	// 	}

	// 	byte menu = in.nextByte();

	// 	while (menu!=1 && menu!=2 && menu!=3) {
	// 		System.out.println();
	// 		System.out.println("Invalid input. Please enter 1, 2 or 3 for your choice!");
	// 		System.out.println();
	// 		System.out.print("Select menu: ");

	// 		while (!in.hasNextByte()) {
	// 			System.out.println();
	// 			System.out.println("Invalid input. Please enter 1, 2 or 3 for your choice!");				
	// 			in.next();
	// 			System.out.println();
	// 			System.out.print("Enter your choice: ");
	// 		}

	// 		menu = in.nextByte();
	// 	}

	// 	in.close();
	// 	return menu;
	// }

	// public byte chooseInput() {
	// 	// Choosing input option
	// 	System.out.println("Choose input:");
	// 	System.out.println("1. Keyboard");
	// 	System.out.println("2. Text file");
	// 	System.out.print("Enter your choice: ");
	// 	Scanner in = new Scanner(System.in);

	// 	while (!in.hasNextByte()) {
	// 		System.out.println();
	// 		System.out.println("Invalid input. Please enter 1 or 2 for your choice!");				
	// 		in.next();
	// 		System.out.println();
	// 		System.out.print("Enter your choice: ");
	// 	}

	// 	byte input = in.nextByte();

	// 	while (input!=1 && input!=2) {
	// 		System.out.println();
	// 		System.out.println("Invalid input. Please enter 1 or 2 for your choice!");
	// 		System.out.println();
	// 		System.out.print("Enter your choice: ");

	// 		while (!in.hasNextByte()) {
	// 			System.out.println();
	// 			System.out.println("Invalid input. Please enter 1 or 2 for your choice!");				
	// 			in.next();
	// 			System.out.println();
	// 			System.out.print("Enter your choice: ");
	// 		}

	// 		input = in.nextByte();
	// 	}

	// 	in.close();
	// 	return input;
	// }

	public static void main(String[] args) {

		// Loading segment
		System.out.println();
		System.out.println();
		System.out.print("\t");
		for (int i=0; i<50; i++) {
			System.out.print('~');

			try {
				Thread.sleep(40);
			} catch(Exception e) {
				System.out.println(e);
				Thread.currentThread().interrupt();
			}
		}
		System.out.println();

		// byte menu = this.chooseMenu();
		// MENU 
		System.out.println("MENU");
		System.out.println("1. Linear Equation System");
		System.out.println("2. Polynomial Interpolation");
		System.out.println("3. Exit");
		System.out.print("Select menu: ");
		Scanner in = new Scanner(System.in);

		while (!in.hasNextByte()) {
			System.out.println();
			System.out.println("Invalid input. Please enter 1, 2 or 3 for your choice!");				
			in.next();
			System.out.println();
			System.out.print("Select menu: ");
		}

		byte menu = in.nextByte();

		while (menu!=1 && menu!=2 && menu!=3) {
			System.out.println();
			System.out.println("Invalid input. Please enter 1, 2 or 3 for your choice!");
			System.out.println();
			System.out.print("Select menu: ");

			while (!in.hasNextByte()) {
				System.out.println();
				System.out.println("Invalid input. Please enter 1, 2 or 3 for your choice!");				
				in.next();
				System.out.println();
				System.out.print("Enter your choice: ");
			}

			menu = in.nextByte();
		}
		System.out.println();

		if (menu==1) {
			// byte input = chooseInput();
			// Choosing input option
			System.out.println("Input Option");
			System.out.println("1. Keyboard");
			System.out.println("2. Text file");
			System.out.print("Select input: ");
	
			while (!in.hasNextByte()) {
				System.out.println();
				System.out.println("Invalid input. Please enter 1 or 2 for your choice!");				
				in.next();
				System.out.println();
				System.out.print("Select input: ");
			}
			byte input = in.nextByte();
			while (input!=1 && input!=2) {
				System.out.println();
				System.out.println("Invalid input. Please enter 1 or 2 for your choice!");
				System.out.println();
				System.out.print("Select input: ");

				while (!in.hasNextByte()) {
					System.out.println();
					System.out.println("Invalid input. Please enter 1 or 2 for your choice!");				
					in.next();
					System.out.println();
					System.out.print("Select input: ");
				}
				input = in.nextByte();
			}

			if (input == 1) {
				int m = in.nextInt(), n = in.nextInt();
				MatAug mt = new MatAug(m,n);
				mt.fillUsingSPL(m,n);

				// Testing: display matrix augmented from input keyboard
				for (int i=0; i<m; i++) {
					for (int j=0; j<=n; j++) {
						System.out.print(mt.get(i,j) + " ");
					}
					System.out.println();
				}
			} else {
				// Input From file
			}

		} else if (menu==2) {
			// byte input = chooseInput();

		} else {
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

		/*
		System.out.println("Enter the size of matrix augmented:")
		int m=in.nextInt(),n=in.nextInt();
		System.out.println("Enter the matrix augmented:");
		*/

		// if (input == 1) {
		// 	System.out.println("Input from keyboard:)");
			
		// } else System.out.println("Input from text file;)");

		// in.close();
	}
}