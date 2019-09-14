package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Bubble {
	//public Color bubCol = new Color(0,191,255,200);
	public Color color = new Color(0,191,255,200);
	public double x = 0;
	public double y = 450;
	public int radius;
	public double bubSpeed;
	//public double wiggle; 
	public double xWiggle;
	
	public Bubble(){
		radius = this.randSize();
		int initX = this.randX();
		this.x = initX +300;
		bubSpeed = this.randSpeed();
		
		
	}
	public void drawBubble(Graphics2D g, Color color, double x, double y) {
		Shape bub = new Ellipse2D.Double(this.x, this.y, this.radius, this.radius);
		g.setColor(this.color);
		g.fill(bub);
	}
	public void draw(Graphics2D g) {
		this.move();
		
		this.drawBubble(g, this.color, this.x, this.y);

	}
	public int randSize() {
		Random size = new Random();	
		int bubSize = size.nextInt(100);
		return bubSize;
	}
	public int randX() {
		Random posX = new Random();	
		int randPos = posX.nextInt(100);
		return randPos;
	}
	public double randSpeed() {
		Random speed = new Random();
		int speedy = speed.nextInt(10);
		double slowspeed = (speedy+1)/10.0;
		return slowspeed;
		
	}
	public void move(){
		xWiggle = this.randWiggle();
		if(this.y<-50) {
			this.y = 450;
		}
		if(this.x>510 || this.x <250) {
			this.x = 450;
			this.y = 450;
			bubSpeed = randSpeed();
		}
		this.y -= bubSpeed;
		this.x += xWiggle;
		
	}
	public double randWiggle() {
		Random wiggly = new Random();
		double wiggle;
		int wig = wiggly.nextInt(10);
		wig++;
		if(wig%2 == 0) {
			wiggle = wig/-10.0;
		} else {
			wiggle = wig/10.0;
		}
		return wiggle;
	}
	
}
