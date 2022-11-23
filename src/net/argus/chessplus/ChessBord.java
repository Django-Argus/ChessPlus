package net.argus.chessplus;

import java.util.HashMap;
import java.util.Map;

import net.argus.chessplus.gui.Location;
import net.argus.chessplus.gui.piece.Piece;

public class ChessBord {
	
	private Map<Location, Piece> map = new HashMap<Location, Piece>();
	
	public ChessBord() {
		
	}
	
	public void add(Location loc, Piece piece) {
		map.put(loc, piece);
	}
	
	public class Normal extends ChessBord {
		
	}

}
