package net.argus.chessplus.gui.piece;

import net.argus.chessplus.gui.Cell;

public class Pawn extends Piece {

	public Pawn(PieceColor color) {
		super(PieceImage.getImage(color, PieceName.PAWN, Cell.HEIGHT));
	}

}
