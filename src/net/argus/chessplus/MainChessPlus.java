package net.argus.chessplus;

import net.argus.chessplus.core.BasicChessBoard;
import net.argus.chessplus.core.ChessBoard;
import net.argus.chessplus.core.Location;
import net.argus.exception.InstanceException;
import net.argus.instance.CardinalProgram;
import net.argus.instance.Program;

@Program(instanceName = "chess-plus")
public class MainChessPlus extends CardinalProgram {

	@Override
	public void main(String[] args) throws InstanceException {
		/*ChessEvent.init();
		
		
		ChessPFrame frame = new ChessPFrame();
		
		frame.setVisible(true);
		*/
		ChessBoard b = new ChessBoard(new BasicChessBoard());
		b.move(Location.get("a2"), Location.get("b3"));		
	}

}
