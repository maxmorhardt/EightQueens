package algorithms;

import java.util.List;
import application.Board;

/**
 * Class for the hill climbing algorithm
 * 
 * @author Max Morhardt
 */
public class HillClimbing extends Algorithm {
	
	private boolean randomRestart;
	private int numRestarts;
	
	public HillClimbing(boolean randomRestart) {
		this.randomRestart = randomRestart;
		numRestarts = 0;
	}

	@Override
	protected Board algorithm(Board b) {
		Board currBoard = b;
		while(true) {
			int currHeuristic = calculateHeuristic(b);
			List<Board> successors = generateSuccessors(currBoard);
			for (Board successor : successors) {
				int successorHeuristic = calculateHeuristic(successor);
				if (successorHeuristic == 0) {
					return successor;
				} else if (successorHeuristic < currHeuristic) {
					currBoard = successor;
					currHeuristic = successorHeuristic;
				}
			}
		}
	}
	
}
