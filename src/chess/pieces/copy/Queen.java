package chess.pieces.copy;

import boardgame.position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(boardgame.board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		position p = new position(0, 0);

		p.setValues(position.getRow() - 1, position.getColunm());
		while (getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
			mat[p.getRow()][p.getColunm()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColunm() - 1);
		while (getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
			mat[p.getRow()][p.getColunm()] = true;
			p.setColunm(p.getColunm() - 1);
		}
		if (getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColunm() + 1);
		while (getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
			mat[p.getRow()][p.getColunm()] = true;
			p.setColunm(p.getColunm() + 1);
		}
		if (getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getColunm());
		while (getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
			mat[p.getRow()][p.getColunm()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// nw
		p.setValues(position.getRow() - 1, position.getColunm() - 1);
		while (getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
			mat[p.getRow()][p.getColunm()] = true;
			p.setValues(p.getRow() - 1, p.getColunm() - 1);
		}
		if (getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// ne
		p.setValues(position.getRow() - 1, position.getColunm() + 1);
		while (getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
			mat[p.getRow()][p.getColunm()] = true;
			p.setValues(p.getRow() - 1, p.getColunm() + 1);
		}
		if (getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// se
		p.setValues(position.getRow() + 1, position.getColunm() + 1);
		while (getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
			mat[p.getRow()][p.getColunm()] = true;
			p.setValues(p.getRow() + 1, p.getColunm() + 1);
		}
		if (getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// sw
		p.setValues(position.getRow() + 1, position.getColunm() - 1);
		while (getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
			mat[p.getRow()][p.getColunm()] = true;
			p.setValues(p.getRow() + 1, p.getColunm() - 1);
		}
		if (getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		return mat;
	}

}
