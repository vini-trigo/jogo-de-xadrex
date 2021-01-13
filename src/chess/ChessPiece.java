package chess;

import boardgame.piece;
import boardgame.position;

public abstract class ChessPiece extends piece{

	private Color color;

	public ChessPiece(boardgame.board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	protected boolean isThereAnyPossibleMove(position p) {
		ChessPiece ps = (ChessPiece)getBoard().piece(p);
		return ps != null && ps.getColor() != color; 
	}
	
}
