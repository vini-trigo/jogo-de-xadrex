package chess;

import boardgame.piece;

public abstract class ChessPiece extends piece{

	private Color color;

	public ChessPiece(boardgame.board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	
	
}
