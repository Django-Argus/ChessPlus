package net.argus.chessplus.server;

import java.io.IOException;
import java.util.List;

import net.argus.beta.com.CardinalSocket;
import net.argus.chessplus.PackageChess;
import net.argus.chessplus.core.team.Team;
import net.argus.cjson.CJSON;
import net.argus.pear.server.Dispacher;
import net.argus.pear.server.Link;
import net.argus.pear.server.WaitingList;

public class ChessDispacher extends Dispacher {
	
	public static final int WHITE = 0;
	public static final int BLACK = 1;

	public ChessDispacher() {
		super(2, 1);
	}

	@Override
	public int dispatch(CJSON parameters, WaitingList waiting) {
		if(parameters.getString("team").toLowerCase().equals("random")) {
			int sizeW = waiting.getLists().get(0).size();
			int sizeB = waiting.getLists().get(1).size();
			
			if(sizeW < sizeB)
				return WHITE;
			
			return BLACK;
		}else if(parameters.getString("team").toLowerCase().equals(Team.BLACK.getName().toLowerCase()))
			return BLACK;
		return WHITE;
	}

	@Override
	public Link link(List<CardinalSocket> lists) {
		if(lists.get(0) == null || lists.get(1) == null)
			return null;
		
		try {
			lists.get(0).send(PackageChess.getConnectionPackage(Team.WHITE));
			lists.get(1).send(PackageChess.getConnectionPackage(Team.BLACK));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return new Link(lists.get(0), lists.get(1));
	}

}
