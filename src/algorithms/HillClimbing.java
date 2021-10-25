package algorithms;

import java.util.List;
import application.Board;

/**
 * Class for the hill climbing algorithm
 * 
 * @author Max Morhardt
 */
public class HillClimbing extends Algorithm {
	
	// Variables
	private boolean randomRestart;
	private int numRestarts;
	
	/**
	 * Constructor for hill climbing with a random restart option
	 * 
	 * @param randomRestart
	 */
	public HillClimbing(boolean randomRestart) {
		super();
		this.randomRestart = randomRestart;
		numRestarts = 0;
	}

	@Override
	protected Board algorithm(Board b) {
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
			} else {
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
	
}
