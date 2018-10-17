import java.util.Scanner;

public class Option {

	public static byte chooseMenu() {
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
				System.out.print("Select menu: ");
			}

			menu = in.nextByte();
		}

		// in.close();
		return menu;
	}

	public static byte chooseInput() {
		// Choosing input option
		System.out.println("Input Option");
		System.out.println("1. Keyboard");
		System.out.println("2. Text file");
		System.out.print("Select input: ");
		Scanner in = new Scanner(System.in);

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

		// in.close();
		return input;
	}

	public static byte chooseMethod() {
		// Choosing method
		System.out.println("Method Option");
		System.out.println("1. Gauss Elimination");
		System.out.println("2. Gauss-Jordan Elimination");
		System.out.print("Select method: ");
		Scanner in = new Scanner(System.in);

		while (!in.hasNextByte()) {
			System.out.println();
			System.out.println("Invalid input. Please enter 1 or 2 for your choice!");				
			in.next();
			System.out.println();
			System.out.print("Select method: ");
		}

		byte method = in.nextByte();

		while (method!=1 && method!=2) {
			System.out.println();
			System.out.println("Invalid input. Please enter 1 or 2 for your choice!");
			System.out.println();
			System.out.print("Select method: ");

			while (!in.hasNextByte()) {
				System.out.println();
				System.out.println("Invalid input. Please enter 1 or 2 for your choice!");				
				in.next();
				System.out.println();
				System.out.print("Select method: ");
			}

			method = in.nextByte();
		}

		// in.close();
		return method;
	}
}