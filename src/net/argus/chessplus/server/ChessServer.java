package net.argus.chessplus.server;

import java.io.IOException;

import net.argus.exception.InstanceException;
import net.argus.instance.CardinalProgram;
import net.argus.instance.Program;
import net.argus.pear.server.ServerPear;

@Program(instanceName = "server-chess")
public class ChessServer extends CardinalProgram {

	@Override
	public void main(String[] args) throws InstanceException {
		try {
			ServerPear pear = new ServerPear(2354, new ChessDispacher());
			
			pear.open();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
