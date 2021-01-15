package apliccation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
		List<ChessPiece> cap = new ArrayList<>();
		
		while (!f.getCheckMate()) {
			try {
				UI.clearScreen();	
				UI.printMatch(f, cap);
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
				
				if(capturedPiece != null) {
					cap.add(capturedPiece);
				}
				if(f.getPromoted() != null) {
					System.out.println("Digite a peça que voce quer adicionar (B/N/R/Q)");
					String type = sc.nextLine();
					f.replacePromoted(type);
				}
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
		UI.clearScreen();
		UI.printMatch(f, cap);
	}

}
