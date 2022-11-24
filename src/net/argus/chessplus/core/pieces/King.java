package net.argus.chessplus.core.pieces;

import java.awt.Point;

import net.argus.chessplus.core.Chess;
import net.argus.chessplus.core.ChessBoard;
import net.argus.chessplus.core.Location;

public class King extends ChessPiece {

	public King(PieceColor color) {
		super(Pieces.KING, color);
	}

	@Override
	public boolean isMove(Location currentLoc, Location newLoc) {
		Point cur = currentLoc.getPosition();
		Point ne = newLoc.getPosition();
		
		if(cur.x - ne.x >= -1 && cur.x - ne.x <= 1 && cur.y - ne.y >= 1 && cur.y - ne.y <= 1)
			return true;
		
		return false;
	}

	@Override
	protected boolean move(Location currentLoc, Location newLoc, ChessBoard board) {
		Point cur = currentLoc.getPosition();
		Point ne = newLoc.getPosition();
		
		return false;
	}
	
	public Chess chess() {
		
	}

}
