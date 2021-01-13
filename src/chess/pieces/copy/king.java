package chess.pieces.copy;

import boardgame.position;
import chess.ChessPiece;
import chess.Color;

public class king extends ChessPiece {

	public king(boardgame.board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(position ps) {
		ChessPiece p = (ChessPiece) getBoard().piece(ps);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		position p = new position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColunm());
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getColunm());
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColunm() - 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColunm() + 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// nw
		p.setValues(position.getRow() - 1, position.getColunm() - 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// ne
		p.setValues(position.getRow() - 1, position.getColunm() + 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// sw
		p.setValues(position.getRow() + 1, position.getColunm() - 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}
		
		// se
		p.setValues(position.getRow() + 1, position.getColunm() + 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}
		return mat;
	}

}
