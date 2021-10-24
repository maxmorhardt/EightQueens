package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algorithms.HillClimbing;
import application.Board;

class Tests {

	@Test
	void testHeuristic1() {
		Board b = new Board();
		HillClimbing hc = new HillClimbing();
		b.setBoard(new int[] {4,5,6,3,4,5,6,5});
		System.out.println("Board 1");
		b.printBoard();
		System.out.println();
		int heuristic = hc.calculateHeuristic(b);
		assertEquals(heuristic, 17);
	}
	
	@Test
	void testHeuristic2() {
		Board b = new Board();
		HillClimbing hc = new HillClimbing();
		b.setBoard(new int[] {0,2,4,6,1,3,5,7});
		System.out.println("Board 2");
		b.printBoard();
		System.out.println();
		int heuristic = hc.calculateHeuristic(b);
		assertEquals(heuristic, 1);
	}

	@Test
	void testHeuristic3() {
		Board b = new Board();
		HillClimbing hc = new HillClimbing();
		b.setBoard(new int[] {3,7,0,4,6,1,5,2});
		System.out.println("Board 3");
		b.printBoard();
		System.out.println();
		int heuristic = hc.calculateHeuristic(b);
		assertEquals(heuristic, 0);
	}
	
}
