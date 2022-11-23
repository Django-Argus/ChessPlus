package net.argus.chessplus.core.pieces;

import net.argus.chessplus.core.ChessBoard;
import net.argus.chessplus.core.Location;

public class Knight extends ChessPiece {

	public Knight(PieceColor color) {
		super(Pieces.KNIGHT, color);
	}

	@Override
	public boolean isMove(Location currentLoc, Location newLoc) {
		return true;
	}

	@Override
	public boolean move(Location currentLoc, Location newLoc, ChessBoard board) {
		// TODO Auto-generated method stub
		return false;
	}

}
