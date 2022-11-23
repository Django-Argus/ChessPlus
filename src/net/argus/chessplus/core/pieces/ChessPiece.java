package net.argus.chessplus.core.pieces;

import net.argus.chessplus.core.ChessBoard;
import net.argus.chessplus.core.Location;

public abstract class ChessPiece {
	
	private Pieces piece;
	private PieceColor color;
	
	public ChessPiece(Pieces piece, PieceColor color) {
		this.piece = piece;
		this.color = color;
	}
	
	public Pieces getPiece() {
		return piece;
	}
	
	public PieceColor getColor() {
		return color;
	}
	
	public void changePosition(Location currentLoc, Location newLoc, ChessBoard board) {
		if(isMove(currentLoc, newLoc))
			move(currentLoc, newLoc, board);
	}
	
	public abstract boolean isMove(Location currentLoc, Location newLoc);
	
	protected abstract boolean move(Location currentLoc, Location newLoc, ChessBoard board);

}
