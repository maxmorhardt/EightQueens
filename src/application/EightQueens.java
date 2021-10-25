package application;

import java.util.Scanner;
import algorithms.HillClimbing;

/**
 * Main class that solves the puzzle
 * 
 * @author Max Morhardt
 */
public class EightQueens {
	
	private int numPuzzles;
	private int visualizeBoards;
	
	private void getUserInput() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many puzzles would you like to solve?");
		numPuzzles = in.nextInt();
		
		System.out.println("\nWould you like to visualize the initial and final boards?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		visualizeBoards = in.nextInt();
		
	}
	
	private void runProgram() {
		getUserInput();
		int counter = 1;
		
		double searchCostTotal = 0;
		double numPassed = 0;
		
		while(numPuzzles > 0) {
			Board initialBoard = new Board();
			HillClimbing hc = new HillClimbing();
			Board finalBoardNoRestart = hc.solve(initialBoard);
			if (hc.getDidSolve()) {
				numPassed++;
			}
			searchCostTotal += hc.getSearchCost();
			
			if (visualizeBoards == 1) {
				System.out.println();
				System.out.println(counter);
				System.out.println("Initial no restart");
				initialBoard.printBoard();
				
				System.out.println();
				System.out.println("Final no restart");
				finalBoardNoRestart.printBoard();
				System.out.println();
				System.out.println("-------------------------------------");

				/*
				System.out.println();
				System.out.println("Final with restart");
				finalBoardWithRestart.printBoard();
				System.out.println();
				System.out.println("-------------------------------------");
				*/
				
				counter++;
			}
			numPuzzles--;
		} // End loop
		
		double passRate = 100*(double)(numPassed/counter);
		double averageSearch = (double)(searchCostTotal/counter);
		System.out.println(counter + " Puzzles");
		System.out.println("Hill Climbing: " + passRate + "% solve, average search cost: " + averageSearch);
		
	}
	
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		new EightQueens().runProgram();
	}
	
}
