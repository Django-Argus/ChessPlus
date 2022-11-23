package net.argus.chessplus;

import java.util.HashMap;
import java.util.Map;

import net.argus.chessplus.gui.Location;
import net.argus.chessplus.gui.piece.Piece;

public abstract class ChessBordDefault {
	
	private Map<Location, Piece> map = new HashMap<Location, Piece>();
	
	public ChessBordDefault() {
		init();
	}
	
	public abstract void init();
	
	public void add(Location loc, Piece piece) {
		map.put(loc, piece);
	}
	
	public void apply() {
		
	}
	
	public class Normal extends ChessBordDefault {

		@Override
		public void init() {
			
		}
		
	}

}
