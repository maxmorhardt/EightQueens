package algorithms;

import java.util.List;

import application.Board;

/**
 * Class for the hill climbing algorithm using random restarts
 * 
 * @author Max Morhardt
 */
public class HillClimbingRandomRestart extends Algorithm {
	
	// Number of restarts
	private int numRestarts;
	
	/**
	 * Constructor
	 */
	public HillClimbingRandomRestart() {
		numRestarts = 0;
	}
	
	/**
	 * Solves the 8 queens with hill climbing and random restarts
	 * 
	 * @param board
	 * @return final board
	 */
	public Board solve(Board b) {
		// Init board
		Board currBoard = b;
		
		// Runs until local min or a solution is reached
		boolean continueSearch = true;
		while(continueSearch) {
			int currHeuristic = calculateHeuristic(currBoard);
			boolean isLocalMin = true;
			List<Board> successors = generateSuccessors(currBoard);
			
			// Looks at all successors
			for (Board successor : successors) {
				searchCost++;
				int successorHeuristic = calculateHeuristic(successor);
				
				// Solution is found
				if (successorHeuristic == 0) {
					currBoard = successor;
					currHeuristic = successorHeuristic;
					continueSearch = false;
					
				// If the successor is better than the current board
				} else if (successorHeuristic < currHeuristic) {
					currBoard = successor;
					currHeuristic = successorHeuristic;
					isLocalMin = false;
				} 
			} 
			// If all successors heuristics are >= the current
			if (isLocalMin && continueSearch) {
				numRestarts++;
				currBoard = new Board();
			}
		}
		return currBoard;
	}
	
	/**
	 * Getter for the number of random restarts done
	 * 
	 * @return number of restarts
	 */
	public int getnumRestarts() {
		return numRestarts;
	}
	
}
