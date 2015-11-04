package vista.screen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import actionscript3.Screen;
import actionscript3.Stage;
import controlador.GestorMapas;
import modelo.Jugador;

public class ScreenManager extends Thread implements KeyListener,MouseListener, MouseWheelListener, MouseMotionListener	 {
	
	private Screen currentScreen;
	private Screen currentPopup;	
    private static ScreenManager INSTANCE = new ScreenManager();    
	private boolean running = true;
	
    public static void detener(){
    	INSTANCE.running = false;
    }
    
	public static void showScreen(String screen){
		Screen newScreen = null;		
		closePopup();
		
//		if (INSTANCE.currentScreen != null){}
		
		switch(screen){
			case "menu": newScreen = new ScreenMenu(); break;
			case "game": newScreen = new ScreenGame(); break;
			case "gameOver": newScreen = new ScreenGameOver(); break;
			case "gameWin": newScreen = new ScreenGameWin(); break;
		}
		
		INSTANCE.currentScreen = newScreen;
	}
	
	public static void showPopup(String popup){
		Screen newPopup = null;		
		INSTANCE.currentScreen.active = false;
		
		switch(popup){
			case "action": newPopup = new PopupAction(); break;
			case "salirAlMenu": newPopup = new PopupConfirmacionSalir(0); break;
			case "salirTotal": newPopup = new PopupConfirmacionSalir(1); break;
			case "historia": newPopup = new PopupHistoria(); break;
			case "exitoGuardar": newPopup = new PopupExitoGuardar(); break;
			case "nuevoJugador": newPopup = new PopupNuevoJugador(); break;
		}		
		
		INSTANCE.currentPopup = newPopup;
	}
	
	public static void closePopup(){		
		if (INSTANCE.currentPopup != null){
			INSTANCE.currentScreen.active = true;
			INSTANCE.currentPopup.active = false;
			INSTANCE.currentPopup = null;
		}		
	}
	
    public static ScreenManager getInstance() {
        return INSTANCE;
    }
    
    public static Screen getCurrentScreen() {
		return INSTANCE.currentScreen;
	}

	public static Screen getCurrentPopup() {
		return INSTANCE.currentPopup;
	}

    private ScreenManager() {
//		running = true;
    	this.start();
    }
    
	public void run() {
		try {
			System.out.println("Hilo Inicio");
			while(running) {
				if (INSTANCE.currentScreen != null){
					INSTANCE.currentScreen.onEnterFrame();
				}
				
				if (INSTANCE.currentPopup != null){
					INSTANCE.currentPopup.onEnterFrame();
				}
				
				Stage.stage.repaint(); // Llamara a renderGame
				
				Thread.sleep(1000/Stage.FRAMERATE);
			}
			System.out.println("Hilo Finalizado");
		} catch(InterruptedException ex) {
		}
	}
    
    public static void init(){
    	Stage.stage.addKeyListener(INSTANCE);	
    	Stage.stage.addMouseListener(INSTANCE);
    }
		
	public static void renderGame(Graphics2D canvas){		
		if (INSTANCE.currentScreen != null){
			INSTANCE.currentScreen.renderAll(canvas);			
		}
		
		if (INSTANCE.currentPopup != null){
			INSTANCE.currentPopup.renderAll(canvas);
		}			
	}	
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
////		System.out.println("ON");
//		if (INSTANCE.currentScreen != null){
//			INSTANCE.currentScreen.onEnterFrame(e);
//		}
//		
//		if (INSTANCE.currentPopup != null){
//			INSTANCE.currentPopup.onEnterFrame(e);
//		}
//		
//		Stage.stage.repaint(); // Llamara a renderGame
//	}
	
	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("KEYDOWN");
		if (INSTANCE.currentScreen != null && INSTANCE.currentScreen.active){
			INSTANCE.currentScreen.onKeyPressed(e);	
		}
		
		if (INSTANCE.currentPopup != null && INSTANCE.currentPopup.active){
			INSTANCE.currentPopup.onKeyPressed(e);
		}	
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (INSTANCE.currentScreen != null && INSTANCE.currentScreen.active){
			INSTANCE.currentScreen.onKeyReleased(e);
		}
		
		if (INSTANCE.currentPopup != null && INSTANCE.currentPopup.active){
			INSTANCE.currentPopup.onKeyReleased(e);
		}	
	}
	


	@Override
	public void mousePressed(MouseEvent e) {
		if (INSTANCE.currentScreen != null && INSTANCE.currentScreen.active){
			INSTANCE.currentScreen.mousePressed(e);
		}
		
		if (INSTANCE.currentPopup != null && INSTANCE.currentPopup.active){
			INSTANCE.currentPopup.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (INSTANCE.currentScreen != null && INSTANCE.currentScreen.active){
			INSTANCE.currentScreen.mouseReleased(e);
		}
		
		if (INSTANCE.currentPopup != null && INSTANCE.currentPopup.active){
			INSTANCE.currentPopup.mouseReleased(e);
		}		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (INSTANCE.currentScreen != null && INSTANCE.currentScreen.active){
			INSTANCE.currentScreen.mouseClicked(e);
		}
		
		if (INSTANCE.currentPopup != null && INSTANCE.currentPopup.active){
			INSTANCE.currentPopup.mouseClicked(e);
		}		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	
}
