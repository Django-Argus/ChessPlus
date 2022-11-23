package net.argus.chessplus.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.argus.chessplus.core.pieces.ChessPiece;

public class ChessBoard {
	
	private List<BoardCell> cells = new ArrayList<BoardCell>();
	
	public ChessBoard(ChessBoardDefault def) {
		for(int y = 8; y > 0; y--)
			for(int x = 0; x < 8; x++)
				cells.add(new BoardCell(new Location(Location.COLUMNS[x], y)));
		
		for(Entry<Location, ChessPiece> e : def.getMap().entrySet())
			pop(e.getKey(), e.getValue());
	}
	
	public void pop(Location loc, ChessPiece piece) {
		BoardCell cell = getCell(loc);
		if(cell == null)
			return;

		cell.setPiece(piece);
	}
	
	public BoardCell getCell(Location loc) {
		for(BoardCell b : cells)
			if(b.getLocation().equals(loc))
				return b;
		return null;
	}
	
	public void setPiece(Location loc, ChessPiece piece) {
		BoardCell cell = getCell(loc);
		if(cell == null)
			return;
		
		cell.setPiece(piece);
	}
	
	public ChessPiece getPiece(Location loc) {
		BoardCell cell = getCell(loc);
		if(cell == null)
			return null;
		
		return cell.getPiece();
	}
	
	public void move(Location currentLoc, Location newLoc) {
		BoardCell cell = getCell(currentLoc);
		
		if(cell.getPiece() == null)
			return;
		
		cell.getPiece().changePosition(currentLoc, newLoc, this);
	}
	

}
