package net.argus.chessplus.core;

import net.argus.chessplus.core.pieces.ChessPiece;

public class Chess {
	
	private ChessPiece piece;
	
	public Chess(ChessPiece piece) {
		this.piece = piece;
	}
	
	public ChessPiece getPiece() {
		return piece;
	}

}
