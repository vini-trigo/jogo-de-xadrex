package chess;

import boardgame.position;

public class Chessposition {
	
	private char column;
	private int row;
	
	
	public Chessposition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new chessException("Error instantiation ChessPosition");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected position toPosition() {
		return new position(8 - row, column - 'a');
	}
	
	protected static Chessposition fromChessposition(position ps) {
		return new Chessposition((char)('a' - ps.getColunm()) , 8 - ps.getRow());
	}

	@Override
	public String toString() {
		return "" + column + row;
	}
	
	
}
