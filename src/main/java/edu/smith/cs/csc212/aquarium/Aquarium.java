package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */
public class Aquarium extends GFX {
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	public static int WIDTH = 500;
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;
	
	public Color tankColor = new Color(0,100,150,255);
	
	public int green = 100;

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");

	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);
	}
	//Fish fish1 = new Fish(Color.pink, 250, 0, true);
	//Fish finn = new Fish(Color.gray, 100, 300, true);
	Shark jaws = new Shark( 250,300);
	//I'm really sorry for calling my hungry fish hungo
	HungryFish hungo = new HungryFish(0,0);
	Bubble bub = new Bubble();
	Bubble bub1 = new Bubble();
	BubbleStream stream1 = new BubbleStream();
	FishList school1 = new FishList();
	//hungo.drawFood(g);
	
	
	public void alge() {
		if(this.green<255) {
			//this.tankColor = Color(0,this.green,150,255);
			this.green++;
		}
	}
	public void clean() {
		if(this.green>200) {
			this.green--;
		}
	}
	public void treasureChest(Graphics2D g) {
	    Font f = g.getFont();
	    g.setFont(f.deriveFont(30.23f));
	    g.setColor(Color.red);
	    g.drawString("bubble machine", 290, 490);
		hungo.drawFood(g);

	}
	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		this.tankColor = new Color(0,this.green,150,255);
		g.setColor(this.tankColor);
		g.fillRect(0, 0, getWidth(), getHeight());

		//fish1.draw(g);
		//finn.draw(g);
		bub.draw(g);
		bub1.draw(g);
		stream1.draw(g);
		jaws.draw(g);
		hungo.draw(g);
		school1.draw(g);
		//hungo.crunchTime(g);
		this.treasureChest(g);


		// Draw our snail!
		algorithm.draw(g);
		this.alge();


	}
	
	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
