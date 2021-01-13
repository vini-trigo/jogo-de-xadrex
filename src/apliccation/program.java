package apliccation;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.Chessposition;
import chess.chessException;
import chess.chessMatch;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		chessMatch f = new chessMatch();
		
		while (true) {
			try {
				UI.clearScreen();	
				UI.printMatch(f);
				System.out.println();
				System.out.println("Source: ");
				Chessposition source = UI.readChessPosition(sc);
				System.out.println();
				
				boolean[][] possibleMovies = f.possibleMovies(source);
				UI.clearScreen();
				UI.printBoard(f.getPieces(), possibleMovies);

				System.out.println("Target: ");
				Chessposition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = f.performChessMove(source, target);
			}	
			catch(chessException d) {
				System.out.println(d.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException d) {
				System.out.println(d.getMessage());
				sc.nextLine();
			}
		}
	}

}
