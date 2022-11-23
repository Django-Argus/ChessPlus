package net.argus.chessplus.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import net.argus.chessplus.core.Location;

public class ChessPanel extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9191295728650605259L;
	
	private List<Cell> cells = new ArrayList<Cell>();
	
	public ChessPanel() {
		for(int y = 8; y > 0; y--)
			for(int x = 0; x < 8; x++)
				cells.add(new Cell(new Location(Location.COLUMNS[x], y)));
	}
	
	public Cell getCell(Location loc) {
		for(Cell cell : cells)
			if(cell.getLocation().equals(loc))
				return cell;
		return null;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for(Cell cell : cells) {
        	int x = 0;
        	int y = 0;
        	
        	x = Cell.WIDTH;
        	if(cell.getPosition().x == 7) {
        		x = -Cell.WIDTH * 7;
        		y = Cell.HEIGHT;
        	}

        	cell.draw(g2d);
        	g2d.translate(x, y);
        }
	}
	
}
