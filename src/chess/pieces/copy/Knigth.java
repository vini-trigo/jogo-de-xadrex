package chess.pieces.copy;

import boardgame.position;
import chess.ChessPiece;
import chess.Color;

public class Knigth extends ChessPiece {

	public Knigth(boardgame.board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "H";
	}

	private boolean canMove(position ps) {
		ChessPiece p = (ChessPiece) getBoard().piece(ps);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		position p = new position(0, 0);

		p.setValues(position.getRow() - 1, position.getColunm() - 2);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		p.setValues(position.getRow() - 2, position.getColunm() -1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		p.setValues(position.getRow() - 2, position.getColunm() + 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		
		p.setValues(position.getRow() -1 , position.getColunm() + 2);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// 
		p.setValues(position.getRow() + 1, position.getColunm() + 2);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		
		p.setValues(position.getRow() + 2, position.getColunm() + 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// 
		p.setValues(position.getRow() + 2, position.getColunm() - 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}
		
		// 
		p.setValues(position.getRow() + 1, position.getColunm() - 2);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}
		return mat;
	}

}
