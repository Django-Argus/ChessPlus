package net.argus.chessplus.core;

import java.awt.Point;

import net.argus.util.ArrayManager;

public class Location {
	
	public static final char[] COLUMNS = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	
	private char column;
	private int line;
	
	public Location(char column, int line) {
		this.column = column;
		this.line = line;
	}
	
	public char getColumn() {
		return column;
	}
	
	public int getLine() {
		return line;
	}
	
	public Point getPosition() {
		return new Point(ArrayManager.indexOf(COLUMNS, column), 8-line);
	}
	
	public static Location get(String loc) {
		if(loc.length() != 2)
			throw new IllegalArgumentException(loc + " (Length != 2)");
		
		char column = loc.charAt(0);
		int line = Integer.valueOf(String.valueOf(loc.charAt(1)));
		
		return new Location(column, line);
	}
	
	@Override
	public String toString() {
		return "[" + column + line + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Location) {
			Location loc = (Location) obj;
			return loc.line == line && loc.column == column;
		}
		
		return super.equals(obj);
	}

}
