package project;

import java.util.Random;
import java.util.Scanner;

public class Game {

	int row, col, size, success = 0;

	// need two maps - one for base and one for the player
	int[][] gameMap;
	int[][] baseBoard;

	boolean gameOn = true;

	Scanner scan = new Scanner(System.in);
	Random random = new Random();

	// Constructor

	Game(int row, int col) {
		this.row = row;
		this.col = col;
		this.gameMap = new int[row][col];
		this.baseBoard = new int[row][col];
		this.size = row * col;
	}

	public void runGame() {
		// runs the game

		int r, c;
		// prepare the board
		mineField();
		// printBaseBoard(gameMap);
		System.out.println("Game Has Started!");
		while (gameOn) {
			printBaseBoard(baseBoard);
			System.out.print("Row: ");
			r = scan.nextInt();
			System.out.print("Col: ");
			c = scan.nextInt();

			if (r < 0 || c < 0 || r >= row || c >= col) {
				System.out.println("Undefined Coordinates! Try Again!");
				continue;
			}

			if (gameMap[r][c] != -1) {
				checkMine(r, c);
				success++;

				if (success == (size - (size / 4))) {
					System.out.println("You Won!");
					gameOn = false;
				}

			} else {
				System.out.println("Game Over!");
				printBaseBoard(gameMap);
				gameOn = false;
			}

		}

	}

	public void mineField() {
		// prepares the gameMap (mines)

		int randRow, randCol, count = 0;

		while (count != (size / 4)) {
			randRow = random.nextInt(row);
			randCol = random.nextInt(col);

			if (gameMap[randRow][randCol] != -1) {
				gameMap[randRow][randCol] = -1;
				count++;
			}

		}

	}

	public void printBaseBoard(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				if (arr[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(arr[i][j] + " ");

			}
			System.out.println();
		}

	}

	public void checkMine(int r, int c) {

		if (gameMap[r][c] == 0) {
			if ((c < col - 1) && (gameMap[r][c + 1] == -1)) {
				baseBoard[r][c]++;
			}

			if ((c > 0) && (gameMap[r][c - 1] == -1)) {
				baseBoard[r][c]++;

			}

			if ((r < row - 1) && (gameMap[r + 1][c] == -1)) {
				baseBoard[r][c]++;

			}

			if ((r > 0) && (gameMap[r - 1][c] == -1)) {
				baseBoard[r][c]++;

			}

			if ((r > 0 && c > 0) && (gameMap[r - 1][c - 1] == -1)) {
				baseBoard[r][c]++;

			}

			if (((c < col - 1) && (r < row - 1)) && (gameMap[r + 1][c + 1] == -1)) {
				baseBoard[r][c]++;

			}

			if ((c > 0 && (r < row - 1)) && (gameMap[r + 1][c - 1] == -1)) {
				baseBoard[r][c]++;

			}

			if ((r > 0 && (c < col - 1)) && (gameMap[r - 1][c + 1] == -1)) {
				baseBoard[r][c]++;

			}

			if (baseBoard[r][c] == 0) {
				baseBoard[r][c] = -2;
			}
		}

	}

}
