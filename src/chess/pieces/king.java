package chess.pieces;

import chess.ChessPiece;
import chess.Color;

public class king extends ChessPiece{

	public king(boardgame.board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	
}
