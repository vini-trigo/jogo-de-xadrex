package apliccation;

import boardgame.board;
import boardgame.position;
import chess.chessMatch;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		chessMatch f = new chessMatch();
		
		UI.printBoard(f.getPieces());
	}

}
