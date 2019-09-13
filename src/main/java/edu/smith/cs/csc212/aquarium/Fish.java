package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {


	/**
	 * The position of the Fish; x-coordinate.
	 */
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
	
	//construct a fish at position (x,y) with color color
	public Fish(Color colorin, int sx, int sy, boolean small) {
		this.destX = randDest();
		this.destY = randDest();
		this.x = sx;
		this.y= sy;
		this.color = colorin;
		this.isLittle = small;
	}
	public void draw(Graphics2D window) {
		this.swim();
		
		if (isLittle == false){
			if( facingLeft == true) {
				DrawFish.facingLeft(window, this.color,  this.x, this.y);
			}
			else if(facingLeft == false) {
				DrawFish.facingRight(window, this.color,  this.x, this.y);
			}
			
		
		}
		
		else if (isLittle == true) {
			if( facingLeft == true) {
				DrawFish.smallFacingLeft(window, this.color,  this.x, this.y);
			}
			else if(facingLeft == false) {
				DrawFish.smallFacingRight(window, this.color,  this.x, this.y);
			}
		}
		
	}
	public void swim() {

		
		// Select a random destination for the fish.

		
		if((this.x == this.destX) && (this.y == this.destY)) {
			this.destX = randDest();
			this.destY = randDest();
		}
		if(this.destX> this.x) {
			this.facingLeft = false;
			this.x ++;
		} else if(destX< this.x) {
			this.facingLeft = true;
			this.x --;
		}
		
		if(this.destY>this.y) {
			this.y++;
		} else if(this.destY< this.y) {
			this.y--;
		}
		
	}
	public int randDest() {
		Random pos = new Random();
		int a = pos.nextInt(Aquarium.WIDTH);
		return a;
	}
	
}
