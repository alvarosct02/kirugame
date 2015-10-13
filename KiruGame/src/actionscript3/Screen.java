package actionscript3;

import java.awt.event.*;

import javax.swing.Timer;


public abstract class Screen extends Sprite {
			
	public Screen(){
		super();
	}
	
//	ACTION EVENT
	public abstract void onEnterFrame(ActionEvent e);
	
//	KEYBOARD EVENT
	public void onKeyPressed(KeyEvent e){}
	public void onKeyReleased(KeyEvent e){}
//	public void keyTyped(KeyEvent e){}
	
//	MOUSE EVENT
	public void onMouseClicked(MouseEvent e) {}
	public void onMousePressed(MouseEvent e) {}
	public void onMouseReleased(MouseEvent e) {}
//	public void mouseEntered(MouseEvent e) {}
//	public void mouseExited(MouseEvent e) {}
//	public void mouseWheelMoved(MouseWheelEvent e) {}
//	public void mouseDragged(MouseEvent e) {}
//	public void mouseMoved(MouseEvent e) {}
	
//	WINDOW EVENT
//	public void windowActivated(WindowEvent e) {}
//	public void windowClosed(WindowEvent e) {}
//	public void windowClosing(WindowEvent e) {}
//	public void windowDeactivated(WindowEvent e) {}
//	public void windowDeiconified(WindowEvent e) {}
//	public void windowIconified(WindowEvent e) {}
//	public void windowOpened(WindowEvent e) {}
//	public void windowStateChanged(WindowEvent e) {}
//	public void windowGainedFocus(WindowEvent e) {}
//	public void windowLostFocus(WindowEvent e) {}
//	
	
}
