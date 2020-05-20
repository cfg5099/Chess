package chess;

import java.util.ArrayList;

public class Pawn implements ChessPiece {
	//Brian A Lemes netid: bal160
	//Christopher H Gonzales netid: chg35
	ArrayList<GameMove> possibleMoves = new ArrayList<GameMove>();
	int currentX;
	int currentY;
	int whichPlayer;
	boolean inPlay = true;
	
	public Pawn(int currentX, int currentY, int whichPlayer) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.whichPlayer = whichPlayer;
	}

	@Override
	public void findValidMoves(String [][] copyBoard) {
		
		int x = this.currentX;
		int y = this.currentY;
		
		int foward1 = -1;
		int foward2 = -1;
		
		int takeX = -1;
		
		int take1Y = -1;
		int take2Y = -1;
		
		if(this.whichPlayer == 1) {
			
			foward1 = x - 1;
			
			if(x == 6) {
				foward2 = x - 2;
			}
			
			takeX = x - 1;
			
			take1Y = y - 1;
			take2Y = y + 1;
			
			//make sure we aren't out of bounds
			
			if(take2Y > 7) {
				take2Y = -1;
			}
			
			if(foward1 >= 0) {
				char c1 = copyBoard[foward1][y].charAt(0);
				if(c1 == ' ' || c1 == '#') {
					GameMove m1 = new GameMove(foward1, y);
					this.possibleMoves.add(m1);
				}
			}
			
			if(foward2 >= 0) {
				char c2 = copyBoard[foward2][y].charAt(0);
				if(c2 == ' ' || c2 == '#') {
					GameMove m2 = new GameMove(foward2, y);
					this.possibleMoves.add(m2);
				}
			}
			if(take1Y >= 0 && takeX >= 0) {
				char c3 = copyBoard[takeX][take1Y].charAt(0);
				if(c3 == 'b') {
					GameMove m3 = new GameMove(takeX, take1Y);
					this.possibleMoves.add(m3);
				}
			}
			if(take2Y >= 0 && takeX >= 0) {
				char c4 = copyBoard[takeX][take2Y].charAt(0);
				if(c4 == 'b') {
					GameMove m4 = new GameMove(takeX, take2Y);
					this.possibleMoves.add(m4);
				}
			}
			
		}
		
		else if(this.whichPlayer == 2) {
			
			foward1 = x + 1;
			
			if(x == 1) {
				foward2 = x + 2;
			}
			
			takeX = x + 1;
			
			take1Y = y - 1;
			take2Y = y + 1;
			
			//make sure we aren't out of bounds
			if(take2Y > 7) {
				take2Y = -1;
			}
			if(foward1 > 7) {
				foward1 = -1;
				takeX = -1;
				take1Y = -1;
				take2Y = -1;
			}
			
			if(foward1 >= 0) {
				char c1 = copyBoard[foward1][y].charAt(0);
				if(c1 == ' ' || c1 == '#') {
					GameMove m1 = new GameMove(foward1, y);
					this.possibleMoves.add(m1);
				}
			}
			
			if(foward2 >= 0) {
				char c2 = copyBoard[foward2][y].charAt(0);
				if(c2 == ' ' || c2 == '#') {
					GameMove m2 = new GameMove(foward2, y);
					this.possibleMoves.add(m2);
				}
			}
			if(take1Y >= 0 && takeX >= 0) {
				char c3 = copyBoard[takeX][take1Y].charAt(0);
				if(c3 == 'w') {
					GameMove m3 = new GameMove(takeX, take1Y);
					this.possibleMoves.add(m3);
				}
			}
			if(take2Y >= 0 && takeX >= 0) {
				char c4 = copyBoard[takeX][take2Y].charAt(0);
				if(c4 == 'w') {
					GameMove m4 = new GameMove(takeX, take2Y);
					this.possibleMoves.add(m4);
				}
			}
		}
		
	}
	
	public void enPassant(String[][] copyBoard) {
		
		if(Chess.enpassantX == -1 && Chess.enpassantY == -1) {
			return;
		}
		
		int row = this.currentX;
		int column = this.currentY;
		
		if(this.whichPlayer == 1) {
			if(column + 1  <= 7) {
				if(copyBoard[row][column + 1].equals("bp ")
				&& (Chess.enpassantX == row && Chess.enpassantY == column + 1)) {
					
					GameMove m1 = new GameMove(row - 1, column + 1);
					this.possibleMoves.add(m1);
					
				}
			}
			
			if(column - 1  >= 0) {
				if(copyBoard[row][column - 1].equals("bp ")
				&& (Chess.enpassantX == row && Chess.enpassantY == column - 1)) {
					
					GameMove m1 = new GameMove(row - 1, column - 1);
					this.possibleMoves.add(m1);
					
				}
			}
			
			
		}
		
		if(this.whichPlayer == 2) {
			if(column + 1  <= 7) {
				if(copyBoard[row][column + 1].equals("wp ")
				&& (Chess.enpassantX == row && Chess.enpassantY == column + 1)) {
					
					GameMove m1 = new GameMove(row + 1, column + 1);
					this.possibleMoves.add(m1);
					
				}
			}
			
			if(column - 1  >= 0) {
				if(copyBoard[row][column - 1].equals("wp ")
				&& (Chess.enpassantX == row && Chess.enpassantY == column - 1)) {
					
					GameMove m1 = new GameMove(row + 1, column - 1);
					this.possibleMoves.add(m1);
					
				}
			}
			
			
		}
		
	}
	


	@Override
	public int countValidMoves() {
		// TODO Auto-generated method stub
		return this.possibleMoves.size();
	}

}
