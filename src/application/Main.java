package application;

/**
 * Main class
 * 
 * @author Max Morhardt
 */
public class Main {
	
	private static Board board;
	
	public static void main(String[] args) {
		board = new Board();
		board.printBoard();
	}
}
