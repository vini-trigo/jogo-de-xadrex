package boardgame;

public class position {

	private Integer row;
	private Integer colunm;
	
	
	public position(Integer row, Integer colunm) {
		this.row = row;
		this.colunm = colunm;
	}


	public Integer getRow() {
		return row;
	}


	public void setRow(Integer row) {
		this.row = row;
	}


	public Integer getColunm() {
		return colunm;
	}


	public void setColunm(Integer colunm) {
		this.colunm = colunm;
	}


	@Override
	public String toString() {
		return row + ", " + colunm;
	}
	
	
}
