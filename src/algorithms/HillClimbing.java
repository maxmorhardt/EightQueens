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
	
	/**
	 * Calculates the pairs of queens in conflict
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
				if (j != successor.getBoard()[i]) {
					successor.setQueen(i,j);
					successors.add(successor);
				}
			}
		}
		return successors;
	}
	
	public void algorithm(Board b, boolean randomRestart) {
		
	}
	
}
