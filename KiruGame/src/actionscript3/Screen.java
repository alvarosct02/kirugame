package actionscript3;

import java.awt.event.*;

import javax.swing.Timer;

import vista.Juego;

public abstract class Screen extends SpriteAS3 implements ActionListener,KeyListener {
		
	Timer timer;
	
	public Screen(){
		super();
		stage = Stage.stage;	
//		stage.addWindowListener(this);		
		stage.addKeyListener(this);		
//		stage.addMouseListener(this);
		timer = new Timer(1000/Stage.FRAMERATE, this);
		timer.start();
	}
	
	public void removerListeners(){	
		timer.stop();	
		
		MouseListener[] mListeners = stage.getMouseListeners();
		for (int i = 0; i < mListeners.length; i++){
			stage.removeMouseListener(mListeners[i]);
		}
		
		stage.removeKeyListener(this);		
		stage.removeMouseListener(this);		
	}
	

//	ACTION EVENT
//	public void actionPerformed(ActionEvent e) {}
	
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
