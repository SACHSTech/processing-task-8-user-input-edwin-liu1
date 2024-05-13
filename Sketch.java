import processing.core.PApplet;
import processing.event.MouseEvent;

public class Sketch extends PApplet {
	
	int backgroundR = 0, backgroundG = 0, backgroundB = 0;
  boolean shift = false;
  int size = 10;

  OLine[] lines = new OLine[0];
  OCircle[] circles = new OCircle[0];
  
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
  public void setup() {}

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(backgroundR, backgroundG, backgroundB);
    if (mousePressed && !shift){append(circles, new OCircle(mouseX, mouseY, size * 2) );}
    stroke(0); fill(255);
    for (OLine line : lines){
      strokeWeight(line.getWidth() );
      line(line.getX(), line.getY(), line.getX2(), line.getY2());
    }
    for (OCircle circle : circles){
      circle(circle.getX(), circle.getY(), circle.getRadius() );
    }
    circle(mouseX, mouseY, size);
  }
  
  public void keyPressed(){
    if ('r' == key){backgroundR = 255;}
    if ('g' == key){backgroundG = 255;}
    if ('b' == key){backgroundB = 255;}
    if (SHIFT == keyCode){shift = true;}
  }

  public void keyReleased(){
    if ('r' == key){backgroundR = 0;}
    if ('g' == key){backgroundG = 0;}
    if ('b' == key){backgroundB = 0;}
    if (SHIFT == keyCode){shift = false;}
  }

  public void mouseDragged(){
    if (shift){
      append(lines, new OLine(pmouseX, pmouseY, mouseX, mouseY, size) );
    }
  }

  public void mouseWheel(MouseEvent event){
    if ( !(size <= 2 && event.getCount() > 0) ){
      size -= Math.round(event.getCount() );
    }
  }
}