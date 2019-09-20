package edu.smith.cs.csc212.aquarium;

import java.awt.Color;

public class Shark extends Fish {
	public int x;
	/**
	 * The position of the Fish; y-coordinate.
	 */
	public int y;
	/**
	 * the color of the fish
	 */
	public Color color;
	
	public boolean facingLeft = true;
	
	public boolean isLittle = false;
	
	int destX = 0;
	
	int destY = 0;
	
	
	public Shark(int sx, int sy) {
		super(Color.gray, sx, sy, false);
		this.x= sx;
		this.y= sy;
		color = Color.gray; 
	}
	public void hunt(Fish[]prey) {
		for(Fish dead: prey) {
			this.destX = dead.x;
			this.destY = dead.y;
			if((this.destX==this.x)&&(this.destY==this.y)) {
				continue;
			}
		}
		
	}

}
