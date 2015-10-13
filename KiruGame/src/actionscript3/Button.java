package actionscript3;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.function.Function;

import controlador.AssetManager;

public abstract class Button extends Sprite {
	protected BufferedImage stateUP;
	protected BufferedImage stateDOWN;
	protected BufferedImage stateHOVER;
	protected BufferedImage stateON;
	
	private boolean pressed = false;
	protected boolean toggleable = true;
	private boolean down = false;
	

	public abstract void onClick();
	public abstract void onClickToogle();
	
	
	protected Button(){
		
	}
	
	protected void defStates(BufferedImage up, BufferedImage down, BufferedImage on, BufferedImage hover){
		stateUP = up;
		stateDOWN = down;
		stateHOVER = hover;
		stateON = on;		
		setImg(stateUP);
	}
	
	
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		super.mouseClicked(e);
//
//		if (!getBounds().contains(e.getX(), e.getY())) return;
//		
//		System.out.println("CLICK");
////		
////		if (!pressed){
////			setImg(stateON);
////			onClick();
////		}else
////			setImg(stateUP);
//		
//		
//		if (toggleable){
//			pressed = !pressed;
//		}
//			
//	}
	
	@Override
	public void onMousePressed(MouseEvent e) {				
		down = true;
//		if (!toggleable)
		setImg(stateDOWN);
		
	}
	
	@Override
	public void onMouseReleased(MouseEvent e) {		
		if (down){
			
			if (!toggleable)
				onClick();
			else if (toggleable){
				if (pressed){
					setImg(stateUP);
					pressed = false;
				} else if (!pressed){
					onClick();
					setImg(stateON);
					pressed = true;
				}
			}	
		}		

		down = false;
		
		if (!toggleable){
			setImg(stateUP);
		} else if (toggleable){
			if (pressed){
				setImg(stateON);
			} else if (!pressed){
				setImg(stateUP);
			}
		}
		
	}
	
//	@Override
//	public void mouseMoved(MouseEvent e) {
//		// TODO Auto-generated method stub
//		super.mouseEntered(e);
//		if (!getBounds().contains(e.getX(), e.getY())) return;
//		setImg(stateHOVER);
//	}
	
//	
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		super.mouseExited(e);
//		if (!getBounds().contains(e.getX(), e.getY())) return;
//		
//		if (pressed)
//			setImg(stateON);
//		else
//			setImg(stateUP);
//	}
	

}
