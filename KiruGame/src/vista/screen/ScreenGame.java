package vista.screen;

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
import controlador.GestorMapas;
import controlador.Mapa;
import modelo.Jugador;
import modelo.ObjetoApoyo;
import actionscript3.Screen;
import actionscript3.SimpleButton;
import actionscript3.SpriteAS3;
import actionscript3.Stage;
import vista.AssetManager;
import vista.Juego;
import vista.Renderizador;
import controlador.Saver;
public class ScreenGame extends Screen{
	
	Button btn;
	SpriteAS3 obj;
	int max = 264;
	private Jugador p1;
	private Jugador p2;
	private Mapa map;
	
	boolean first = true;	
	
	SpriteAS3 panel = new SpriteAS3();
	SpriteAS3 vida = new SpriteAS3();
		
	public ScreenGame(boolean loaded){
		super();
		
		p1 = Mapa.p1;
		p2 = Mapa.p2;
		
		if (!loaded){			
			if (Juego.currentLevel == 0)
				Jugador.resetVida();
			
			p1.addData("Player1", "WASDQE",1,1,'A','S');
			p2.addData("Player2", "IJKLUO",1,1,'B','N');
			
			GestorMapas.cargarNivel(Juego.currentLevel);
		}
				

		map = GestorMapas.map;
		
		BufferedImage aux;
		aux = AssetManager.getImage("btnGuardarSmall");
		SimpleButton guardar = new SimpleButton(aux,aux) {			
			@Override
			public void onClick() {
				if (!active) return;
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
		addChild(p1.mc);
		addChild(p2.mc);
		
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
	
	
	private boolean onEnterFrame() {
		int i = Juego.currentLevel;
		if (Jugador.getVida() <= 0)
			ScreenManager.showScreen("test");			
		
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
			ScreenManager.showScreen("test");
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
				map.getObjeto(2).quitarMapa();
				return;
			}
//			if (idAccion == 2){	
//				map.getEnemigo(0).destruir();
//				return;
//			}
		}			
		
	//		PARA EL NIVEL 2
		if (i == 2){
			if (idAccion == 1){	
				ObjetoApoyo obj = (ObjetoApoyo)map.getObjeto(5);
				obj.allowWalk();
				return;
			}
		}	
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
				map.getObjeto(3).quitarMapa();
				return;
			}
		}
		
	//		PARA EL NIVEL 2
		if (i == 2){
			if (idAccion == 1){	
				ObjetoApoyo obj = (ObjetoApoyo)map.getObjeto(5);
				obj.allowWalk();
				return;
			}
		}	
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		if (!active) return;
//		System.out.println(e.getKeyCode());
//		
		switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
			case KeyEvent.VK_W:
			case KeyEvent.VK_D:
			case KeyEvent.VK_S:
				p1.moverDir(e.getKeyChar());
//				System.out.println(p1.gridX + " - " + p1.gridY);
				break;
				
			case KeyEvent.VK_J:
			case KeyEvent.VK_I:
			case KeyEvent.VK_K:
			case KeyEvent.VK_L:
				System.out.println(p2.gridX + " - " + p2.gridY);
				p2.moverDir(e.getKeyChar());
				break;
	
			default:
				break;
		}		
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (first){
			first = false;
			ScreenManager.showPopup("historia");
		}		

    	vida.setImg(AssetManager.getImage("vida" + Jugador.getVida()));
    	
		if (active)
			onEnterFrame();
		
		
		Renderizador.updateMapa();	
		Stage.stage.repaint();
	}
	
}
