package net.argus.chessplus;

import java.io.IOException;
import java.net.UnknownHostException;

import net.argus.chessplus.core.Location;
import net.argus.chessplus.core.board.ChessBoard;
import net.argus.chessplus.core.board.basic.BasicChessBoard;
import net.argus.chessplus.core.board.basic.BasicChessPromote;
import net.argus.chessplus.core.event.ChessEvent;
import net.argus.chessplus.core.event.ChessListener;
import net.argus.chessplus.core.pieces.Bishop;
import net.argus.chessplus.core.pieces.ChessPiece;
import net.argus.chessplus.core.pieces.Knight;
import net.argus.chessplus.core.pieces.Queen;
import net.argus.chessplus.core.pieces.Rook;
import net.argus.chessplus.core.team.Team;
import net.argus.chessplus.ui.ChessBoardPanel;
import net.argus.cjson.CJSON;
import net.argus.cjson.CJSONParser;
import net.argus.pear.client.ClientPear;
import net.argus.pear.client.event.PearEvent;
import net.argus.pear.client.event.PearListener;
import net.argus.util.ThreadManager;

public class Game {
	
	private MainChess main;
	private ClientPear pear;
	
	private Team yTeam;
	private ChessBoardPanel board;
	
	private String promote = "";
	
	public Game(MainChess main, ClientPear pear, Team yTeam, String host, int port) throws UnknownHostException {
		this.main = main;
		this.pear = pear;
		this.yTeam = yTeam;
		this.board = new ChessBoardPanel(new ChessBoard(new BasicChessBoard(getBasicChessPromote())), 80, yTeam);
		this.board.getBoard().addChessListener(getChessListener());

	}
	
	private BasicChessPromote getBasicChessPromote() {
		return (board, piece) -> {
			if(piece.getTeam().equals(yTeam))
				promote = main.promote(board, piece);
			else
				while(promote == null || promote.equals(""))
					ThreadManager.sleep(250);
			
			
			ChessPiece p = null;
			if(promote.equals("queen"))
				p = new Queen(board);
			else if(promote.equals("rook"))
				p = new Rook(board);
			else if(promote.equals("bishop"))
				p = new Bishop(board);
			else if(promote.equals("knight"))
				p = new Knight(board);
			
			promote = "";
			
			p.setTeam(piece.getTeam());
			return p;
			
		};
	}
	
	protected PearListener getPearListener() {
		return new PearListener() {
			
			@Override
			public void newMessage(PearEvent e) {
				CJSON cjson = CJSONParser.getCJSON(e.getMessage());
				if(cjson.getInt("type") == PackageChess.MOVE)
					board.move(new Location(cjson.getString("before")), new Location(cjson.getString("after")));
				else if(cjson.getInt("type") == PackageChess.PROMOTE)
					promote = cjson.getString("piece");
				
			}
		};
	}
	
	private ChessListener getChessListener() {
		return new ChessListener() {
			
			@Override
			public void move(ChessEvent e) {
				if(e.getSource().getTeam().equals(yTeam)) {
					try {
						pear.send(PackageChess.getMovePackage(e.getBegin(), e.getSource().getLocation()));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			
			@Override
			public void endGame(ChessEvent e) {
				
			}
			
			@Override
			public void check(ChessEvent e) {
				
			}
			
			@Override
			public void castel(ChessEvent e) {
				
			}
		};
	}
	
	public ChessBoard getBoard() {
		return board.getBoard();
	}
	
	public ChessBoardPanel getBoardPanel() {
		return board;
	}
	
	public Team getTeam() {
		return yTeam;
	}

}
