package net.argus.chessplus.core;

import java.util.HashMap;
import java.util.Map;

import net.argus.chessplus.core.pieces.ChessPiece;

public abstract class ChessBoardDefault {
	private Map<Location, ChessPiece> map = new HashMap<Location, ChessPiece>();
	
	public ChessBoardDefault() {
		init(map);
	}
	
	public abstract void init(Map<Location, ChessPiece> map);
	
	public void add(Location loc, ChessPiece piece) {
		map.put(loc, piece);
	}
	
	public Map<Location, ChessPiece> getMap() {
		return map;
	}

}
