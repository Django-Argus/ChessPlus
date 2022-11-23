package net.argus.chessplus.core.pieces;

import java.awt.Point;

import net.argus.chessplus.core.ChessBoard;
import net.argus.chessplus.core.Location;

public class Bishop extends ChessPiece {

	public Bishop(PieceColor color) {
		super(Pieces.BISHOP, color);
	}

	@Override
	public boolean isMove(Location currentLoc, Location newLoc) {
		Point cur = currentLoc.getPosition();
		Point ne = newLoc.getPosition();
		
		if(cur.y - ne.y == cur.x - ne.x)
			return true;
		
		return false;
	}

	@Override
	protected boolean move(Location currentLoc, Location newLoc, ChessBoard board) {
		// TODO Auto-generated method stub
		return false;
	}

}
