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

public class SpriteAS3 {
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
		
	public boolean active = true;
	
	public SpriteAS3(){
		
	}
//	
//	@Override
//	protected void finalize() throws Throwable {
//		// TODO Auto-generated method stub
//		super.finalize();
//		Stage.stage.removeMouseListener(this);
//	}
	
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
		if (img == null) return;
		
		width = (img != null)? img.getWidth() : 0;
		height = (img != null)? img.getHeight() : 0;
		setBounds(new Rectangle(0,0, width, height));		
	}	
	
	public Rectangle getBounds() {
		bounds.setLocation(Math.round(getAbsX()),Math.round(getAbsY()));
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public void onMouseClicked(MouseEvent e){
		
	}
	
	public void onMouseReleased(MouseEvent e){
		
	}
	
	public void onMousePressed(MouseEvent e){
		
	}
	
	
	public void mouseClicked(MouseEvent e){
		if ( active ) {
			if ( getBounds().  contains(e.getX(),e.getY()) ){
				onMouseClicked(e);	
			}
			for (SpriteAS3 spriteAS3 : displayList) {
				spriteAS3.mouseClicked(e);
			}			
		}
	}
	
	public void mouseReleased(MouseEvent e){
		if ( active ) {
			if ( getBounds().contains(e.getX(),e.getY()) ){
				onMouseReleased(e);	
			}
			for (SpriteAS3 spriteAS3 : displayList) {
				spriteAS3.mouseReleased(e);
			}
		}
	}
	
	public void mousePressed(MouseEvent e){
		if ( active ) {
			if ( getBounds().contains(e.getX(),e.getY()) ){
				onMousePressed(e);	
			}
			System.out.println(displayList.size());
			for (SpriteAS3 spriteAS3 : displayList) {
				spriteAS3.mousePressed(e);
			}			
		}
	}
	

	
	
	

	
	
}
