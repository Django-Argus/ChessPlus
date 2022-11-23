package net.argus.chessplus.core.pieces;

import java.awt.Point;

import net.argus.chessplus.core.BoardCell;
import net.argus.chessplus.core.ChessBoard;
import net.argus.chessplus.core.Location;

public class Rook extends ChessPiece {

	public Rook(PieceColor color) {
		super(Pieces.ROOK, color);
	}

	@Override
	public boolean isMove(Location currentLoc, Location newLoc) {
		Point cur = currentLoc.getPosition();
		Point ne = newLoc.getPosition();
		
		if((cur.x == ne.x && cur.y != ne.y) || (cur.x != ne.x && cur.y == ne.y))
			return true;
		
		return false;
	}

	@Override
	protected boolean move(Location currentLoc, Location newLoc, ChessBoard board) {
		Point cur = currentLoc.getPosition();
		Point ne = newLoc.getPosition();
		
		if(cur.x == ne.x) {
			int s = cur.x>ne.x?ne.x:cur.x;
			int e = cur.x<ne.x?ne.x:cur.x;
			for(int i = s; i < e; i++) {
				BoardCell cell = board.getCell(new Location(Location.COLUMNS[i], cur.x));
				if(cell == null)
					continue;
				
				if(cell.getPiece() != null)
					return false;
			}
		}else if(cur.y == ne.y) {
			int s = cur.y>ne.y?ne.y:cur.y;
			int e = cur.y<ne.y?ne.y:cur.y;
			for(int i = s; i < e; i++) {
				BoardCell cell = board.getCell(new Location(Location.COLUMNS[cur.x], i));
				if(cell == null)
					continue;
				
				if(cell.getPiece() != null)
					return false;
			}
		}
		
		board.setPiece(newLoc, this);
		return true;
	}

}
