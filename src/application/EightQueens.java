package application;

import java.util.InputMismatchException;
import java.util.Scanner;
import algorithms.HillClimbing;

/**
 * Main class that solves the puzzle
 * 
 * @author Max Morhardt
 */
public class EightQueens {
	
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		Board initialBoard = new Board();
		HillClimbing hc = new HillClimbing(false);
		initialBoard.printBoard();
		System.out.println();
		Board finalBoard = hc.algorithm(initialBoard);
		finalBoard.printBoard();
		System.out.println();
		System.out.println(hc.calculateHeuristic(finalBoard));
	}
}
