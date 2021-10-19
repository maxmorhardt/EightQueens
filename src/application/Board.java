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
	private int[][] board;
	
	/**
	 * Constructor
	 */
	public Board() {
		board = new int[BOARD_SIZE][BOARD_SIZE];
		initBoard();
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
	 * Initializes the board
	 */
	private void initBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	/**
	 * Adds all 8 queens to the board
	 */
	private void addQueens() {
		for (int col = 0; col < MAX_NUM_QUEENS; col++) {
			int row = getRandomNumber(0, MAX_NUM_QUEENS-1);
			board[row][col] = 1;
		}
	}
	
	/**
	 * Setter for the board
	 * 
	 * @param board
	 */
	public void setBoard(int[][] board) {
		this.board = board;
	}
	
	/**
	 * Getter for the board
	 * 
	 * @return board
	 */
	public int[][] getBoard() {
		return board;
	}
	
	/**
	 * Prints the board
	 */
	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 0) {
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
