package net.argus.chessplus.core.pieces;

import java.awt.Point;

import net.argus.chessplus.core.ChessBoard;
import net.argus.chessplus.core.Location;

public class Pawn extends ChessPiece {

	public Pawn(PieceColor color) {
		super(Pieces.PAWN, color);
	}

	@Override
	public boolean isMove(Location currentLoc, Location newLoc) {
		Point cur = currentLoc.getPosition();
		Point ne = newLoc.getPosition();
		
		if((cur.x - 1 == ne.x || cur.x + 1 == ne.x) && (getColor()==PieceColor.WHITE?cur.y+1==ne.y:cur.y-1==ne.y))
			return true;

		if(cur.y == 2) {
			if(newLoc.getLine() == currentLoc.getLine() + 2)
				return true;
		}
		
		if(newLoc.getLine() == currentLoc.getLine() + 1)
			return true;
		
		return false;
	}

	@Override
	protected boolean move(Location currentLoc, Location newLoc, ChessBoard board) {
		Point cur = currentLoc.getPosition();
		Point ne = newLoc.getPosition();
		
		if(cur.x != ne.x) {
			ChessPiece p = board.getPiece(newLoc);
			if(p != null) {
				board.setPiece(newLoc, this);
				return true;
			}	
		}
		
		switch(getColor()) {
			case BLACK:
				if(board.getPiece(newLoc) == null)
					if(cur.y - ne.y == 1) {
						board.setPiece(newLoc, this);
						return true;
					}else
						if(board.getPiece(new Location(newLoc.getColumn(), cur.y - 1)) == null) {
							board.setPiece(newLoc, this);
							return true;
						}
				break;
				
			case WHITE:
				if(board.getPiece(newLoc) == null)
					if(ne.y - cur.y == 1) {
						board.setPiece(newLoc, this);
						return true;
					}else
						if(board.getPiece(new Location(newLoc.getColumn(), cur.y + 1)) == null) {
							board.setPiece(newLoc, this);
							return true;
						}
				break;
		}
		
		return false;
	}

}
