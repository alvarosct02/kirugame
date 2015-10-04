package javaAS3;

import java.awt.event.*;

import javax.swing.Timer;

import vista.Juego;

public abstract class ScreenAS3 extends SpriteAS3 
implements	
			ActionListener,
			KeyListener
//			, 
//			WindowListener, WindowStateListener, WindowFocusListener 
			{
		
	Timer timer;
	
	public ScreenAS3(){
		super();
		stage = StageAS3.stage;	
//		stage.addWindowListener(this);		
		stage.addKeyListener(this);		
		stage.addMouseListener(this);
		timer = new Timer(1000/Juego.FRAMERATE, this);
		timer.start();
	}
	
	public void removerListeners(){
//		stage.removeWindowListener(this);		
		stage.removeKeyListener(this);		
		stage.removeMouseListener(this);
		timer.stop();		
	}
	

//	ACTION EVENT
	public void actionPerformed(ActionEvent e) {}
	
//	KEYBOARD EVENT
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
//	MOUSE EVENT
//	public void mouseClicked(MouseEvent e) {}
//	public void mouseEntered(MouseEvent e) {}
//	public void mouseExited(MouseEvent e) {}
//	public void mousePressed(MouseEvent e) {}
//	public void mouseReleased(MouseEvent e) {}
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
