package net.argus.chessplus;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.argus.chessplus.core.board.ChessBoard;
import net.argus.chessplus.core.pieces.ChessPiece;
import net.argus.chessplus.core.team.Team;
import net.argus.chessplus.ui.ChessFrame;
import net.argus.cjson.CJSON;
import net.argus.cjson.CJSONParser;
import net.argus.exception.InstanceException;
import net.argus.instance.CardinalProgram;
import net.argus.instance.Program;
import net.argus.pear.client.ClientPear;
import net.argus.pear.client.event.PearListener;
import net.argus.system.ExitCode;
import net.argus.system.UserSystem;
import net.argus.util.ThreadManager;
import net.argus.util.debug.Debug;

@Program(instanceName = "chess-plus")
public class MainChess extends CardinalProgram {
	
	private ChessFrame fen;
	private ClientPear pear;
	private GUI gui;
	
	@Override
	public void main(String[] args) throws InstanceException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		gui = new GUI(this);
		fen = new ChessFrame();
		
		String host = UserSystem.getProperty("host");
		int port = UserSystem.getIntegerProperty("port");
		
		if(host == null || host.equals("") || port < 0) {
			Debug.log("Host or port are null");
			JOptionPane.showMessageDialog(null, "Host or port are null", "Error", JOptionPane.ERROR_MESSAGE);
			UserSystem.exit(ExitCode.ERROR);
		}
		
		try {
			pear = new ClientPear(host, port);
			gui.showChooseDialog(fen);
		}catch(UnknownHostException e) {e.printStackTrace();}
	}
	
	private PearListener getDefaultPearListener() {
		return (e) -> {
			CJSON cjson = CJSONParser.getCJSON(e.getMessage());
			
			if(cjson.getInt("type") == PackageChess.CONNECTION) {
				Team t = Team.BLACK;
				if(cjson.getString("team").toLowerCase().equals("white"))
					t = Team.WHITE;
				
				try {
					Game game = new Game(this, pear, t);
					pear.addPearListener(game.getPearListener());
					gui.showGameFrame(fen, game);
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
			}
		};
	}
	
	public void start(String team) throws NoSuchAlgorithmException, InvalidKeySpecException {
		try {
			pear.open("team", team);
			pear.addPearListener(getDefaultPearListener());
		}catch(IOException e) {
			Debug.log("No server avaliable");
			JOptionPane.showMessageDialog(fen, "No server avaliable at " + pear.getHost().getCanonicalHostName() + ":" + pear.getPort(), "Error", JOptionPane.ERROR_MESSAGE);
			UserSystem.exit(ExitCode.VALID);
		}
		gui.showWaitingDialog(fen);
	}
	
	private String promote = "";
	
	public String promote(ChessBoard board, ChessPiece piece) {
		gui.showPromoteDialog(fen, piece.getTeam());

		while(promote == null || promote.equals(""))
			ThreadManager.sleep(250);
		
		String temp = new String(promote.toCharArray());
		promote = "";
		
		try {pear.send(PackageChess.getPromotePackage(temp));}
		catch(IOException e) {e.printStackTrace();}
		
		return temp;
	}
	
	protected ActionListener getPromoteActionListener(JDialog dial) {
		return (e) -> {
			JButton but = (JButton) e.getSource();
			promote = but.getName();
			fen.setEnabled(true);
			dial.setVisible(false);
		};
	}
	
	public void endGame(boolean victory, boolean mate) {
		gui.showEndGameDialog(fen, victory, mate);
	}

}
