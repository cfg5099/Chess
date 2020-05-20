package chess;

import java.util.Scanner;

public class Chess {
	//Brian A Lemes netid: bal160
	//Christopher H Gonzales: netid: chg35
	static King whiteKing = new King(7, 4, 1);
	static King blackKing = new King(0, 4, 2);
	static ChessPlayer white = new ChessPlayer(1);
	static ChessPlayer black = new ChessPlayer(2);
	
	static int enpassantX = -1;
	static int enpassantY = -1;
	
	static boolean kingMove = false;
	
	static String[][] safeBoard = new String[9][9];
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner sc = new Scanner(System.in);
		GameBoard board = new GameBoard();
		
		boolean illegalCheck = false;
		
		boolean enpassantMove = false;
		
		boolean drawOffer = false;
		boolean drawConsidered = false;
		
		boolean goodMove = true;
		//board.printBoard();
		int xPosition1 = 0;
		int yPosition1 = 0;
		
		int xPosition2 = 0;
		int yPosition2 = 0;
		
		int currentPlayer = 1;
		
		boolean moveWentThrough = true;
		
		boolean check = false;
		
		while(true) {
			
			if(drawConsidered == true) {
				drawOffer = false;
				drawConsidered = false;
			}
			if(drawOffer == true) {
				drawConsidered = true;
			}
			if(moveWentThrough == true) {
				board.printBoard();
				System.out.print("\n");
			}
			
			if(check == true && illegalCheck == false) {
				System.out.println("Check");
				check = false;
			}
			
			if(currentPlayer == 1) {
				System.out.print("White's move: ");
			}
			else if (currentPlayer == 2) {
				System.out.print("Black's move: ");
			}
			
			String move = sc.nextLine();
			
			if(move.equals("resign")) {
				if(currentPlayer == 1) {
					System.out.println("Black wins");
				}
				if(currentPlayer == 2) {
					System.out.println("White wins");
				}
				break;
			}
			
			if(move.equals("draw")) {
				if(drawOffer == true) {
					break;
				}
				else {
					System.out.println("Illegal move, try again");
					moveWentThrough = false;
					continue;
				}
			}
			
			if(move.length() > 10) {
				if(move.charAt(6) == 'd' && move.charAt(7) == 'r' && move.charAt(8) == 'a' 
					&&	move.charAt(9) == 'w' && move.charAt(10) == '?') {
					drawOffer = true;
				}
			}
			
			
			
			yPosition1 = letterToNumber(move.charAt(0));
			xPosition1 = numberToNumber(move.charAt(1));
			
			yPosition2 = letterToNumber(move.charAt(3));
			xPosition2 = numberToNumber(move.charAt(4));
			
			goodMove = validateMove(currentPlayer, xPosition1, 
					yPosition1, xPosition2, yPosition2, board.playBoard);
			
			if(goodMove == true) {
				
				board.copyBoard(board.playBoard, safeBoard);
				
				char c1 = board.playBoard[xPosition1][yPosition1].charAt(1);
				char c2 = board.playBoard[xPosition2][yPosition2].charAt(0);
				
				if( c1 == 'p' && (c2 == '#' || c2 == ' ') ) {
					if(currentPlayer == 1 && (xPosition1 - 1) == xPosition2
							&& (yPosition1 - 1) == yPosition2) {
						
						String enreplace1 = board.tiles[xPosition1][yPosition1];
						String enreplace2 = board.tiles[xPosition1][yPosition1 - 1];
						String en1 = board.playBoard[xPosition1][yPosition1];
						board.playBoard[xPosition2][yPosition2] = en1;
						board.playBoard[xPosition1][yPosition1] = enreplace1;
						board.playBoard[xPosition1][yPosition1 - 1] = enreplace2;
						enpassantX = -1;
						enpassantY = -1;
						enpassantMove = true;
						
					}
					else if(currentPlayer == 1 && (xPosition1 - 1) == xPosition2
							&& (yPosition1 + 1) == yPosition2) {
						
						String enreplace1 = board.tiles[xPosition1][yPosition1];
						String enreplace2 = board.tiles[xPosition1][yPosition1 + 1];
						String en1 = board.playBoard[xPosition1][yPosition1];
						board.playBoard[xPosition2][yPosition2] = en1;
						board.playBoard[xPosition1][yPosition1] = enreplace1;
						board.playBoard[xPosition1][yPosition1 + 1] = enreplace2;
						enpassantX = -1;
						enpassantY = -1;
						enpassantMove = true;
						
					}
					else if(currentPlayer == 2 && (xPosition1 + 1) == xPosition2
							&& (yPosition1 - 1) == yPosition2) {
						String enreplace1 = board.tiles[xPosition1][yPosition1];
						String enreplace2 = board.tiles[xPosition1][yPosition1 - 1];
						String en1 = board.playBoard[xPosition1][yPosition1];
						board.playBoard[xPosition2][yPosition2] = en1;
						board.playBoard[xPosition1][yPosition1] = enreplace1;
						board.playBoard[xPosition1][yPosition1 - 1] = enreplace2;
						enpassantX = -1;
						enpassantY = -1;
						enpassantMove = true;
						
					}
					else if(currentPlayer == 2 && (xPosition1 + 1) == xPosition2
							&& (yPosition1 + 1) == yPosition2) {
						String enreplace1 = board.tiles[xPosition1][yPosition1];
						String enreplace2 = board.tiles[xPosition1][yPosition1 + 1];
						String en1 = board.playBoard[xPosition1][yPosition1];
						board.playBoard[xPosition2][yPosition2] = en1;
						board.playBoard[xPosition1][yPosition1] = enreplace1;
						board.playBoard[xPosition1][yPosition1 + 1] = enreplace2;
						enpassantX = -1;
						enpassantY = -1;
						enpassantMove = true;
						
					}
				}
				
			
				
				
				if(enpassantMove == false) {
					
				String s = board.playBoard[xPosition1][yPosition1];
				String replace = board.tiles[xPosition1][yPosition1];
				board.playBoard[xPosition2][yPosition2] = s;
				board.playBoard[xPosition1][yPosition1] = replace;
				
				if(currentPlayer == 1) {
					if(board.playBoard[xPosition2][yPosition2].equals("wp ")
							&& xPosition2 == 0) {
						if(move.length() == 5) {
							board.playBoard[xPosition2][yPosition2] = "wQ ";
						}
						else if(move.length() == 7) {
							char c3 = move.charAt(6);
							if(c3 == 'R') {
								board.playBoard[xPosition2][yPosition2] = "wR ";
							}
							else if(c3 == 'N') {
								board.playBoard[xPosition2][yPosition2] = "wN ";
							}
							else if(c3 == 'B') {
								board.playBoard[xPosition2][yPosition2] = "wB ";
							}
							else if(c3 == 'Q') {
								board.playBoard[xPosition2][yPosition2] = "wQ ";
							}
						}
					}
				}
				
				if(currentPlayer == 2) {
					if(board.playBoard[xPosition2][yPosition2].equals("bp ")
							&& xPosition2 == 7) {
						if(move.length() == 5) {
							board.playBoard[xPosition2][yPosition2] = "bQ ";
						}
						else if(move.length() == 7) {
							char c3 = move.charAt(6);
							if(c3 == 'R') {
								board.playBoard[xPosition2][yPosition2] = "bR ";
							}
							else if(c3 == 'N') {
								board.playBoard[xPosition2][yPosition2] = "bN ";
							}
							else if(c3 == 'B') {
								board.playBoard[xPosition2][yPosition2] = "bB ";
							}
							else if(c3 == 'Q') {
								board.playBoard[xPosition2][yPosition2] = "bQ ";
							}
						}
					}
				}
				
				}
				
				enpassantMove = false;
				
				if(currentPlayer == 1) {
					check = whiteKing.kingCheck(board.playBoard);
					if(check == true) {
						board.copyBoard(safeBoard, board.playBoard);
						if(kingMove == true) {
							whiteKing.currentX = xPosition1;
							whiteKing.currentY = yPosition1;
							kingMove = false;
						}
						illegalCheck = true;
						System.out.println("Illegal move, try again");
						moveWentThrough = false;
						continue;
					}
				}
				
				if(currentPlayer == 2) {
					check = blackKing.kingCheck(board.playBoard);
					if(check == true) {
						board.copyBoard(safeBoard, board.playBoard);
						if(kingMove == true) {
							blackKing.currentX = xPosition1;
							blackKing.currentY = yPosition1;
							kingMove = false;
						}
						illegalCheck = true;
						System.out.println("Illegal move, try again");
						moveWentThrough = false;
						continue;
					}
				}
				
				moveWentThrough = true;
				illegalCheck = false;
				
				if(currentPlayer == 1) {
					check = blackKing.kingCheck(board.playBoard);
					
				}
				
				if(currentPlayer == 2) {
					check = whiteKing.kingCheck(board.playBoard);
					
				}
				
			}
			else if(goodMove == false) {
				System.out.println("Illegal move, try again");
				moveWentThrough = false;
				continue;
			}
			
			
			System.out.print("\n");
			
			if(currentPlayer == 1) {
				currentPlayer = 2;
			}
			else if(currentPlayer == 2){
				currentPlayer = 1;
			}
			
			
		}
		sc.close();
	}
	
	public static int letterToNumber(char c) {
		int location = -1;
		
		switch(c) {
		case 'a':
			location = 0;
			break;
		case 'b':
			location = 1;
			break;
		case 'c':
			location = 2;
			break;
		case 'd':
			location = 3;
			break;
		case 'e':
			location = 4;
			break;
		case 'f':
			location = 5;
			break;
		case 'g':
			location = 6;
			break;
		case 'h':
			location = 7;
			break;
		default:
			location = -1;
			break;
		}
		
		return location;
	}
	
	public static int numberToNumber(char c) {
		int location = -1;
		switch(c) {
		case '8':
			location = 0;
			break;
		case '7':
			location = 1;
			break;
		case '6':
			location = 2;
			break;
		case '5':
			location = 3;
			break;
		case '4':
			location = 4;
			break;
		case '3':
			location = 5;
			break;
		case '2':
			location = 6;
			break;
		case '1':
			location = 7;
			break;
		default:
			location = -1;
			break;
			
		}
		return location;
	}
	
	public static boolean validateMove(int player, int x1, 
			int y1, int x2, int y2, String[][] board) {
		boolean good = false;
		
		String piece = board[x1][y1];
		
		char side = piece.charAt(0);
		char c = piece.charAt(1);
		
		if(side == ' ' || side == '#') {
			return false;
		}
		
		if(player == 1 && side == 'b') {
			return false;
		}
		if(player == 2 && side == 'w') {
			return false;
		}

		if(c == 'p') {
			
			Pawn pawn = new Pawn(x1, y1, player);
			pawn.findValidMoves(board);
			pawn.enPassant(board);
			int j = pawn.countValidMoves();
			for(int i = 0; i < j; i++) {
				if(x2 == pawn.possibleMoves.get(i).getX()
					&& y2 == pawn.possibleMoves.get(i).getY()) {
					
					if(player == 1) {
						if(x2 == (x1 - 2) && y2 == y1) {
							enpassantX = x2;
							enpassantY = y2;
						}
						else {
							enpassantX = -1;
							enpassantY = -1;
						}
					}
					if(player == 2) {
						if(x2 == (x1 + 2) && y2 == y1) {
							enpassantX = x2;
							enpassantY = y2;
						}
						else {
							enpassantX = -1;
							enpassantY = -1;
						}
					}
					kingMove = false;
					
					return true;
				}
			}
		}
		
		
		if(c == 'R') {
			Rook rook = new Rook(x1, y1, player);
			rook.findValidMoves(board);
			int j = rook.countValidMoves();
			for(int i = 0; i < j; i++) {
				if(x2 == rook.possibleMoves.get(i).getX()
					&& y2 == rook.possibleMoves.get(i).getY()) {
					enpassantX = -1;
					enpassantY = -1;
					kingMove = false;
					return true;
				}
			}
		}
		
		if(c == 'B') {
			Bishop bishop = new Bishop(x1, y1, player);
			bishop.findValidMoves(board);
			int j = bishop.countValidMoves();
			for(int i = 0; i < j; i++) {
				if(x2 == bishop.possibleMoves.get(i).getX()
					&& y2 == bishop.possibleMoves.get(i).getY()) {
					enpassantX = -1;
					enpassantY = -1;
					kingMove = false;
					return true;
				}
			}
		}
		
		if(c == 'N') {
			Knight knight = new Knight(x1, y1, player);
			knight.findValidMoves(board);
			int j = knight.countValidMoves();
			for(int i = 0; i < j; i++) {
				if(x2 == knight.possibleMoves.get(i).getX()
					&& y2 == knight.possibleMoves.get(i).getY()) {
					enpassantX = -1;
					enpassantY = -1;
					kingMove = false; 
					return true;
				}
			}
		}
		if(c == 'Q') {
			Queen queen = new Queen(x1, y1, player);
			queen.findValidMoves(board);
			int j = queen.countValidMoves();
			for(int i = 0; i < j; i++) {
				if(x2 == queen.possibleMoves.get(i).getX()
					&& y2 == queen.possibleMoves.get(i).getY()) {
					enpassantX = -1;
					enpassantY = -1;
					kingMove = false;
					return true;
				}
			}
		}
		
		
		if(c == 'K') {
			King king = new King(x1, y1, player);
			king.findValidMoves(board);
			int j = king.countValidMoves();
			for(int i = 0; i < j; i++) {
				if(x2 == king.possibleMoves.get(i).getX()
					&& y2 == king.possibleMoves.get(i).getY()) {
					
					enpassantX = -1;
					enpassantY = -1;
					
					if(player == 1) {
						whiteKing.currentX = x2;
						whiteKing.currentY = y2;
					}
					if(player == 2) {
						blackKing.currentX = x2;
						blackKing.currentY = y2;
					}
					
					kingMove = true;
					return true;
				}
			}
		}
		
		return good;
	}
	

	

}
