package boardgame;

public class piece {

	protected position position;
	private board board;
	
	public piece(boardgame.board board) {
		this.board = board;
		position = null;
	}

	protected board getBoard() {
		return board;
	}
	
	
}
