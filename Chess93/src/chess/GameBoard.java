package chess;



public class GameBoard {
	
	//Brian A Lemes netid: bal160
	//Christopher H Gonzales netid: chg35
	
	String[][] tiles = new String[9][9];
	String[][] playBoard = new String[9][9];
	
	public GameBoard() {
		initializeBoard();
		copyBoard(this.tiles, this.playBoard);
		setUpPieces();
	}

	public void initializeBoard() {
		
		int rowNum = 8;
		boolean space = true;
		for(int i = 0; i < 8; i++) {
			
			for(int j = 0; j < 8; j++) {
				if(space == true) {
					this.tiles[i][j] = "   ";
					space = false;
				}
				else {
					this.tiles[i][j] = "## ";
					space = true;
				}
			}
			
			if(space == true) {
				space = false;
			}
			else {
				space = true;
			}
			
			this.tiles[i][8] = (rowNum + "");
			rowNum = rowNum - 1;
			
		}
		
		this.tiles[8][0] = " a ";
		this.tiles[8][1] = " b ";
		this.tiles[8][2] = " c ";
		this.tiles[8][3] = " d ";
		this.tiles[8][4] = " e ";
		this.tiles[8][5] = " f ";
		this.tiles[8][6] = " g ";
		this.tiles[8][7] = " h ";
	}
	
	public void printBoard() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i == 8 && j == 8) {
					continue;
				}
				//System.out.print(this.tiles[i][j]);
				System.out.print(this.playBoard[i][j]);
				//System.out.print(board[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public void copyBoard(String[][] board1, String[][] board2) {
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				board2[i][j] = board1[i][j];
			}
		}
		
		
	}
	
	public void setUpPieces() {
		
		for(int i = 0; i < 8; i++) {
			this.playBoard[1][i] = "bp ";
			this.playBoard[6][i] = "wp ";
		}
		
		this.playBoard[0][0] = "bR ";
		this.playBoard[0][7] = "bR ";
		this.playBoard[7][0] = "wR ";
		this.playBoard[7][7] = "wR ";
		
		this.playBoard[0][1] = "bN ";
		this.playBoard[0][6] = "bN ";
		this.playBoard[7][1] = "wN ";
		this.playBoard[7][6] = "wN ";
		
		this.playBoard[0][2] = "bB ";
		this.playBoard[0][5] = "bB ";
		this.playBoard[7][2] = "wB ";
		this.playBoard[7][5] = "wB ";
		
		this.playBoard[0][3] = "bQ ";
		this.playBoard[0][4] = "bK ";
		this.playBoard[7][3] = "wQ ";
		this.playBoard[7][4] = "wK ";
		
	}
	
}
