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


		
		// Choosing input option
		Scanner in = new Scanner(System.in);
		System.out.println("Choose input:");
		System.out.println("1. Keyboard");
		System.out.println("2. Text file");
		byte input=0;
		System.out.print("Enter your choice: ");

		while (!in.hasNextByte()) {
			System.out.println();
			System.out.println("Invalid input. Please enter 1 or 2 for your choice!");				
			in.next();
			System.out.println();
			System.out.print("Enter your choice: ");
		}

		input = in.nextByte();

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