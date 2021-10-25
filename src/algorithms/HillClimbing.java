package algorithms;

import java.util.ArrayList;
import java.util.List;
import application.Board;

/**
 * Class for the hill climbing algorithm
 * 
 * @author Max Morhardt
 */
public class HillClimbing {
	
	// Number of searches done to find a solution or fail
	private int searchCost;
	
	
	// Variables
	private boolean randomRestart;
	private int numRestarts;
	
	/**
	 * Constructor for hill climbing with a random restart option
	 * 
	 * @param randomRestart
	 */
	public HillClimbing(boolean randomRestart) {
		this.randomRestart = randomRestart;
		numRestarts = 0;
	}
	
	/**
	 * Calculates the pairs of queens in conflict
	 * (This should be protected, but I wanna test it and don't know how to do both)
	 * 
	 * @param board object
	 * @return heuristic
	 */
	public int calculateHeuristic(Board b) {
		int[] board = b.getBoard();
		int heuristic = 0;
		for (int i = 0; i < board.length-1; i++) {
			for (int j = i+1; j < board.length; j++) {
				// Checks diagonal
				if (board[j] - j == board[i] - i) {
					heuristic++;
				}
				// Checks diagonal
				if (board[j] + j == board[i] + i) {
					heuristic++;
				}
				// Checks row
				if (board[i] == board[j]) {
					heuristic++;
				}
			}
		}
		return heuristic;
	}
	
	/**
	 * Generates all successors for a given board
	 * 
	 * @param board object
	 * @return list of boards
	 */
	protected static List<Board> generateSuccessors(Board b) {
		int[] board = b.getBoard();
		List<Board> successors = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				Board successor = new Board(board);
				if (j != successor.getBoard()[i]) {
					successor.setQueen(i,j);
					successors.add(successor);
				}
			}
		}
		return successors;
	}
	
	/**
	 * Abstract method to solve the 8 queens given a specific algorithm
	 * 
	 * @param board object
	 * @return completed board or null
	 */
	public Board algorithm(Board b) {
		// Init board
		Board currBoard = b;
		// Runs until local min or a solution is reached
		while(true) {
			int currHeuristic = calculateHeuristic(b);
			List<Board> successors = generateSuccessors(currBoard);
			boolean isLocalMin = false;
			// Looks at all successors
			for (Board successor : successors) {
				int successorHeuristic = calculateHeuristic(successor);
				// Solution is found
				if (successorHeuristic == 0) {
					return successor;
				// If the successor is better than the current board
				} else if (successorHeuristic < currHeuristic) {
					currBoard = successor;
					currHeuristic = successorHeuristic;
					isLocalMin = true;
				} 
			}
			searchCost++;
			// No better successor was found with random restart
			if (!isLocalMin && randomRestart) {
				currBoard = new Board();
				numRestarts++;
			// No better successor was found without random restart
			} else if (!isLocalMin) {
				return currBoard;
			}
		}
	}
	
	/**
	 * Getter for the number of random restarts
	 * 
	 * @return number of restarts
	 */
	public int getNumRestarts() {
		return numRestarts;
	}
	
	/**
	 * Getter for the search cost
	 * 
	 * @return search cost
	 */
	public int getSearchCost() {
		return searchCost;
	}
	
}
