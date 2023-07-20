package net.argus.chessplus;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.argus.chessplus.core.team.Team;
import net.argus.chessplus.ui.piece.PieceImage;
import net.argus.gui.LoadingLabel;

public class GUI {
	
	private static Font font = new Font("roboto", Font.PLAIN, 16);

	private MainChess main;
	
	
	public GUI(MainChess main) {
		this.main = main;
	}
	
	public void showChooseDialog(JFrame fen) {
		JPanel pan = new JPanel();
		
		GridLayout layout = new GridLayout(2, 3);
		
		pan.setLayout(layout);
		JButton black = new JButton(new ImageIcon(PieceImage.getImage(true, Team.BLACK, "king", 50)));
		JButton random = new JButton(new ImageIcon(PieceImage.getImage(true, Team.BLACK, "queen", 50)));
		JButton white = new JButton(new ImageIcon(PieceImage.getImage(true, Team.WHITE, "king", 50)));
		
		JPanel textPanB = new JPanel(new FlowLayout());
		JPanel textPanR = new JPanel(new FlowLayout());
		JPanel textPanW = new JPanel(new FlowLayout());
		
		JLabel blackL = new JLabel("black");
		JLabel randomL = new JLabel("random");
		JLabel whiteL = new JLabel("white");
		
		blackL.setFont(font);
		randomL.setFont(font);
		whiteL.setFont(font);
		
		black.setName("black");
		random.setName("random");
		white.setName("white");
		
		black.addActionListener(getChooseActionListener());
		random.addActionListener(getChooseActionListener());
		white.addActionListener(getChooseActionListener());
		
		textPanB.add(blackL);
		textPanR.add(randomL);
		textPanW.add(whiteL);
		
		
		pan.add(black);
		pan.add(random);
		pan.add(white);
		
		pan.add(textPanB);
		pan.add(textPanR);
		pan.add(textPanW);
		
		fen.setContentPane(pan);
		
		fen.setSize(300, 150);
		fen.setResizable(false);
		fen.setLocationRelativeTo(null);
		fen.setVisible(true);
		fen.repaint();
	}
	
	public void showPromoteDialog(JFrame fen, Team team) {
		JDialog dial = new JDialog(fen);
		JPanel pan = new JPanel();
		
		GridLayout layout = new GridLayout(1, 4);
		
		pan.setLayout(layout);
		
		JButton rook = new JButton(new ImageIcon(PieceImage.getImage(true, team, "rook", 50)));
		JButton knight = new JButton(new ImageIcon(PieceImage.getImage(true, team, "knight", 50)));
		JButton bishop = new JButton(new ImageIcon(PieceImage.getImage(true, team, "bishop", 50)));
		JButton queen = new JButton(new ImageIcon(PieceImage.getImage(true, team, "queen", 50)));
		
		rook.setName("rook");
		knight.setName("knight");
		bishop.setName("bishop");
		queen.setName("queen");
		
		rook.addActionListener(main.getPromoteActionListener(dial));
		knight.addActionListener(main.getPromoteActionListener(dial));
		bishop.addActionListener(main.getPromoteActionListener(dial));
		queen.addActionListener(main.getPromoteActionListener(dial));
		
		pan.add(rook);
		pan.add(knight);
		pan.add(bishop);
		pan.add(queen);
		
		dial.setContentPane(pan);
		
		dial.setTitle("Promotion");
		dial.setSize(350, 150);
		dial.setResizable(false);
		dial.setAlwaysOnTop(true);
		dial.setLocationRelativeTo(fen);
		
		fen.setEnabled(false);
		dial.setVisible(true);
	}
	
	public void showWaitingDialog(JFrame fen) {
		JPanel pan = new JPanel();
		
		LoadingLabel l = new LoadingLabel("Waiting for player", false);
		l.setFont(font.deriveFont(Font.BOLD).deriveFont(20f));
		l.start();
		pan.add(l);
		
		fen.setContentPane(pan);
		
		fen.setSize(300, 150);
		fen.setResizable(false);
		fen.setVisible(true);
		fen.repaint();
	}
	
	public void showGameFrame(JFrame fen, Game game) {
		fen.setContentPane(game.getBoardPanel());
		
		fen.setSize(700, 700);
		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setVisible(true);
		fen.repaint();
	}
	
	private ActionListener getChooseActionListener() {
		return (e) -> {
			JButton b = (JButton) e.getSource();
			try {
				main.start(b.getName());
			}catch(NoSuchAlgorithmException | InvalidKeySpecException e1) {
				e1.printStackTrace();
			}
		};
	}

}
