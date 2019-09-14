package edu.smith.cs.csc212.aquarium;

import java.awt.Graphics2D;

public class BubbleStream {
	Bubble bub2 = new Bubble();
	Bubble[] bubbles = new Bubble[10];
	
	public BubbleStream() {
		for (int i=0;i<this.bubbles.length; i++) {
		    this.bubbles[i] = new Bubble();
		 }
	}
	
	public void draw (Graphics2D g) {
		
		bub2.draw(g);
		for(Bubble bub: this.bubbles) {
			bub.draw(g);
		}
	}
}
