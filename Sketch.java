import processing.core.PApplet;

public class Sketch extends PApplet {
	
	int backgroundR = 0, backgroundG = 0, backgroundB = 0;
  boolean shift = false;
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(backgroundR, backgroundG, backgroundB);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(backgroundR, backgroundG, backgroundB);

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

  public void mousePressed(){
    if (shift){}
  }
}