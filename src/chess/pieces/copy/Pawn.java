package chess.pieces.copy;

import boardgame.position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	public Pawn(boardgame.board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		position p = new position(0, 0);

		if(getColor() == Color.WHITE) {
			p.setValues(position.getRow() -1, position.getColunm());
			if(getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
				mat[p.getRow()][p.getColunm()] = true;
			}
			p.setValues(position.getRow() -2, position.getColunm());
			position p2 = new position(position.getRow() -1, position.getColunm());
			if(getBoard().positionExist(p) && !getBoard().thereisAPice(p) && getBoard().positionExist(p2) && !getBoard().thereisAPice(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColunm()] = true;
			}
			p.setValues(position.getRow() -1, position.getColunm()-1);
			if(getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
				mat[p.getRow()][p.getColunm()] = true;
			}
			p.setValues(position.getRow() -1, position.getColunm()+1);
			if(getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
				mat[p.getRow()][p.getColunm()] = true;
			}
		}
		else {
			p.setValues(position.getRow() +1, position.getColunm());
			if(getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
				mat[p.getRow()][p.getColunm()] = true;
			}
			p.setValues(position.getRow() +2, position.getColunm());
			position p2 = new position(position.getRow() +1, position.getColunm());
			if(getBoard().positionExist(p) && !getBoard().thereisAPice(p) && getBoard().positionExist(p2) && !getBoard().thereisAPice(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColunm()] = true;
			}
			p.setValues(position.getRow() +1, position.getColunm()-1);
			if(getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
				mat[p.getRow()][p.getColunm()] = true;
			}
			p.setValues(position.getRow() +1, position.getColunm()+1);
			if(getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
				mat[p.getRow()][p.getColunm()] = true;
			}
		}
		
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}

	
}
