package application;

import java.util.Scanner;
import algorithms.HillClimbing;
import algorithms.HillClimbingRandomRestart;

/**
 * Main class that solves the puzzle
 * 
 * @author Max Morhardt
 */
public class EightQueens {
	
	/**
	 * Gets user input
	 */
	private int[] getUserInput() {
		int[] input = new int[2];
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many puzzles would you like to solve?");
		input[0] = in.nextInt();
		
		System.out.println("\nWould you like to visualize the initial and final boards?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		input[1] = in.nextInt();
		
		in.close();
		return input;
		
	}
	
	/**
	 * Runs the program
	 */
	private void runProgram() {
		// Get the input
		int[] input = getUserInput();
		int numPuzzles = input[0];
		int visualizeBoards = input[1];
		
		// Variables for statistics
		double puzzleCounter = 1;
		double searchCostTotal = 0;
		double numPassed = 0;
		double searchCostTotalWithRestart = 0;
		double totalRestarts = 0;
		
		// Runs the algorithms numPuzzles times
		while(puzzleCounter <= numPuzzles) {
			// Init board
			Board initialBoard = new Board();
			
			// Hill climbing
			HillClimbing hc = new HillClimbing();
			Board finalBoardNoRestart = hc.solve(initialBoard);
			if (hc.getDidSolve()) {
				numPassed++;
			}
			searchCostTotal += hc.getSearchCost();
			
			// Hill climbing with restart
			HillClimbingRandomRestart hcrr = new HillClimbingRandomRestart();
			Board finalBoardWithRestart = hcrr.solve(initialBoard);
			searchCostTotalWithRestart += hcrr.getSearchCost();
			totalRestarts += hcrr.getnumRestarts();
			
			// Board visualization
			if (visualizeBoards == 1) {
				// Initial board
				System.out.println();
				System.out.println(puzzleCounter);
				System.out.println("Initial no restart");
				initialBoard.printBoard();
				
				// Final without restart
				System.out.println();
				System.out.println("Final no restart");
				finalBoardNoRestart.printBoard();
				System.out.println();
				
				// Final with restart
				System.out.println();
				System.out.println("Final with restart");
				finalBoardWithRestart.printBoard();
				System.out.println();
				System.out.println("-------------------------------------");
			}
			puzzleCounter++;
		}
		
		// Prints statistics
		double passRate = 100*(numPassed/numPuzzles);
		double averageSearch = searchCostTotal/numPuzzles;
		double averageSearchWithRestart = searchCostTotalWithRestart/numPuzzles;
		double averageRestarts = totalRestarts/numPuzzles;
		
		System.out.println();
		System.out.println(numPuzzles + " Puzzles");
		System.out.println("Hill Climbing: " + passRate + "% solved, average search cost: " + averageSearch);
		System.out.println("Hill Climbing Random Restart: average restarts: " + averageRestarts + ", average search cost: " + averageSearchWithRestart);
		
	}
	
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		new EightQueens().runProgram();
	}
	
}
