package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class HungryFish extends Fish {
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
	
	int foodRadius = 10;
	
	public Color foodColor = new Color(0,255,255,255);
	
	public int foodX;
	
	public int foodY;
	
	public boolean hungry = false;
	
	public HungryFish(int sx, int sy) {
		
		super(Color.red, sx, sy, false);
		this.x= sx;
		this.y= sy;
		color = Color.red; 
		isLittle = false;
		//this.crunchTime(g);
		
	}
	public void drawFood(Graphics2D g) {
		Shape food = new Ellipse2D.Double(this.foodX, this.foodY, this.foodRadius, this.foodRadius);
		g.setColor(this.foodColor);
		g.fill(food);

	}
	public void crunchTime(Graphics2D g) {
		Random rand = new Random();
		this.foodX = rand.nextInt(250);
		this.foodY= rand.nextInt(250);
		this.foodY += 250;
		drawFood(g);
	}
	public void full() {
		foodX = 70000;
		foodY = 70000;
		hungry = false;
	}
	@Override
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
	@Override 
	public void swim() {

		if(hungry= true){
			if((this.x==this.foodX)&&(this.y==this.foodY)) {
				this.full();
			}
			if(this.foodX> this.x) {
				this.facingLeft = false;
				this.x ++;
			} else if(foodX< this.x) {
				this.facingLeft = true;
				this.x --;
			}
		
			if(this.foodY>this.y) {
				this.y++;
			} else if(this.foodY< this.y) {
				this.y--;
			}
			
			
		}
		else {
			if((this.x<250)&&(250<this.y)&&(this.y<250)) {
				hungry=true;
			}
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
		
	}

}
