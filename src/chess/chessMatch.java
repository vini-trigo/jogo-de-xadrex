package chess;

import boardgame.board;
import boardgame.position;
import chess.pieces.copy.Rook;
import chess.pieces.copy.king;

public class chessMatch {

	private board board;
	
	public chessMatch() {
		board = new board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piec(i,j);
			}
		}
		return mat;
	}
	
	private void playceNewpiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new Chessposition(column, row).toPosition());
	}

	private void initialSetup() {
		playceNewpiece('b', 6, new Rook(board, Color.WHITE));
		playceNewpiece('e', 8,new king(board, Color.BLACK));
		playceNewpiece('e', 1,new Rook(board, Color.WHITE));
	}
}
