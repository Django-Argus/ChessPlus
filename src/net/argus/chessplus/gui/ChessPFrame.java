package net.argus.chessplus.gui;

import javax.swing.JFrame;

public class ChessPFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6711679047347530083L;
	
	private ChessPanel pan = new ChessPanel();
	
	public ChessPFrame() {
		setDefaultCloseOperation(3);
		setSize(700, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		add(pan);
	}
	
	public ChessPanel getChessPanel() {return pan;}
	
}
