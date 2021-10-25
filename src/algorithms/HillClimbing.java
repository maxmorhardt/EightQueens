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
	//private int searchCost;
	
	
	// Variables
	//private boolean randomRestart;
	//private int numRestarts;
	
	/**
	 * Constructor for hill climbing with a random restart option
	 * 
	 * @param randomRestart
	 */
	public HillClimbing(boolean randomRestart) {
		//this.randomRestart = randomRestart;
		//numRestarts = 0;
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
	private static List<Board> generateSuccessors(Board b) {
		int[] board = b.getBoard();
		List<Board> successors = new ArrayList<>();
		for (int i = 0; i < board.length; i++) { 
			for (int j = 0; j < board.length; j++) {
				Board successor = new Board(board);
				if () {
					successor.setQueen(i, j);
					successors.add(successor);
				}
			}
		}
		System.out.println(successors.size());
		return successors;
	}
	
	public void successorTest() {
		Board b = new Board(new int[] {1,1,1,1,1,1,1,1});
		List<Board> successors = generateSuccessors(b);
		//successors.get(55).printBoard();
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
		boolean continueSearch = true;
		while(continueSearch) {
			int currHeuristic = calculateHeuristic(b);
			List<Board> successors = generateSuccessors(currBoard);
			// Looks at all successors
			for (Board successor : successors) {
				int successorHeuristic = calculateHeuristic(successor);
				// Solution is found
				if (successorHeuristic == 0) {
					continueSearch = false;
				// If the successor is better than the current board
				} else if (successorHeuristic < currHeuristic) {
					currBoard = successor;
					currHeuristic = successorHeuristic;
				} 
			}
		}
		return null;
	}
	
}
