// This program demonstrates the usage of classes
// to simulate a game of Tic-Tac-Toe.
import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		// Configure the 2 players with X's and O's.
		GameInterface player = new GameInterface();
		int whichRow, whichCol, turnNumber = 1;
		// For the boolean variable, assume that the player tries
		// to make an invalid move. Use the do-while loop to keep
		// asking the player where to put the piece until the player
		// makes a valid move on the game board.
		boolean isValidMove = false;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Tic-Tac-Toe");
		System.out.println("======================");
		// For the modulus test, an odd number is Player 1's turn
		// and even number is Player 2's turn. Assume that it is
		// Player 1 who will go first.
		player.displayBoard();
		while (turnNumber < 10)
		{
			if (turnNumber % 2 == 1)
			{
				// Player 1's turn.
				System.out.println("Player 1 turn 'X'");
				do {
					System.out.println("Which Row would you like?");
					whichRow = input.nextInt();
					System.out.println("Which Col would you like?");
					whichCol = input.nextInt();
					isValidMove = player.placePiece(whichRow, whichCol, 'X');
				} while (isValidMove != true);
				player.displayBoard();
				// Check if player 1 has 3 in a row.
				if (player.checkRow('X'))
				{
					System.out.println("X Player Wins!");
					System.exit(0);
				}
			}
			else
			{
				// Player 2's turn.
				System.out.println("Player 2 turn 'O'");
				do {
					System.out.println("Which Row would you like?");
					whichRow = input.nextInt();
					System.out.println("Which Col would you like?");
					whichCol = input.nextInt();
					isValidMove = player.placePiece(whichRow, whichCol, 'O');
				} while (isValidMove != true);
				player.displayBoard();
				// Check if player 2 has 3 in a row.
				if (player.checkRow('O'))
				{
					System.out.println("O Player Wins!");
					System.exit(0);
				}
			}
			turnNumber++;
		}
		// Print this message only if the game is a tie.
		System.out.println("Cat's game!");
	}
}