package net.argus.chessplus;

import net.argus.chessplus.gui.ChessPFrame;
import net.argus.exception.InstanceException;
import net.argus.instance.CardinalProgram;
import net.argus.instance.Program;

@Program(instanceName = "chess-plus")
public class MainChessPlus extends CardinalProgram {

	@Override
	public void main(String[] args) throws InstanceException {
		
		ChessEvent.init();
		
		ChessPFrame frame = new ChessPFrame();
		
		frame.setVisible(true);
	}

}
