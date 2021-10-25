package application;

import java.util.Random;

/**
 * Creates the 8 Queens board
 * This board is a 1d array of the row position of each queen and the index is the column
 * 
 * @author Max Morhardt
 */
public class Board {
	
	// Constants
	private final int BOARD_SIZE = 8;
	private final int MAX_NUM_QUEENS = 8;
	
	// Variables
	private int[] board;
	
	/**
	 * Constructor for a completely new board
	 */
	public Board() {
		board = new int[BOARD_SIZE];
		addQueens();
	}
	
	/**
	 * Constructor given a board
	 */
	public Board(int[] board) {
		this.board = board;
	}
	
	/**
	 * Returns a random int inside of a certain range
	 * 
	 * @param min
	 * @param max
	 * @return random int in range
	 */
	private int getRandomNumber(int min, int max) {
	    Random rand = new Random();
	    return rand.nextInt(max - min) + min;
	}
	
	/**
	 * Adds all 8 queens to the board
	 */
	private void addQueens() {
		for (int col = 0; col < board.length; col++) {
			int row = getRandomNumber(0, MAX_NUM_QUEENS-1);
			board[col] = row;
		}
	}
	
	/**
	 * Setter for a specific queen
	 * 
	 * @param board
	 */
	public void setQueen(int col, int row) {
		board[col] = row;
	}
	
	/**
	 * Getter for the board
	 * 
	 * @return board
	 */
	public int[] getBoard() {
		return board.clone();
	}
	
	/**
	 * Prints the board
	 */
	public void printBoard() {
		int[][] fullBoard =  new int[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < fullBoard.length; i++) {
			fullBoard[board[i]][i] = 1;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (fullBoard[i][j] == 0) {
					System.out.print("-");
				}
				else {
					System.out.print("Q");
				}
			}
			System.out.println();
		}
	}
	
}
