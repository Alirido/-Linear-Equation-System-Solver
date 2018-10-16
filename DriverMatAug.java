import java.util.Scanner;

class DriverMatAug {
	public static void main(String[] args) {

		// Loading segment
		System.out.println();
		System.out.println();
		System.out.print("\t");
		for (int i=0; i<50; i++) {
			System.out.print('~');

			try {
				Thread.sleep(50);
			} catch(Exception e) {
				System.out.println(e);
				Thread.currentThread().interrupt();
			}
		}
		System.out.println();

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
			System.out.println("Invalid input. Please enter 1 or 2 for your choice!");
			System.out.println();
			System.out.print("Selext menu: ");

			while (!in.hasNextByte()) {
				System.out.println();
				System.out.println("Invalid input. Please enter 1 or 2 for your choice!");				
				in.next();
				System.out.println();
				System.out.print("Enter your choice: ");
			}

			menu = in.nextByte();
		}

		if (menu==1) {

		} else if (menu==2) {

		} else {
			
		}

		/*
		System.out.println("Enter the size of matrix augmented:")
		int m=in.nextInt(),n=in.nextInt();
		System.out.println("Enter the matrix augmented:");
		*/
		// Choosing input option
		System.out.println("Choose input:");
		System.out.println("1. Keyboard");
		System.out.println("2. Text file");
		System.out.print("Enter your choice: ");

		while (!in.hasNextByte()) {
			System.out.println();
			System.out.println("Invalid input. Please enter 1 or 2 for your choice!");				
			in.next();
			System.out.println();
			System.out.print("Enter your choice: ");
		}

		byte input = in.nextByte();

		while (input!=1 && input!=2) {
			System.out.println();
			System.out.println("Invalid input. Please enter 1 or 2 for your choice!");
			System.out.println();
			System.out.print("Enter your choice: ");

			while (!in.hasNextByte()) {
				System.out.println();
				System.out.println("Invalid input. Please enter 1 or 2 for your choice!");				
				in.next();
				System.out.println();
				System.out.print("Enter your choice: ");
			}

			input = in.nextByte();
		}
		// while (input != 1 && input != 2) {
		// 	input = 0;
		// 	try {
		// 		input = in.nextByte();
		// 	} catch (Exception e) {
		// 		System.out.println(e);
		// 	}
		// }
		if (input == 1) {
			System.out.println("Input from keyboard:)");

			
		} else System.out.println("Input from text file;)");

		in.close();
	}
}