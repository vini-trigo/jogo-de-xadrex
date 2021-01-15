package chess;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.board;
import boardgame.piece;
import boardgame.position;
import chess.pieces.copy.Bishop;
import chess.pieces.copy.Knigth;
import chess.pieces.copy.Pawn;
import chess.pieces.copy.Queen;
import chess.pieces.copy.Rook;
import chess.pieces.copy.king;

public class chessMatch {

	private int turn;
	private Color currentPlayer;
	private board board;
	private boolean check;
	private boolean checkMate;
	private ChessPiece promoted;

	private List<piece> piOntheBoard = new ArrayList<>();
	private List<piece> capPieces = new ArrayList<>();

	public chessMatch() {
		board = new board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}

	public int getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean getCheck() {
		return check;
	}

	public boolean getCheckMate() {
		return checkMate;
	}
	
	public ChessPiece getPromoted() {
		return promoted;
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piec(i, j);
			}
		}
		return mat;
	}

	public boolean[][] possibleMovies(Chessposition sposicion) {
		position ps = sposicion.toPosition();
		validateSourceposition(ps);
		return board.piece(ps).possibleMoves();
	}

	public ChessPiece performChessMove(Chessposition sourcePosition, Chessposition targetPosition) {
		position source = sourcePosition.toPosition();
		position target = targetPosition.toPosition();
		validateSourceposition(source);
		validateTargetPosition(source, target);
		piece capturedPiece = makeMov(source, target);
		
		if (testCheck(currentPlayer)) {
			unduMove(source, target, capturedPiece);
			throw new chessException("You not put in check tourself");
		}

		ChessPiece movedpiece = (ChessPiece)board.piece(target);
		
		promoted = null;
		if(movedpiece instanceof Pawn) {
			if((movedpiece.getColor() == Color.WHITE && target.getRow() == 0) || (movedpiece.getColor() == Color.BLACK && target.getRow() == 7)) {
				promoted = (ChessPiece)board.piece(target);
				promoted = replacePromoted("Q");
			}
		}
		
		check = (testCheck(oponent(currentPlayer))) ? true : false;

		if(testCheckMate(oponent(currentPlayer))) {
			checkMate = true;
		}else {
			nextTurn();	
		}
		
		return (ChessPiece) capturedPiece;
	}

	public ChessPiece replacePromoted(String type) {
		if(promoted == null) {
			throw new IllegalStateException("Nao a peca para ser promovida");
		}
		if(!type.equals("B") && type.equals("M") && type.equals("H") && type.equals("Q")) {
			throw new InvalidParameterException("Invalid type for promotion");
		}
		position pos = promoted.getChessPosition().toPosition();
		piece p = board.removePiece(pos);
		piOntheBoard.remove(p);
		
		ChessPiece newpiece = newpiece(type, promoted.getColor());
		board.placePiece(newpiece, pos);
		piOntheBoard.add(newpiece);
		
		return newpiece;
	}
	
	private ChessPiece newpiece(String type, Color cor) {
		if(type.equals("B")) return new Bishop(board, cor);
		if(type.equals("H")) return new Knigth(board, cor);
		if(type.equals("Q")) return new Queen(board, cor);
		return new Rook(board, cor);	
	}

	private piece makeMov(position source, position target) {
		ChessPiece p = (ChessPiece)board.removePiece(source);
		p.increaseMoveCount();
		piece captuPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		if (captuPiece != null) {
			piOntheBoard.remove(captuPiece);
			capPieces.add(captuPiece);
		}

		return captuPiece;
	}

	private void unduMove(position source, position target, piece capiece) {
		ChessPiece p = (ChessPiece) board.removePiece(target);
		p.decreaseMoveCount();
		board.placePiece(p, source);

		if (capiece != null) {
			board.placePiece(capiece, target);
			capPieces.remove(capiece);
			piOntheBoard.add(capiece);
		}
	}

	private void validateSourceposition(position piece) {
		if (!board.thereisAPice(piece)) {
			throw new chessException("There is not piece on source position");
		}
		if (currentPlayer != ((ChessPiece) board.piece(piece)).getColor()) {
			throw new chessException("A peca escolhida nao e sua");
		}
		if (!board.piece(piece).IsThereAnyPossibleMove()) {
			throw new chessException("There is not possible moves for the chosen piece.");
		}
	}

	private void validateTargetPosition(position source, position target) {
		// TODO Auto-generated method stub
		if (!board.piece(source).possibleMoves(target)) {
			throw new chessException("A pessa escolhida nao pode mover para a posi��o escolhida");
		}
	}

	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	private Color oponent(Color cor) {
		return (cor == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	private ChessPiece king(Color cor) {
		List<piece> list = piOntheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == cor)
				.collect(Collectors.toList());
		for (piece p : list) {
			if (p instanceof king) {
				return (ChessPiece) p;
			}
		}
		throw new IllegalStateException("Nao tem  rei no jogo");
	}

	private boolean testCheck(Color cor) {
		position kingPosition = king(cor).getChessPosition().toPosition();
		List<piece> oponentPiece = piOntheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == oponent(cor))
				.collect(Collectors.toList());
		for (piece p : oponentPiece) {
			boolean[][] mat = p.possibleMoves();
			if (mat[kingPosition.getRow()][kingPosition.getColunm()]) {
				return true;
			}
		}
		return false;
	}

	private boolean testCheckMate(Color cor) {
		if (!testCheck(cor)) {
			return false;
		}
		List<piece> list = piOntheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == cor).collect(Collectors.toList());
		for (piece p : list) {
			boolean[][] mat = p.possibleMoves();
			for (int i = 0; i < board.getRows(); i++) {
				for (int j = 0; j < board.getRows(); j++) {
					if (mat[i][j]) {
						position source = ((ChessPiece) p).getChessPosition().toPosition();
						position target = new position(i, j);
						piece cpiece = makeMov(source, target);
						boolean testCheck = testCheck(cor);
						unduMove(source, target, cpiece);
						if(!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new Chessposition(column, row).toPosition());
		piOntheBoard.add(piece);
	}

	private void initialSetup() {
		 placeNewPiece('a', 1, new Rook(board, Color.WHITE));
	        placeNewPiece('b', 1, new Knigth(board, Color.WHITE));
	        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
	        placeNewPiece('d', 1, new Queen(board, Color.WHITE));
	        placeNewPiece('e', 1, new king(board, Color.WHITE));
	        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
	        placeNewPiece('g', 1, new Knigth(board, Color.WHITE));
	        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
	        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
	        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
	        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
	        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
	        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
	        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
	        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
	        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));

	        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
	        placeNewPiece('b', 8, new Knigth(board, Color.BLACK));
	        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
	        placeNewPiece('d', 8, new Queen(board, Color.BLACK));
	        placeNewPiece('e', 8, new king(board, Color.BLACK));
	        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
	        placeNewPiece('g', 8, new Knigth(board, Color.BLACK));
	        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
	        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
	        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
	        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
	        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
	        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
	        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
	        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
	        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));
		}
	}

