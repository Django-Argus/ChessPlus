package net.argus.chessplus.core;

import java.util.Map;

import net.argus.chessplus.core.pieces.Bishop;
import net.argus.chessplus.core.pieces.ChessPiece;
import net.argus.chessplus.core.pieces.King;
import net.argus.chessplus.core.pieces.Knight;
import net.argus.chessplus.core.pieces.Pawn;
import net.argus.chessplus.core.pieces.PieceColor;
import net.argus.chessplus.core.pieces.Queen;
import net.argus.chessplus.core.pieces.Rook;

public class BasicChessBoard extends ChessBoardDefault {

	@Override
	public void init(Map<Location, ChessPiece> map) {
		map.put(Location.get("a1"), new Rook(PieceColor.WHITE));
		map.put(Location.get("b1"), new Knight(PieceColor.WHITE));
		map.put(Location.get("c1"), new Bishop(PieceColor.WHITE));
		map.put(Location.get("d1"), new Queen(PieceColor.WHITE));
		map.put(Location.get("e1"), new King(PieceColor.WHITE));
		map.put(Location.get("f1"), new Bishop(PieceColor.WHITE));
		map.put(Location.get("g1"), new Knight(PieceColor.WHITE));
		map.put(Location.get("h1"), new Rook(PieceColor.WHITE));
		
		map.put(Location.get("a2"), new Pawn(PieceColor.WHITE));
		map.put(Location.get("b2"), new Pawn(PieceColor.WHITE));
		map.put(Location.get("c2"), new Pawn(PieceColor.WHITE));
		map.put(Location.get("d2"), new Pawn(PieceColor.WHITE));
		map.put(Location.get("e2"), new Pawn(PieceColor.WHITE));
		map.put(Location.get("f2"), new Pawn(PieceColor.WHITE));
		map.put(Location.get("g2"), new Pawn(PieceColor.WHITE));
		map.put(Location.get("h2"), new Pawn(PieceColor.WHITE));
		
		
		map.put(Location.get("a8"), new Rook(PieceColor.BLACK));
		map.put(Location.get("b8"), new Knight(PieceColor.BLACK));
		map.put(Location.get("c8"), new Bishop(PieceColor.BLACK));
		map.put(Location.get("d8"), new Queen(PieceColor.BLACK));
		map.put(Location.get("e8"), new King(PieceColor.BLACK));
		map.put(Location.get("f8"), new Bishop(PieceColor.BLACK));
		map.put(Location.get("g8"), new Knight(PieceColor.BLACK));
		map.put(Location.get("h8"), new Rook(PieceColor.BLACK));
		
		map.put(Location.get("a7"), new Pawn(PieceColor.BLACK));
		map.put(Location.get("b7"), new Pawn(PieceColor.BLACK));
		map.put(Location.get("c7"), new Pawn(PieceColor.BLACK));
		map.put(Location.get("d7"), new Pawn(PieceColor.BLACK));
		map.put(Location.get("e7"), new Pawn(PieceColor.BLACK));
		map.put(Location.get("f7"), new Pawn(PieceColor.BLACK));
		map.put(Location.get("g7"), new Pawn(PieceColor.BLACK));
		map.put(Location.get("h7"), new Pawn(PieceColor.BLACK));
	}

}
