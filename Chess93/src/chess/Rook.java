package chess;

import java.util.ArrayList;

public class Rook implements ChessPiece {
	//Brian A Lemes netid: bal160
	//Christopher H Gonzales netid: chg35
	
	ArrayList<GameMove> possibleMoves = new ArrayList<GameMove>();
	int currentX;
	int currentY;
	int whichPlayer;
	boolean inPlay = true;
	
	public Rook(int currentX, int currentY, int whichPlayer) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.whichPlayer = whichPlayer;
	}

	@Override
	public void findValidMoves(String[][] copyBoard) {
		
		int row = this.currentX;
		int column = this.currentY;
		
		for(int x = (row - 1); x >= 0; x--) {
			char c = copyBoard[x][column].charAt(0);
			
			if(c == '#' || c== ' ') {
				GameMove m1 = new GameMove(x, column);
				this.possibleMoves.add(m1);
				continue;
				
			}
			else if(c == 'w') {
				if(this.whichPlayer == 1) {
					break;
				}
				else if(this.whichPlayer == 2) {
					GameMove m2 = new GameMove(x, column);
					this.possibleMoves.add(m2);
					break;
				}
			}
			else if(c == 'b') {
				if(this.whichPlayer == 2) {
					break;
				}
				else if(this.whichPlayer == 1) {
					GameMove m3 = new GameMove(x, column);
					this.possibleMoves.add(m3);
					break;
				}
			}
			
		}
		
		for(int x = row + 1; x <= 7; x++) {
			char c = copyBoard[x][column].charAt(0);
			
			if(c == '#' || c == ' ') {
				GameMove m4 = new GameMove(x, column);
				this.possibleMoves.add(m4);
				continue;
			}
			else if(c == 'w') {
				if(this.whichPlayer == 1) {
					break;
				}
				else if(this.whichPlayer == 2) {
					GameMove m5 = new GameMove(x, column);
					this.possibleMoves.add(m5);
					break;
				}
			}
			else if(c == 'b') {
				if(this.whichPlayer == 2) {
					break;
				}
				else if(this.whichPlayer == 1) {
					GameMove m6 = new GameMove(x, column);
					this.possibleMoves.add(m6);
					break;
				}
			}
		}
		
		
		for(int y = column - 1; y >= 0; y--) {
			char c = copyBoard[row][y].charAt(0);
			
			if(c == '#' || c == ' ') {
				GameMove m7 = new GameMove(row, y);
				this.possibleMoves.add(m7);
				continue;
			}
			else if(c == 'w') {
				if(this.whichPlayer == 1) {
					break;
				}
				else if(this.whichPlayer == 2) {
					GameMove m8 = new GameMove(row, y);
					this.possibleMoves.add(m8);
					break;
				}
			}
			else if(c == 'b') {
				if(this.whichPlayer == 2) {
					break;
				}
				else if(this.whichPlayer == 1) {
					GameMove m9 = new GameMove(row, y);
					this.possibleMoves.add(m9);
					break;
				}
			}
		}
		
		
		for(int y = column + 1; y <= 7; y++) {
			char c = copyBoard[row][y].charAt(0);
			
			if(c == '#' || c == ' ') {
				GameMove m10 = new GameMove(row, y);
				this.possibleMoves.add(m10);
				continue;
			}
			else if(c == 'w') {
				if(this.whichPlayer == 1) {
					break;
				}
				else if(this.whichPlayer == 2) {
					GameMove m11 = new GameMove(row, y);
					this.possibleMoves.add(m11);
					break;
				}
			}
			else if(c == 'b') {
				if(this.whichPlayer == 2) {
					break;
				}
				else if(this.whichPlayer == 1) {
					GameMove m12 = new GameMove(row, y);
					this.possibleMoves.add(m12);
					break;
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
