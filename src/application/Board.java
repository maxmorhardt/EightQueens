package application;

import java.util.Random;

/**
 * Creates the 8 Queens board
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
	 * Constructor no params
	 */
	public Board() {
		board = new int[BOARD_SIZE];
		addQueens();
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
	 * Setter for the board
	 * 
	 * @param board
	 */
	public void setBoard(int[] board) {
		this.board = board;
	}
	
	/**
	 * Getter for the board
	 * 
	 * @return board
	 */
	public int[] getBoard() {
		return board;
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
