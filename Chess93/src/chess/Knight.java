package chess;

import java.util.ArrayList;

public class Knight implements ChessPiece {
	//Brian A Lemes netid: bal160
	//Christopher H Gonzales netid: chg35

	ArrayList<GameMove> possibleMoves = new ArrayList<GameMove>();
	int currentX;
	int currentY;
	int whichPlayer;
	boolean inPlay = true;
	
	public Knight(int currentX, int currentY, int whichPlayer) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.whichPlayer = whichPlayer;
	}

	@Override
	public void findValidMoves(String[][] copyBoard) {
		int row = this.currentX;
		int column = this.currentY;
		
		
		if( (row - 2) >= 0 && column + 1 <= 7) {
			char c1 = copyBoard[(row - 2)][(column + 1)].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m1 = new GameMove(row - 2, column + 1);
				this.possibleMoves.add(m1);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m2 = new GameMove(row - 2, column + 1);
					this.possibleMoves.add(m2);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m3 = new GameMove(row - 2, column + 1);
					this.possibleMoves.add(m3);
				}
			}
		}
		
		
		if(row - 2 >= 0 && column - 1 >= 0 ) {
			char c1 = copyBoard[row - 2][column - 1].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m4 = new GameMove(row - 2, column - 1);
				this.possibleMoves.add(m4);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m5 = new GameMove(row - 2, column - 1);
					this.possibleMoves.add(m5);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m6 = new GameMove(row - 2, column - 1);
					this.possibleMoves.add(m6);
				}
			}
		}
		
		
		if(row + 2 <= 7 && column + 1 <= 7) {
			char c1 = copyBoard[row + 2][column + 1].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m7 = new GameMove(row + 2, column + 1);
				this.possibleMoves.add(m7);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m8 = new GameMove(row + 2, column + 1);
					this.possibleMoves.add(m8);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m9 = new GameMove(row + 2, column + 1);
					this.possibleMoves.add(m9);
				}
			}
		}
		
		
		
		if(row + 2 <= 7 && column - 1 >= 0) {
			char c1 = copyBoard[row + 2][column - 1].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m10 = new GameMove(row + 2, column - 1);
				this.possibleMoves.add(m10);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m11 = new GameMove(row + 2, column - 1);
					this.possibleMoves.add(m11);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m12 = new GameMove(row + 2, column - 1);
					this.possibleMoves.add(m12);
				}
			}
		}
		
		
		
		if(row - 1 >= 0 && column + 2 <= 7) {
			char c1 = copyBoard[row - 1][column + 2].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m13 = new GameMove(row - 1, column + 2);
				this.possibleMoves.add(m13);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m14 = new GameMove(row - 1, column + 2);
					this.possibleMoves.add(m14);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m15 = new GameMove(row - 1, column + 2);
					this.possibleMoves.add(m15);
				}
			}
		}
		
		
		if(row - 1 >= 0 && column - 2 >= 0) {
			char c1 = copyBoard[row - 1][column - 2].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m16 = new GameMove(row - 1, column - 2);
				this.possibleMoves.add(m16);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m17 = new GameMove(row - 1, column - 2);
					this.possibleMoves.add(m17);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m18 = new GameMove(row - 1, column - 2);
					this.possibleMoves.add(m18);
				}
			}
		}
		
		
		if(row + 1 <= 7 && column + 2 <= 7) {
			char c1 = copyBoard[row + 1][column + 2].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m19 = new GameMove(row + 1, column + 2);
				this.possibleMoves.add(m19);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m20 = new GameMove(row + 1, column + 2);
					this.possibleMoves.add(m20);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m21 = new GameMove(row + 1, column + 2);
					this.possibleMoves.add(m21);
				}
			}
		}
		
		
		
		if(row + 1 <= 7 && column - 2 >= 0) {
			char c1 = copyBoard[row + 1][column - 2].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m22 = new GameMove(row + 1, column - 2);
				this.possibleMoves.add(m22);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m23 = new GameMove(row + 1, column - 2);
					this.possibleMoves.add(m23);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m24 = new GameMove(row + 1, column - 2);
					this.possibleMoves.add(m24);
				}
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countValidMoves() {
		// TODO Auto-generated method stub
		return this.possibleMoves.size();
	}

}
