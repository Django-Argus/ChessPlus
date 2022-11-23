package net.argus.chessplus.gui;

import java.awt.Point;

import net.argus.util.ArrayManager;

public class Location {
	
	public static final char[] COLUMNS = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	
	private char line;
	private int column;
	
	public Location(char line, int column) {
		this.line = line;
		this.column = column;
	}
	
	public int getColumn() {
		return column;
	}
	
	public char getLine() {
		return line;
	}
	
	public Point getPosition() {
		return new Point(ArrayManager.indexOf(COLUMNS, line), 8-column);
	}
	
	@Override
	public String toString() {
		return "[" + line + column + "]";
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
