package algorithms;

import java.util.ArrayList;
import java.util.List;
import application.Board;

/**
 * Abstract class for each algorithm
 * 
 * @author Max Morhardt
 */
public abstract class Algorithm {
	
	// Number of searches done to find a solution or fail
	protected int searchCost;
	
	/**
	 * Constructor
	 */
	public Algorithm() {
		searchCost = 0;
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
	 * Getter for the search cost
	 * 
	 * @return search cost
	 */
	public int getSearchCost() {
		return searchCost;
	}
	
	/**
	 * Abstract method to solve the 8 queens given a specific algorithm
	 * 
	 * @param board object
	 * @return completed board or null
	 */
	protected abstract Board algorithm(Board b);
	
}