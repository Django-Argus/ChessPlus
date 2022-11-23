package net.argus.chessplus.core;

import net.argus.chessplus.core.pieces.ChessPiece;

public class BoardCell {
	
	private Location loc;
	
	private ChessPiece piece;
	
	public BoardCell(Location loc) {
		this.loc = loc;
	}
	
	public void setPiece(ChessPiece piece) {this.piece = piece;}
	
	public Location getLocation() {
		return loc;
	}
	
	public ChessPiece getPiece() {
		return piece;
	}
	
	@Override
	public String toString() {
		return "cell@" + loc;
	}

}
