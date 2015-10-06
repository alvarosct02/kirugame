package actionscript3;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpriteAS3 implements
	MouseListener, MouseWheelListener, MouseMotionListener	{
	private ArrayList<SpriteAS3> displayList = new ArrayList<SpriteAS3>();
	public float x = 0;
	public float y = 0;
	public int height = 0; //No se debe usar
	public int width = 0; //No se debe usar

	public int offsetX = 0;
	public int offsetY = 0;
	
	public SpriteAS3 parent = null;
	private BufferedImage img = null;
	private Rectangle bounds = new Rectangle();
	
//	public JPanel stage;
	public JPanel stage;
	
	public boolean active = true;
	
	public SpriteAS3(){
		stage = Stage.stage;
	}
//	
//	@Override
//	protected void finalize() throws Throwable {
//		// TODO Auto-generated method stub
//		super.finalize();
//		Stage.stage.removeMouseListener(this);
//	}
	
	
	
	public void removeMouseListener(){
		stage.removeMouseListener(this);
		for (SpriteAS3 spriteAS3 : displayList) {
			spriteAS3.removeMouseListener();
		}
	}
	
	public void disable(){
		active = false;
		for (SpriteAS3 spriteAS3 : displayList) {
			spriteAS3.disable();
		}
	}
	
	public void enable(){
		active = true;
		for (SpriteAS3 spriteAS3 : displayList) {
			spriteAS3.enable();
		}
	}
		
	public void addChild(SpriteAS3 child){
		displayList.add(child);
		child.parent = this;
	}
	
	public void removeChild(SpriteAS3 child){
		displayList.remove(child);
	}
	
	public void renderAll(Graphics2D canvas){
		render(canvas);
		for (SpriteAS3 sprite : displayList) {
			sprite.renderAll(canvas);
		}
	}
	
	protected void render(Graphics2D canvas){
		if (img != null){
			canvas.drawImage(img, Math.round(getAbsX() + offsetX), Math.round(getAbsY() + offsetY), Stage.stage);
		}
	}
	
	public float getAbsX() {
		if (parent == null)
			return x;
		return parent.getAbsX() + x;
	}
	public float getAbsY() {
		if (parent == null)
			return y;
		return parent.getAbsY() + y;
	}
	
	public void setImg(BufferedImage img){
		this.img = img;
		width = img.getWidth();
		height = img.getHeight();
		setBounds(new Rectangle(Math.round(getAbsX()),Math.round(getAbsY()), width, height));		
	}	

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
//	MOUSE EVENT
	public void mouseClicked(MouseEvent e) {if (!active) return;}
	public void mouseEntered(MouseEvent e) {if (!active) return;}
	public void mouseExited(MouseEvent e) {if (!active) return;}
	public void mousePressed(MouseEvent e) {if (!active) return;}
	public void mouseReleased(MouseEvent e) {if (!active) return;}
	public void mouseWheelMoved(MouseWheelEvent e) {if (!active) return;}
	public void mouseDragged(MouseEvent e) {if (!active) return;}
	public void mouseMoved(MouseEvent e) {if (!active) return;}

	
	
	

	
	
}
