package chess;

import java.util.ArrayList;



public class King  implements ChessPiece {
	
	//Brian A Lemes netid: bal160
	//Christopher H Gonzales netid: chg35
	
	ArrayList<GameMove> possibleMoves = new ArrayList<GameMove>();
	int currentX;
	int currentY;
	int whichPlayer;
	boolean inPlay = true;
	
	public King(int currentX, int currentY, int whichPlayer) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.whichPlayer = whichPlayer;
	}

	@Override
	public void findValidMoves(String[][] copyBoard) {
		int x = this.currentX;
		int y = this.currentY;
		
		int up = x - 1;
		int down = x + 1;
		int left = y - 1;
		int right = y + 1;
		
		//go clockwise
		if(up >= 0) {
			char c1 = copyBoard[up][y].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m1 = new GameMove(up, y);
				this.possibleMoves.add(m1);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m2 = new GameMove(up, y);
					this.possibleMoves.add(m2);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m3 = new GameMove(up, y);
					this.possibleMoves.add(m3);
				}
			}
		}
		
		
		if(up >= 0 && right <= 7 ) {
			char c1 = copyBoard[up][right].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m4 = new GameMove(up, right);
				this.possibleMoves.add(m4);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m5 = new GameMove(up, right);
					this.possibleMoves.add(m5);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m6 = new GameMove(up, right);
					this.possibleMoves.add(m6);
				}
			}
		}
		
		
		if(right <= 7) {
			char c1 = copyBoard[x][right].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m7 = new GameMove(x, right);
				this.possibleMoves.add(m7);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m8 = new GameMove(x, right);
					this.possibleMoves.add(m8);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m9 = new GameMove(x, right);
					this.possibleMoves.add(m9);
				}
			}
		}
		
		
		
		if(down <= 7 && right <= 7) {
			char c1 = copyBoard[down][right].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m10 = new GameMove(down, right);
				this.possibleMoves.add(m10);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m11 = new GameMove(down, right);
					this.possibleMoves.add(m11);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m12 = new GameMove(down, right);
					this.possibleMoves.add(m12);
				}
			}
		}
		
		
		
		if(down <= 7) {
			char c1 = copyBoard[down][y].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m13 = new GameMove(down, y);
				this.possibleMoves.add(m13);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m14 = new GameMove(down, y);
					this.possibleMoves.add(m14);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m15 = new GameMove(down, y);
					this.possibleMoves.add(m15);
				}
			}
		}
		
		
		if(down <= 7 && left >= 0) {
			char c1 = copyBoard[down][left].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m16 = new GameMove(down, left);
				this.possibleMoves.add(m16);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m17 = new GameMove(down, left);
					this.possibleMoves.add(m17);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m18 = new GameMove(down, left);
					this.possibleMoves.add(m18);
				}
			}
		}
		
		
		if(left >= 0) {
			char c1 = copyBoard[x][left].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m19 = new GameMove(x, left);
				this.possibleMoves.add(m19);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m20 = new GameMove(x, left);
					this.possibleMoves.add(m20);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m21 = new GameMove(x, left);
					this.possibleMoves.add(m21);
				}
			}
		}
		
		
		
		if(up >= 0 && left >= 0) {
			char c1 = copyBoard[up][left].charAt(0);
			if(c1 == ' ' || c1 == '#') {
				GameMove m22 = new GameMove(up, left);
				this.possibleMoves.add(m22);
			}
			else if(c1 == 'w') {
				if(this.whichPlayer == 2) {
					GameMove m23 = new GameMove(up, left);
					this.possibleMoves.add(m23);
				}
			}
			else if(c1 == 'b') {
				if(this.whichPlayer == 1) {
					GameMove m24 = new GameMove(up, left);
					this.possibleMoves.add(m24);
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
	
	public boolean kingCheck(String[][] copyBoard) {
		boolean check = false;
		boolean status = false;
		
		status = knightsCheck(this.currentX, this.currentY, this.whichPlayer, copyBoard);
		if(status == true) {
			return true;
		}
		
		status = bishopQueensCheck(this.currentX, this.currentY, this.whichPlayer, copyBoard);
		if(status == true) {
			return true;
		}
		
		status = rookQueensCheck(this.currentX, this.currentY, this.whichPlayer, copyBoard);
		if(status == true) {
			return true;
		}
		
		status = pawnsCheck(this.currentX, this.currentY, this.whichPlayer, copyBoard);
		if(status == true) {
			return true;
		}
		
		status = kingsCheck(this.currentX, this.currentY, this.whichPlayer, copyBoard);
		if(status == true) {
			return true;
		}
		return check;
	}

	public static boolean knightsCheck(int x, int y, int player, String[][] copyBoard) {
		boolean check = false;
		int row = x;
		int column = y;
		
		
		if( (row - 2) >= 0 && column + 1 <= 7) {
			String k1 = copyBoard[(row - 2)][(column + 1)];
			
			if(player == 1 && k1.equals("bN ")) {
					return true;
				}
			
			if(player == 2 && k1.equals("wN ")) {
					return true;
				}
			
		}
		
		
		if(row - 2 >= 0 && column - 1 >= 0 ) {
			String k2 = copyBoard[(row - 2)][(column - 1)];
			
			if(player == 1 && k2.equals("bN ")) {
					return true;
				}
			
			if(player == 2 && k2.equals("wN ")) {
					return true;
				}
		}
		
		
		if(row + 2 <= 7 && column + 1 <= 7) {
			String k3 = copyBoard[(row + 2)][(column + 1)];
			
			if(player == 1 && k3.equals("bN ")) {
					return true;
				}
			
			if(player == 2 && k3.equals("wN ")) {
					return true;
				}
		}
		
		
		
		if(row + 2 <= 7 && column - 1 >= 0) {
			String k4 = copyBoard[(row + 2)][(column - 1)];
			
			if(player == 1 && k4.equals("bN ")) {
					return true;
				}
			
			if(player == 2 && k4.equals("wN ")) {
					return true;
				}
		}
		
		
		
		if(row - 1 >= 0 && column + 2 <= 7) {
			String k5 = copyBoard[(row - 1)][(column + 2)];
			
			if(player == 1 && k5.equals("bN ")) {
					return true;
				}
			
			if(player == 2 && k5.equals("wN ")) {
					return true;
				}
		}
		
		
		if(row - 1 >= 0 && column - 2 >= 0) {
			String k6 = copyBoard[(row - 1)][(column - 2)];
			
			if(player == 1 && k6.equals("bN ")) {
					return true;
				}
			
			if(player == 2 && k6.equals("wN ")) {
					return true;
				}
		}
		
		
		if(row + 1 <= 7 && column + 2 <= 7) {
			String k7 = copyBoard[(row + 1)][(column + 2)];
			
			if(player == 1 && k7.equals("bN ")) {
					return true;
				}
			
			if(player == 2 && k7.equals("wN ")) {
					return true;
				}
		}
		
		
		
		if(row + 1 <= 7 && column - 2 >= 0) {
			String k8 = copyBoard[(row + 1)][(column - 2)];
			
			if(player == 1 && k8.equals("bN ")) {
					return true;
				}
			
			if(player == 2 && k8.equals("wN ")) {
					return true;
				}
		}
		return check;
	}
	
	public static boolean bishopQueensCheck(int x, int y, int player, String[][] copyBoard) {
		boolean check = false;
		
		//x is initialX
		//y is initialY
		
		int column = y;
		for(int row = (x - 1); row >= 0; row--) {
			column--;
			if(column < 0) {
				break;
			}
			String b1 = copyBoard[row][column];
			char c1 = copyBoard[row][column].charAt(0);
			
			if(player == 1) {
				if(c1 == 'w') {
					break;
				}
				if (b1.equals("bB ") || b1.equals("bQ ")) {
					return true;
				}
			}
			if(player == 2) {
				if(c1 == 'b') {
					break;
				}
				if(b1.equals("wB ") || b1.equals("wQ ")) {
					return true;
				}
				
			}
		}
			
		
		
		column = y;
		for(int row = (x + 1); row <= 7; row++) {
			column--;
			if(column < 0) {
				break;
			}
			String b1 = copyBoard[row][column];
			char c1 = copyBoard[row][column].charAt(0);
			
			if(player == 1) {
				if(c1 == 'w') {
					break;
				}
				if (b1.equals("bB ") || b1.equals("bQ ")) {
					return true;
				}
			}
			if(player == 2) {
				if(c1 == 'b') {
					break;
				}
				if(b1.equals("wB ") || b1.equals("wQ ")) {
					return true;
				}
				
			}
		}
		
		
		column = y;
		for(int row = (x - 1); row >= 0; row--) {
			column++;
			if(column > 7) {
				break;
			}
			String b1 = copyBoard[row][column];
			char c1 = copyBoard[row][column].charAt(0);
			
			if(player == 1) {
				if(c1 == 'w') {
					break;
				}
				if (b1.equals("bB ") || b1.equals("bQ ")) {
					return true;
				}
			}
			if(player == 2) {
				if(c1 == 'b') {
					break;
				}
				if(b1.equals("wB ") || b1.equals("wQ ")) {
					return true;
				}
				
			}
		}
		
		column = y;
		for(int row = x + 1; row <= 7; row++) {
			column++;
			if(column > 7) {
				break;
			}
			String b1 = copyBoard[row][column];
			char c1 = copyBoard[row][column].charAt(0);
			
			if(player == 1) {
				if(c1 == 'w') {
					break;
				}
				if (b1.equals("bB ") || b1.equals("bQ ")) {
					return true;
				}
			}
			if(player == 2) {
				if(c1 == 'b') {
					break;
				}
				if(b1.equals("wB ") || b1.equals("wQ ")) {
					return true;
				}
				
			}
		}
		return check;
	}
	
	public static boolean rookQueensCheck(int x, int y, int player, String[][] copyBoard) {
		boolean check = false;
		//x is initialX
		//y is initialY
				
		for(int row = (x - 1); row >= 0; row--) {
		
			String b1 = copyBoard[row][y];
			char c1 = copyBoard[row][y].charAt(0);
					
			if(player == 1) {
				if(c1 == 'w') {
					break;
				}
				if (b1.equals("bR ") || b1.equals("bQ ")) {
						return true;
				}
			}
			if(player == 2) {
				if(c1 == 'b') {
					break;
				}
				if(b1.equals("wR ") || b1.equals("wQ ")) {
					return true;
				}
						
			}
		}
					
				
		for(int row = (x + 1); row <= 7; row++) {
			String b1 = copyBoard[row][y];
			char c1 = copyBoard[row][y].charAt(0);
					
			if(player == 1) {
				if(c1 == 'w') {
					break;
				}
				if (b1.equals("bR ") || b1.equals("bQ ")) {
					return true;
				}
			}
			if(player == 2) {
				if(c1 == 'b') {
					break;
				}
				if(b1.equals("wR ") || b1.equals("wQ ")) {
					return true;
				}
						
			}
		}
				
				
		for(int column = (y - 1); column >= 0; column--) {
				
			String b1 = copyBoard[x][column];
			char c1 = copyBoard[x][column].charAt(0);
					
			if(player == 1) {
				if(c1 == 'w') {
					break;
				}
				if (b1.equals("bR ") || b1.equals("bQ ")) {
					return true;
				}
			}
			if(player == 2) {
				if(c1 == 'b') {
					break;
				}
				if(b1.equals("wR ") || b1.equals("wQ ")) {
					return true;
				}
						
			}
		}
				
		
		for(int column = y + 1; column <= 7; column++) {
					
			String b1 = copyBoard[x][column];
			char c1 = copyBoard[x][column].charAt(0);
					
			if(player == 1) {
				if(c1 == 'w') {
					break;
				}
				if (b1.equals("bR ") || b1.equals("bQ ")) {
					return true;
				}
			}
			if(player == 2) {
				if(c1 == 'b') {
					break;
				}
				if(b1.equals("wR ") || b1.equals("wQ ")) {
							return true;
				}
						
			}
		}
		return check;
	}
	
	public boolean pawnsCheck(int x, int y, int player, String[][] copyBoard) {
		boolean check = false;
		
		if(player == 1) {
			if(x - 1 >= 0 && y - 1 >= 0) {
				String p1 = copyBoard[x - 1][y - 1];
				if(p1.equals("bp ")) {
					return true;
				}
			}
			if(x - 1 >= 0 && y + 1 <= 7) {
				String p2 = copyBoard[x - 1][y + 1];
				if(p2.equals("bp ")) {
					return true;
				}
			}
		}
		if(player == 2) {
			if(x + 1 <= 7 && y - 1 >= 0) {
				String p3 = copyBoard[x + 1][y - 1];
				if(p3.equals("wp ")) {
					return true;
				}
			}
			if(x + 1 <= 7 && y + 1 <= 7) {
				String p4 = copyBoard[x + 1][y + 1];
				if(p4.equals("wp ")) {
					return true;
				}
			}
		}
		return check;
	}
	
	public static boolean kingsCheck(int x, int y, int player, String[][] copyBoard) {
		boolean check = false;
		int up = x - 1;
		int down = x + 1;
		int left = y - 1;
		int right = y + 1;
		
		
		if(up >= 0) {
			String k1 = copyBoard[up][y];
			if(player == 1 && k1.equals("bK ")) {
				return true;
			}
			if(player == 2 && k1.contentEquals("wK ")) {
				return true;
			}
		}
		
		
		if(up >= 0 && right <= 7 ) {
			
			String k2 = copyBoard[up][right];
			if(player == 1 && k2.equals("bK ")) {
				return true;
			}
			if(player == 2 && k2.contentEquals("wK ")) {
				return true;
			}
		}
		
		
		if(right <= 7) {
			
			String k3 = copyBoard[x][right];
			if(player == 1 && k3.equals("bK ")) {
				return true;
			}
			if(player == 2 && k3.contentEquals("wK ")) {
				return true;
			}
		}
		
		
		
		if(down <= 7 && right <= 7) {
			String k4 = copyBoard[down][right];
			if(player == 1 && k4.equals("bK ")) {
				return true;
			}
			if(player == 2 && k4.contentEquals("wK ")) {
				return true;
			}
		}
		
		
		
		if(down <= 7) {
			String k5 = copyBoard[down][y];
			if(player == 1 && k5.equals("bK ")) {
				return true;
			}
			if(player == 2 && k5.contentEquals("wK ")) {
				return true;
			}
		}
		
		
		if(down <= 7 && left >= 0) {
			String k6 = copyBoard[down][left];
			if(player == 1 && k6.equals("bK ")) {
				return true;
			}
			if(player == 2 && k6.contentEquals("wK ")) {
				return true;
			}
		}
		
		
		if(left >= 0) {
			String k7 = copyBoard[x][left];
			if(player == 1 && k7.equals("bK ")) {
				return true;
			}
			if(player == 2 && k7.contentEquals("wK ")) {
				return true;
			}
		}
		
		
		
		if(up >= 0 && left >= 0) {
			String k8 = copyBoard[up][left];
			if(player == 1 && k8.equals("bK ")) {
				return true;
			}
			if(player == 2 && k8.contentEquals("wK ")) {
				return true;
			}
		}
		return check;
	}
	
	
	
	@Override
	public int countValidMoves() {
		// TODO Auto-generated method stub
		return this.possibleMoves.size();
	}

}
