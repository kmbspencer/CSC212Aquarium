package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class FishList {
	Fish[] fishArray = new Fish[10];
	int x;
	int y;
	public static int WIDTH = 500;
	public static int HEIGHT = 500;

	public FishList() {
		Random rand = new Random();
		
		for(int i=0; i<this.fishArray.length; i++ ) {
			Color rcolor = Color.getHSBColor(rand.nextFloat(), 0.8f, 0.8f);
			int x = 50 + (i*90) % (WIDTH-100);
			int y = 50 + (i*40) % (HEIGHT-100);
			this.fishArray[i] = new Fish(rcolor,x,y,true);
			
		}	
	}
	
	public void draw(Graphics2D g) {
		for(Fish nemo:this.fishArray) {
			nemo.draw(g);
		}
		
	}
	public Fish[] getList() {
		return this.fishArray;
	}
}
