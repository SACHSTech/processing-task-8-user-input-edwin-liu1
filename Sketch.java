import java.util.ArrayList;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class Sketch extends PApplet {
	
	int backgroundR = 0, backgroundG = 0, backgroundB = 0;
  int size = 10;

  ArrayList<OLine> lines = new ArrayList<OLine>();
  ArrayList<OCircle> circles = new ArrayList<OCircle>();
  
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1000, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {noFill(); stroke(255);}

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(backgroundR, backgroundG, backgroundB);
    noFill();
    if (mousePressed && (!keyPressed == (keyCode == SHIFT) ) ){circles.add(new OCircle(mouseX, mouseY, size * 2) );}
    for (OLine line : lines){
      strokeWeight(line.getWidth() );
      line(line.getX(), line.getY(), line.getX2(), line.getY2() );
    }
    for (OCircle circle : circles){
      strokeWeight(2);
      circle(circle.getX(), circle.getY(), circle.getRadius() );
    }
    fill(255);
    circle(mouseX, mouseY, size);
  }
  
  public void keyPressed(){
    if ('r' == key){backgroundR = 255;}
    if ('g' == key){backgroundG = 255;}
    if ('b' == key){backgroundB = 255;}
    if (BACKSPACE == keyCode){lines.clear(); circles.clear();}
  }

  public void keyReleased(){
    if ('r' == key){backgroundR = 0;}
    if ('g' == key){backgroundG = 0;}
    if ('b' == key){backgroundB = 0;}
  }

  public void mouseDragged(){
    if (keyPressed == (keyCode == SHIFT) ){
      lines.add(new OLine(pmouseX, pmouseY, mouseX, mouseY, size) );
    }
  }

  public void mouseWheel(MouseEvent event){
    if ( !(size <= 2 && event.getCount() > 0) ){
      size -= Math.round(event.getCount() );
    }
  }
}