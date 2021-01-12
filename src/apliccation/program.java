package apliccation;

import java.util.Scanner;

import chess.ChessPiece;
import chess.Chessposition;
import chess.chessMatch;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		chessMatch f = new chessMatch();
		
		while (true) {
			UI.printBoard(f.getPieces());
			System.out.println();
			System.out.println("Source: ");
			Chessposition source = UI.readChessPosition(sc);
			System.out.println();
			
			System.out.println("Target: ");
			Chessposition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = f.performChessMove(source, target);
		}
	}

}
