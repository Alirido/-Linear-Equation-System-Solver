import java.util.Scanner;

class DriverSPL {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Choose input:");
		System.out.println("1. Keyboard");
		System.out.println("2. Text file");
		byte input=0;
		while (input != 1 && input != 2) {
			input = 0;
			try {
				input = in.nextByte();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		if (input == 1) {
			System.out.println("Input from keyboard:)");
		} else System.out.println("Input from text file;)");

		in.close();
	}
}