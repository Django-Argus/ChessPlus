package net.argus.chessplus;

import java.util.ArrayList;
import java.util.List;

public abstract class Randomizer {
	
	private static List<Randomizer> randomizers = new ArrayList<Randomizer>();
	
	private float luck = 0f;
	
	public Randomizer(float luck) {
		this.luck = luck;
	}
	
	public abstract void choose();
	
	public float getLuck() {
		return luck;
	}
	
	public static Randomizer add(Randomizer randomizer) {randomizers.add(randomizer); return randomizer;}

}
