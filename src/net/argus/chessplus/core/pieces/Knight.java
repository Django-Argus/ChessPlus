package net.argus.chessplus.core.pieces;

import java.awt.Point;

import net.argus.chessplus.core.ChessBoard;
import net.argus.chessplus.core.Location;

public class Knight extends ChessPiece {

	public Knight(PieceColor color) {
		super(Pieces.KNIGHT, color);
	}

	@Override
	public boolean isMove(Location currentLoc, Location newLoc) {
		Point cur = currentLoc.getPosition();
		Point ne = newLoc.getPosition();
		
		
		
		return true;
	}

	@Override
	public boolean move(Location currentLoc, Location newLoc, ChessBoard board) {
		// TODO Auto-generated method stub
		return false;
	}

}
