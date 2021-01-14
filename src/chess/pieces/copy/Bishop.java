package chess.pieces.copy;

import boardgame.position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{

	public Bishop(boardgame.board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		position p = new position(0, 0);
		
		//nw
		p.setValues(position.getRow() -1, position.getColunm()-1);
		while(getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
			mat[p.getRow()][p.getColunm()] = true;
			p.setValues(p.getRow() -1, p.getColunm() -1);
		}
		if(getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}
		
		//ne
		p.setValues(position.getRow() - 1, position.getColunm() +1);
		while(getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
			mat[p.getRow()][p.getColunm()] = true;
			p.setValues(p.getRow() -1, p.getColunm() +1);
		}
		if(getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}
		
		//se
				p.setValues(position.getRow() +1, position.getColunm() +1);
				while(getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
					mat[p.getRow()][p.getColunm()] = true;
					p.setValues(p.getRow() + 1, p.getColunm() + 1);
				}
				if(getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
					mat[p.getRow()][p.getColunm()] = true;
				}
		
		//sw
				p.setValues(position.getRow() + 1, position.getColunm() - 1);
				while(getBoard().positionExist(p) && !getBoard().thereisAPice(p)) {
					mat[p.getRow()][p.getColunm()] = true;
					p.setValues(p.getRow() + 1, p.getColunm() - 1);
				}
				if(getBoard().positionExist(p) && isThereAnyPossibleMove(p)) {
					mat[p.getRow()][p.getColunm()] = true;
				}
				
				
		return mat;
	}

}
