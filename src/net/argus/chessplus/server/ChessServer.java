package net.argus.chessplus.server;

import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;

import net.argus.exception.InstanceException;
import net.argus.instance.CardinalProgram;
import net.argus.instance.Program;
import net.argus.pear.server.ServerPear;
import net.argus.system.UserSystem;
import net.argus.util.debug.Debug;
import net.argus.util.debug.Info;

@Program(instanceName = "server-chess")
public class ChessServer extends CardinalProgram {

	@Override
	public void main(String[] args) throws InstanceException {
		try {
			ServerPear pear = new ServerPear(UserSystem.getIntegerProperty("port"), new ChessDispacher());
			
			pear.open();
			Debug.log("Pear Server opened at " + InetAddress.getLocalHost().getCanonicalHostName() + ":" + pear.getPort());
		}catch(IOException e) {
			if(e instanceof BindException)
				Debug.log("Port " + UserSystem.getIntegerProperty("port") + " is already used", Info.ERROR);
			else
				e.printStackTrace();
		}
	}
	
}
