package application;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class that solves the puzzle
 * 
 * @author Max Morhardt
 */
public class EightQueens {
	
	// Constants
	private final int HILL_CLIMBING = 1;
	private final int HILL_CLIMBING_RESTART = 2;
	private final int DONT_SHOW_BOARD = 1;
	private final int SHOW_BOARD = 1;
	private final int ERROR = -1;
	private final int NUM_PUZZLES_INDEX = 0;
	private final int ALGORITHM_INDEX = 1;
	private final int BOARD_PREFERENCE_INDEX = 2;
	
	// Number of puzzles to be solved
	private int numPuzzles;
	
	private int getNumPuzzles() {
		try {
			Scanner in = new Scanner(System.in); 
			System.out.println("How many puzzles would you like to solve?");
			int numPuzzles = in.nextInt();
			return numPuzzles;
		} catch (InputMismatchException e) {
			return ERROR;
		}
	}
	
	/**
	 * Gets which algorithm the user would like to use
	 * 
	 * @return algorithm corresponding to an int
	 */
	private int getAlgorithm() {
		try {
			Scanner in = new Scanner(System.in); 
			System.out.println("Which algorithm would you like?");
			System.out.println("1. Hill Climbing");
			System.out.println("2. Hill Climbing (Random Restart)");
			int algorithm = in.nextInt();
			if (algorithm != HILL_CLIMBING || algorithm != HILL_CLIMBING_RESTART) {
				return ERROR;
			}
			return algorithm;
		} catch (InputMismatchException e) {
			return ERROR;
		}
	}
	
	/**
	 * Gets whether or not they would like initial and final board shown
	 * 
	 * @return algorithm corresponding to an int
	 */
	private int getBoardPrefernence() {
		try {
			Scanner in = new Scanner(System.in); 
			System.out.println("Would you like to see the initial board and solution?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int algorithm = in.nextInt();
			if (algorithm != DONT_SHOW_BOARD || algorithm != SHOW_BOARD) {
				return ERROR;
			}
			return algorithm;
		} catch (InputMismatchException e) {
			return ERROR;
		}
	}
	
	/**
	 * Gets all user input
	 * 
	 * @return array of the number of puzzles and which algorithm
	 */
	private int[] getInput() {
		int[] input = new int[3];
		
		// Gets puzzles
		int numPuzzles = getNumPuzzles();
		while (numPuzzles == ERROR) {
			System.out.println("Please enter a number");
		}
		input[NUM_PUZZLES_INDEX] = numPuzzles;
		
		// Gets algorithm
		int algorithm = getAlgorithm();
		while (algorithm == ERROR) {
			System.out.println("Please enter 1 or 2");
		}
		input[ALGORITHM_INDEX] = algorithm;
		
		// Gets board preference
		int boardPreference = getBoardPrefernence();
		while (boardPreference == ERROR) {
			System.out.println("Please enter 1 or 2");
		}
		input[BOARD_PREFERENCE_INDEX] = boardPreference;
		
		return input;
		
	}
	
	private void solve() {
		Board b = new Board();
	}
	
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		
	}
}
