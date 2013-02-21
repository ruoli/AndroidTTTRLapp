package com.ruoli.npc;

import java.util.Random;

public class NPC {
	int x, y;
	Random randomGenerator = new Random();
	
	public NPC(){
		npcGenerateXposition();
		npcGenerateYposition();
	}
	
	public int npcGenerateXposition(){
		x = randomGenerator.nextInt(2);
		return x;
	}
	
	public int npcGenerateYposition(){
		y = randomGenerator.nextInt(2);
		return y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	

}
