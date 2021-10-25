package algorithms;

import java.util.List;

import application.Board;

public class HillClimbingRandomRestart extends Algorithm {
	
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
			if (isLocalMin) {
				//didSolve = false;
				continueSearch = false;
			}
		}
		return currBoard;
	}
}
