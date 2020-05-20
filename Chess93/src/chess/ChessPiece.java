package chess;

public interface ChessPiece {
	
	void findValidMoves(String[][] copyBoard);
	int countValidMoves();

	
}
