package chess;

import java.util.ArrayList;

public class ChessPlayer {
	//Brian A Lemes netid: bal160
	//Christopher H Gonzales netid: chg35
	String[][] testBoard = new String[9][9];
	
	ArrayList<Pawn> pawns = new ArrayList<Pawn>();
	ArrayList<Rook> rooks = new ArrayList<Rook>();
	ArrayList<Bishop> bishops = new ArrayList<Bishop>();
	ArrayList<Knight> knights = new ArrayList<Knight>();
	ArrayList<Queen> queens = new ArrayList<Queen>();
	
	int kingX;
	int kingY;
	
	
	public ChessPlayer(int player) {
		if(player == 1) {
			white();
		}
		else if(player == 2) {
			black();
		}
	}

	public void white() {
		this.kingX = 7;
		this.kingY = 4;
		
		
		for(int i = 0; i < 8; i++) {
			Pawn p1 = new Pawn(6, i, 1);
			pawns.add(p1);
		}
		
		Rook r1 = new Rook(7, 0, 1);
		Rook r2 = new Rook(7, 7, 1);
		rooks.add(r1);
		rooks.add(r2);
		
		Knight k1 = new Knight(7, 1, 1);
		Knight k2 = new Knight(7, 6, 1);
		knights.add(k1);
		knights.add(k2);
		
		Bishop b1 = new Bishop(7, 2, 1);
		Bishop b2 = new Bishop(7, 5, 1);
		bishops.add(b1);
		bishops.add(b2);
		
		Queen q = new Queen(7, 3, 1);
		queens.add(q);
	}
	
	public void black() {
		this.kingX = 0;
		this.kingY = 4;
		
		for(int i = 0; i < 8; i++) {
			Pawn p2 = new Pawn(1, i, 2);
			pawns.add(p2);
		}
		
		Rook r1 = new Rook (0, 0, 2);
		Rook r2 = new Rook(0, 7, 2);
		rooks.add(r1);
		rooks.add(r2);
		
		Knight k1 = new Knight(0, 1, 2);
		Knight k2 = new Knight(0, 6, 2);
		knights.add(k1);
		knights.add(k2);
		
		Bishop b1 = new Bishop(0, 2, 2);
		Bishop b2 = new Bishop(0, 5, 2);
		bishops.add(b1);
		bishops.add(b2);
		
		Queen q1 = new Queen(0, 3, 2);
		queens.add(q1);
	}
	
}
