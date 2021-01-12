package boardgame;

public class board {

	private Integer rows;
	private Integer columns;
	private piece[][] pieces;
	
	public board(Integer rows, Integer columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public piece piec(Integer rows, Integer column) {
		if (!positionExist(rows, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[rows][column];
	}
	
	public piece piece(position p) {
		if (!positionExist(p	)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[p.getRow()][p.getColunm()];
	}
	
	public void placePiece(piece pie, position ps) {
		if (thereisAPice(ps)) {
			throw new BoardException("There is already a piece on position" +ps);
		}
		pieces[ps.getRow()][ps.getColunm()]=pie;
		pie.position = ps;
	}
	
	private boolean positionExist(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExist(position ps) {
		return positionExist(ps.getRow(), ps.getColunm());
	}
	
	public boolean thereisAPice(position p) {
		if (!positionExist(p)) {
			throw new BoardException("Position not on the board");
		}
		return piece(p) != null;
	}
}
