package net.argus.chessplus.gui.piece;

public enum PieceColor {
	
	BLACK("b"), WHITE("w");
	
	String let;
	
	private PieceColor(String let) {
		this.let = let;
	}
	
	public String getLet() {
		return let;
	}	

}
