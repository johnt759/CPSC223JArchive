public class GameInterface {
	private char[][] board;
	private final int ROWS = 3;
	private final int COLS = 3;
	
	public GameInterface()
	{
		board = new char[ROWS][COLS];	// Initialize a new 3x3 board
		for (int i = 0; i < ROWS; i++)	// Set empty spaces for the board
		{
			for (int j = 0; j < COLS; j++)
			{
				board[i][j] = ' ';
			}
		}
	}
	
	public void displayBoard()
	{
		// Display the board of tic-tac-toe.
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLS; j++)
			{
				System.out.print(board[i][j]);
				if (j != COLS - 1)
				{
					System.out.print("|");
				}
			}
			System.out.println();
			if (i != ROWS - 1)
			{
				System.out.println("-----");
			}
		}
		System.out.println();
	}
	
	public boolean placePiece(int row, int col, char piece)
	{
		// First, check whether the chosen space already
		// has a piece. If true, display error message and
		// put the piece in the new space otherwise.
		if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == ' ')
		{
			board[row][col] = piece;
			return true;
		}
		else
		{
			System.out.println("Invalid move.");
			return false;
		}
	}
	
	public boolean checkRow(char winningPiece)
	{
		// Look through each array and decide if any of the three
		// arrays match. Return true to indicate someone has won
		// and false to indicate the game is still in progress.
		if ((winningPiece == board[0][0] && winningPiece == board[0][1] && winningPiece == board[0][2])
		|| (winningPiece == board[1][0] && winningPiece == board[1][1] && winningPiece == board[1][2])
		|| (winningPiece == board[2][0] && winningPiece == board[2][1] && winningPiece == board[2][2])
		|| (winningPiece == board[0][0] && winningPiece == board[1][0] && winningPiece == board[2][0])
		|| (winningPiece == board[0][1] && winningPiece == board[1][1] && winningPiece == board[2][1])
		|| (winningPiece == board[0][2] && winningPiece == board[1][2] && winningPiece == board[2][2])
		|| (winningPiece == board[0][0] && winningPiece == board[1][1] && winningPiece == board[2][2])
		|| (winningPiece == board[0][2] && winningPiece == board[1][1] && winningPiece == board[2][0]))
		{
			return true;
		}		
		return false;
	}
}