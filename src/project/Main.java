package project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int row, col;

		System.out.println("Welcome to MineField!");
		System.out.println("Dimensions for your game: ");
		System.out.println("Rows: ");
		row = scan.nextInt();
		System.out.println("Cols: ");
		col = scan.nextInt();

		Game mine = new Game(row, col);

		mine.runGame();

		scan.close();

	}

}
