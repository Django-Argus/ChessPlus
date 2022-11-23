package net.argus.chessplus.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import net.argus.chessplus.core.Location;
import net.argus.chessplus.gui.piece.Piece;

public class Cell {
	
	public static final int WIDTH = 50;
	public static final int HEIGHT = WIDTH;
	
	public static final Color BLACK = Color.decode("#000000");
	public static final Color WHITE  = Color.decode("#FFFFFF");
	
	private Location loc;
	
	private Piece piece;
	
	public Cell(Location loc) {
		this.loc = loc;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public Point getPosition() {
		return loc.getPosition();
	}
	
	public void draw(Graphics2D g) {
		g.setColor(getColor(getLocation()));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		if(piece != null)
			piece.draw(g);
	}
	
	public static Color getColor(Location loc) {
		Point p = loc.getPosition();
		
		boolean imp = p.x % 2 == 0;
		
		if(imp)
			return p.y % 2 == 0?WHITE:BLACK;
		else
			return p.y % 2 == 0?BLACK:WHITE;
		
	}
	
	@Override
	public String toString() {
		return "cell@" + loc;
	}

}
