package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

public class Fish {
	/**
	 * How tall is the fish?
	 */
	public static int HEIGHT = 50;
	/**
	 * The positioning of the fish. 
	 */
	private String direction;
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
	
	public boolean facingLeft;
	
	public boolean isLittle;
	
	//construct a fish at position (x,y) with color color
	public Fish(Color colorin, int sx, int sy) {
		this.x = sx;
		this.y= sy;
		this.color = colorin;
	}
	public void draw(Graphics2D window) {
		this.swim();
		// if big
		DrawFish.facingLeft(window, this.color,  this.x, this.y);
		DrawFish.facingRight(window, this.color,  this.x, this.y);
		//if small
		DrawFish.smallFacingLeft(window, this.color,  this.x, this.y);
		DrawFish.smallFacingLeft(window, this.color,  this.x, this.y);
	}
	public void swim() {
		this.y += 1;
	}
}
