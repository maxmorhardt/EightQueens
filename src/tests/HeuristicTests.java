package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import algorithms.HillClimbing;
import application.Board;

/**
 * Tests for the heuristic calculation
 * 
 * @author Max Morhardt
 */
class HeuristicTests {
	
	HillClimbing hc = new HillClimbing();
	
	/**
	 * All heuristic tests were calculated manually
	 */
	@Test
	void testHeuristic1() {
		Board b = new Board(new int[] {0,0,0,0,0,0,0,0});
		int heuristic = hc.calculateHeuristic(b);
		int expectedHeuristic = 28;
		System.out.println("Board 1 - h:" + expectedHeuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, expectedHeuristic);
	}
	
	@Test
	void testHeuristic2() {
		Board b = new Board(new int[] {0,1,2,3,4,5,6,7});
		int heuristic = hc.calculateHeuristic(b);
		int expectedHeuristic = 28;
		System.out.println("Board 2 - 28:" + expectedHeuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, expectedHeuristic);
	}
	
	@Test
	void testHeuristic3() {
		Board b = new Board(new int[] {7,6,5,4,3,2,1,0});
		int heuristic = hc.calculateHeuristic(b);
		int expectedHeuristic = 28;
		System.out.println("Board 3 - h:" + expectedHeuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, expectedHeuristic);
	}

	@Test
	void testHeuristic4() {
		Board b = new Board(new int[] {4,5,6,3,4,5,6,5});
		int heuristic = hc.calculateHeuristic(b);
		int expectedHeuristic = 17;
		System.out.println("Board 4 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, expectedHeuristic);
	}
	
	@Test
	void testHeuristic5() {
		Board b = new Board(new int[] {0,2,4,6,1,3,5,7});
		int heuristic = hc.calculateHeuristic(b);
		int expectedHeuristic = 1;
		System.out.println("Board 5 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, expectedHeuristic);
	}

	@Test
	void testHeuristic6() {
		Board b = new Board(new int[] {3,7,0,4,6,1,5,2});
		int heuristic = hc.calculateHeuristic(b);
		int expectedHeuristic = 0;
		System.out.println("Board 6 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, expectedHeuristic);
	}
	
	@Test
	void testHeuristic7() {
		Board b = new Board(new int[] {1,3,5,7,0,2,4,6});
		int heuristic = hc.calculateHeuristic(b);
		int expectedHeuristic = 3;
		System.out.println("Board 7 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, expectedHeuristic);
	}
	
}
