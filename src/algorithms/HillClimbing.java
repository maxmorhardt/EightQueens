package algorithms;

import java.util.List;
import application.Board;

/**
 * Class for the hill climbing algorithm
 * 
 * @author Max Morhardt
 */
public class HillClimbing extends Algorithm {
	
	
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
		while(true) {
			int currHeuristic = calculateHeuristic(currBoard);
			boolean isLocalMin = true;
			List<Board> successors = generateSuccessors(currBoard);
			
			// Looks at all successors
			for (Board successor : successors) {
				int successorHeuristic = calculateHeuristic(successor);
				// Solution is found
				if (successorHeuristic == 0) {
					currBoard = successor;
					currHeuristic = successorHeuristic;
					didSolve = true;
					break;
					
				// If the successor is better than the current board
				} else if (successorHeuristic < currHeuristic) {
					currBoard = successor;
					currHeuristic = successorHeuristic;
					isLocalMin = false;
				} 
				searchCost++;
			} 
			// If all successors heuristics are >= the current
			if (isLocalMin) {
				break;
			}
		}
		return currBoard;
	}
	
	public boolean getDidSolve() {
		return didSolve;
	}
	
}
