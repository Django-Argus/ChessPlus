package net.argus.chessplus;

import net.argus.beta.com.pack.PackageBuilder;
import net.argus.chessplus.core.Location;
import net.argus.chessplus.core.team.Team;

public class PackageChess {
	
	public static final int CONNECTION = 0;
	public static final int MOVE = 1;
	public static final int PROMOTE = 2;
	
	public static String getMovePackage(Location before, Location after) {
		PackageBuilder builder = new PackageBuilder();
		
		builder.addInt(".", "type", MOVE);
		
		builder.addString(".", "before", before.getLocation());
		builder.addString(".", "after", after.getLocation());
		
		return builder.getMainObject().toString();
	}
	
	public static String getConnectionPackage(Team team) {
		PackageBuilder builder = new PackageBuilder();
		
		builder.addInt(".", "type", CONNECTION);
		builder.addString(".", "team", team.getName());
		
		
		return builder.getMainObject().toString();
	}
	
	public static String getPromotePackage(String piece) {
		PackageBuilder builder = new PackageBuilder();
		
		builder.addInt(".", "type", PROMOTE);
		builder.addString(".", "piece", piece);
		
		
		return builder.getMainObject().toString();
	}

}
