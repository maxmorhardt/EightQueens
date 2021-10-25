package algorithms;

import java.util.List;
import application.Board;

/**
 * Class for the hill climbing algorithm
 * 
 * @author Max Morhardt
 */
public class HillClimbing extends Algorithm {
	
	// Variable for whether or not the algorithm was completed
	private boolean didSolve;
	
	/**
	 * Constructor for hill climbing with a random restart option
	 * 
	 * @param randomRestart
	 */
	public HillClimbing() {
		super();
		didSolve = false;
	}
	
	/**
	 * Solves the 8 queens with hill climbing
	 * 
	 * @param board object
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
					didSolve = true;
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
				continueSearch = false;
			}
		}
		return currBoard;
	}
	
	/**
	 * Getter for if the puzzle was solved
	 * @return did solve
	 */
	public boolean getDidSolve() {
		return didSolve;
	}
	
}
