package com.ruoli.npc;

import java.util.Random;

public class NPC {
	int x, y;
	Random randomGenerator = new Random();
	
	public NPC(){
	}
	
	public int npcGenerateXPosition(){
		x = randomGenerator.nextInt(3);
		return x;
	}
	
	public int npcGenerateYPosition(){
		y = randomGenerator.nextInt(3);
		return y;
	}

	

}
