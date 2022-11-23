package net.argus.chessplus.gui.piece;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PieceImage {
	
	public static final String NO_SHADOW = "no_shadow";
	public static final String WITH_SHADOW = "with_shadow";
	
	public static final boolean SHADOW = true;
	
	public static Image getImage(PieceColor pieceColor, PieceName name, int scale) {
		return getImage(SHADOW, pieceColor, name, scale);
	}
	
	public static Image getImage(boolean shadow, PieceColor pieceColor, PieceName name, int scale) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(getImageURL(shadow, pieceColor, name).toURI()));
			return img.getScaledInstance(scale * img.getWidth() / img.getHeight(), scale, Image.SCALE_SMOOTH);
		} catch (IOException | URISyntaxException e) {e.printStackTrace();}
		return null;
	}
	
	public static URL getImageURL(boolean shadow, PieceColor pieceColor, PieceName name) {
		return PieceImage.class.getResource("/res/" + (shadow?WITH_SHADOW:NO_SHADOW) + "/" + pieceColor.getLet() + "_" + name.toString().toLowerCase() + ".png");
	}
	
	public static ImageIcon getImageIcon(boolean shadow, PieceColor pieceColor, PieceName name) {
		return new ImageIcon(getImageURL(shadow, pieceColor, name));
	}
	

}
