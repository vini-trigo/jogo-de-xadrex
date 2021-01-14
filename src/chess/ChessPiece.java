package chess;

import boardgame.piece;
import boardgame.position;

public abstract class ChessPiece extends piece{

	private Color color;
	private int moveCount;

	public ChessPiece(boardgame.board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;	
	}
	
	public void increaseMoveCount() {
		moveCount++;
	}
	
	public void decreaseMoveCount() {
		moveCount--;
	}
	
	public Chessposition getChessPosition() {
		return Chessposition.fromChessposition(position);
	}

	protected boolean isThereAnyPossibleMove(position p) {
		ChessPiece ps = (ChessPiece)getBoard().piece(p);
		return ps != null && ps.getColor() != color; 
	}
	
}
