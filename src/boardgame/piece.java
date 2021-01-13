package boardgame;

public abstract class piece {

	protected position position;
	private board board;
	
	public piece(boardgame.board board) {
		this.board = board;
		position = null;
	}

	protected board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMoves(position f) {
		return possibleMoves()[f.getRow()][f.getColunm()];
	}
	
	public boolean IsThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
		}
	}
		return false;	
}
}
