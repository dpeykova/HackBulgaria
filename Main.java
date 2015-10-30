package task1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter coordinate X");
			int x = input.nextInt();
			System.out.println("Enter coordinate Y");
			int y = input.nextInt();
			System.out.println("Enter movement string");
			String move = input.next();

			if (move.isEmpty() || !move.matches("(>*v*<*\\^*~*)+")) {
				throw new IllegalArgumentException(
						"Invalid symbols in the given string");
			}
			
			logic(x, y, move);
		}

	}

	private static void logic(int x, int y, String move) {
		int invX = 1;
		int invY = 1;
		for (int i = 0; i < move.length(); i++) {
			char a = move.charAt(i);
			switch (a) {
			case '<':
				x -= (1 * invX);
				break;
			case '>':
				x += (1 * invX);
				break;
			case 'v':
				y -= (1 * invY);
				break;
			case '^':
				y += (1 * invY);
				break;
			case '~':
				if (i == move.length() - 1) {
					break;
				}
				if (move.charAt(i+1) == '<' || move.charAt(i+1) == '>') {
					invX *= -1;
					break;
				}
				if (move.charAt(i+1) == '^' || move.charAt(i+1) == 'V') {
					invY *= -1;
					break;
				}
			}
		}
		System.out.println("New Coordinates are(" + x + ", " + y + ");");
	}
}
