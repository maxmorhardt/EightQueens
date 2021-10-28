package algorithms;

import java.util.ArrayList;
import java.util.List;
import application.Board;

/**
 * Abstract class for an algorithm
 * 
 * @author Max Morhardt
 */
public abstract class Algorithm {
	
	// Search cost needed to solve
	protected int searchCost;
	
	/**
	 * Constructor
	 */
	protected Algorithm() {
		searchCost = 0;
	}
	
	/**
	 * Calculates the pairs of queens in conflict
	 * (This should be protected, but I wanna test it and don't know how to do both)
	 * 
	 * @param board
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
	 * @param board
	 * @return list of boards
	 */
	protected List<Board> generateSuccessors(Board b) {
		int[] board = b.getBoard();
		List<Board> successors = new ArrayList<>();
		for (int col = 0; col < b.getBoard().length; col++) { 
			for (int row = 0; row < b.getBoard().length; row++) {
				if (board[col] != row) {
					Board successor = new Board(b.getBoard());
					successor.setQueen(col, row);
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
	 * Abstract method for each algorithm to solve the puzzle
	 * 
	 * @param board
	 * @return solved board
	 */
	public abstract Board solve(Board b);

}
