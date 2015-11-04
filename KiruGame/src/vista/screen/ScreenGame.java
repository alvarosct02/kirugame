package vista.screen;

import java.awt.Font;
import java.awt.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JTextField;

import actionscript3.Button;
import actionscript3.MovieClip;
import actionscript3.ToogleButton;
import controlador.AssetManager;
import controlador.GestorMapas;
import modelo.Jugador;
import modelo.Mapa;
import modelo.ObjetoApoyo;
import actionscript3.Screen;
import actionscript3.SimpleButton;
import actionscript3.Sprite;
import actionscript3.Stage;
import vista.Juego;
import vista.Renderizador;
import controlador.Saver;
public class ScreenGame extends Screen{
	
	Button btn;
	Sprite obj;
	int max = 264;
	private Jugador p1;
	private Jugador p2;
	private Mapa map;
	
	boolean first = true;	
	
	Sprite panel = new Sprite();
	Sprite vida = new Sprite();
		
	public ScreenGame(){
		super();
		
		p1 = Mapa.p1;
		p2 = Mapa.p2;
				
		if (Juego.currentLevel == 0)
			Jugador.resetVida();
		
		p1.addData("Player1", "WASDQE",1,1,'A','S');
		p2.addData("Player2", "IJKLUO",1,1,'B','N');
		
		GestorMapas.cargarNivel(Juego.currentLevel);
		
				

		map = GestorMapas.map;
		
		BufferedImage aux;
		aux = AssetManager.getImage("btnGuardarSmall");
		SimpleButton guardar = new SimpleButton(aux,aux) {			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				new Saver().guardar();
				ScreenManager.showPopup("exitoGuardar");
				
			}
		};
		
		aux = AssetManager.getImage("btnSalirSmall");
		SimpleButton salir = new SimpleButton(aux,aux) {			
			@Override
			public void onClick() {
				if (!active) return;
				// TODO Auto-generated method stub
				ScreenManager.closePopup();
				ScreenManager.showPopup("salirAlMenu");
			}
		};
		
		addChild(GestorMapas.map);
		addChild(p1.sprite);
		addChild(p2.sprite);
		
		guardar.x = 1108;
		salir.x = 1108;
		guardar.y = 622;
		salir.y = 678;

		agregarPanel();
		
		addChild(guardar);
		addChild(salir);
		

			
	}
	

    public void agregarPanel(){
    	panel.setImg(AssetManager.getImage("panel"));
    	vida.setImg(AssetManager.getImage("vida" + Jugador.getVida()));    	
    	
    	panel.x = 1024;
    	
    	vida.x = 1060;
    	vida.y = 76;
    	
    	addChild(panel);
    	addChild(vida);    	
    }
	
	
	private boolean onEnterFrame2() {
		int i = Juego.currentLevel;
//		if (Jugador.getVida() <= 0)
//			ScreenManager.showScreen("gameWin");			
		
		if (map.checkEnemigos())
			return false;
		
		int idAccion = map.ejecutarAccionEspecial();
		if (idAccion != -1) return false;
		
//		CONDICION ESPECIAL NIVEL 0
		if (i==0 && p1.gridX == 15 && p2.gridX == 15 
//				&& p1.gridY >= 5 && p1.gridY <= 8 && p2.gridY >= 5 && p2.gridY <= 8 
			){
			Juego.nextLevel();
			ScreenManager.showScreen("game");
			return true;
		}	
		
//		CONDICION ESPECIAL NIVEL 1
		if (i==1 && p1.gridX == 0 && p2.gridX == 0){
			Juego.nextLevel();
			ScreenManager.showScreen("game");
			return true;
		}					

//		CONDICION ESPECIAL NIVEL 2
		if (i==2 && p1.gridX == 15 && p2.gridX == 15){
			Juego.nextLevel();
			ScreenManager.showScreen("gameWin");
			return true;
		}
	
		return false;	
	}
	
	public void onActionStart(int idAccion){
		int i = Juego.currentLevel;
	
	//		PARA EL NIVEL 0
		if (i == 0){
//			NADA
		}
		
	//		PARA EL NIVEL 1
		if (i == 1){
			if (idAccion == 0){	
				map.getObjeto(2).removeFromMap();
				return;
			}
//			if (idAccion == 2){	
//				map.getEnemigo(0).destruir();
//				return;
//			}
		}			
		
	//		PARA EL NIVEL 2
//		if (i == 2){
//			if (idAccion == 1){	
//				ObjetoApoyo obj = (ObjetoApoyo)map.getObjeto(5);
//				obj.allowWalk();
//				return;
//			}
//		}	
	}
	
	
	public void onActionDone(int idAccion){
		int i = Juego.currentLevel;
	
	//		PARA EL NIVEL 0
		if (i == 0){
			if (idAccion == 0){			
				map.activarAccion(1);
				return;
			}
			if (idAccion == 1){			
				Renderizador.dialogo2();
				return;
			}
		}
		
	//		PARA EL NIVEL 1
		if (i == 1){
			if (idAccion == 2){	
				map.getEnemigo(0).destruir();
				return;
			}
		}
		if (i == 1){
			if (idAccion == 1){	
				map.getObjeto(3).removeFromMap();
				return;
			}
		}
		
	//		PARA EL NIVEL 2
		if (i == 2){
			if (idAccion == 0){		
				map.activarAccion(1);
				return;
			}
			
			if (idAccion == 1){	
				ObjetoApoyo obj = (ObjetoApoyo)map.getObjeto(5);
				obj.allowWalk();
				return;
			}
		}	
	}
	
	
	@Override
	public void onKeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.onKeyPressed(e);		
		
		switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
			case KeyEvent.VK_W:
			case KeyEvent.VK_D:
			case KeyEvent.VK_S:
				p1.setDir(e.getKeyChar());
//				System.out.println(p1.gridX + " - " + p1.gridY);
				break;
				
			case KeyEvent.VK_J:
			case KeyEvent.VK_I:
			case KeyEvent.VK_K:
			case KeyEvent.VK_L:
				p2.setDir(e.getKeyChar());
				break;
	
			default:
				break;
		}		
	}	
	
	@Override
	public void onKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.onKeyReleased(e);
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_W:
		case KeyEvent.VK_D:
		case KeyEvent.VK_S:
			p1.setIdle();
			break;
			
		case KeyEvent.VK_J:
		case KeyEvent.VK_I:
		case KeyEvent.VK_K:
		case KeyEvent.VK_L:
			p2.setIdle();
			break;

		default:
			break;
	}	
	}
	
	
	@Override
	public void onEnterFrame() {
		if (first){
			first = false;
			ScreenManager.showPopup("historia");
		}		

    	vida.setImg(AssetManager.getImage("vida" + Jugador.getVida()));
    	p1.moverDir();
    	p2.moverDir();
    	
		if (active)
			onEnterFrame2();
		
		
		Renderizador.updateMapa();
		Stage.stage.repaint();
	}
	
}
