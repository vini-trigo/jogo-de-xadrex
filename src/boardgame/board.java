package boardgame;

public class board {

	private Integer rows;
	private Integer columns;
	private piece[][] pieces;
	
	public board(Integer rows, Integer columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}
	
	public piece piec(Integer rows, Integer column) {
		return pieces[rows][column];
	}
	
	public piece piece(position p) {
		return pieces[p.getRow()][p.getColunm()];
	}
	
	public void placePiece(piece pie, position ps) {
		pieces[ps.getRow()][ps.getColunm()]=pie;
		pie.position = ps;
	}
}
