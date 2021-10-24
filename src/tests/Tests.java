package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algorithms.HillClimbing;
import application.Board;

class Tests {
	
	
	HillClimbing hc = new HillClimbing();
	
	/**
	 * All heuristic tests were calculated manually
	 */
	@Test
	void testHeuristic1() {
		Board b = new Board(new int[] {0,0,0,0,0,0,0,0});
		int heuristic = hc.calculateHeuristic(b);
		System.out.println("Board 1 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, 28);
	}
	
	@Test
	void testHeuristic2() {
		Board b = new Board(new int[] {0,1,2,3,4,5,6,7});
		int heuristic = hc.calculateHeuristic(b);
		System.out.println("Board 2 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, 28);
	}
	
	@Test
	void testHeuristic3() {
		Board b = new Board(new int[] {7,6,5,4,3,2,1,0});
		int heuristic = hc.calculateHeuristic(b);
		System.out.println("Board 3 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, 28);
	}

	@Test
	void testHeuristic4() {
		Board b = new Board(new int[] {4,5,6,3,4,5,6,5});
		int heuristic = hc.calculateHeuristic(b);
		System.out.println("Board 4 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, 17);
	}
	
	@Test
	void testHeuristic5() {
		Board b = new Board(new int[] {0,2,4,6,1,3,5,7});
		int heuristic = hc.calculateHeuristic(b);
		System.out.println("Board 5 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, 1);
	}

	@Test
	void testHeuristic6() {
		Board b = new Board(new int[] {3,7,0,4,6,1,5,2});
		int heuristic = hc.calculateHeuristic(b);
		System.out.println("Board 6 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, 0);
	}
	
	@Test
	void testHeuristic7() {
		Board b = new Board(new int[] {1,3,5,7,0,2,4,6});
		int heuristic = hc.calculateHeuristic(b);
		System.out.println("Board 7 - h:" + heuristic);
		b.printBoard();
		System.out.println();
		assertEquals(heuristic, 3);
	}
	
}
