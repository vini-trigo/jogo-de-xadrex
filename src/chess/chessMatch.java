package chess;

import boardgame.board;
import boardgame.position;
import chess.pieces.Rook;
import chess.pieces.king;

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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new position(2, 1));
		board.placePiece(new king(board, Color.BLACK), new position(0, 1));
		board.placePiece(new Rook(board, Color.WHITE), new position(6, 1));
	}
}
