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

public class ScreenGame extends Screen{
	
	Button btn;
	SpriteAS3 obj;
	int max = 264;
	private Jugador p1;
	private Jugador p2;
	private Mapa map;
	
	
	public ScreenGame(){
		super();
		
		if (Juego.currentLevel == 0)
			Jugador.resetVida();
		
		p1 = Mapa.p1;
		p2 = Mapa.p2;
		
		p1.addData("Player1", "WASDQE",1,1,'A','S');
		p2.addData("Player2", "IJKLUO",1,1,'B','N');
		
		GestorMapas.cargarNivel(0);	
		addChild(GestorMapas.map);
		
		addChild(p1.mc);
		addChild(p2.mc);
		
		map = GestorMapas.map;
			
	}
	
	
	private boolean onEnterFrame(int i) {
		if (Jugador.getVida() <= 0)
			return true;			
		
		if (map.checkEnemigos())
			return false;
		
		int idAccion = map.ejecutarAccionEspecial();
		
//		CONDICION ESPECIAL NIVEL 1
		if (i==1 && p1.gridX == 0 && p2.gridX == 0)
			return true;		

		if (i==2 && p1.gridX == 15 && p2.gridX == 15)
			return true;
		
//		SE ACABO LA VIDA
		if (idAccion == -2)
			return true;
		
//		NO PASO NADA
		else if (idAccion == -1)		
			return false;
		else {
//			PARA EL NIVEL 0
			if (i == 0){
				if (idAccion == 1){			
					Renderizador.dialogo2();
					return true;
				}
			}
			
//			PARA EL NIVEL 1
			if (i == 1){
				if (idAccion == 0){	
					map.getObjeto(2).quitarMapa();
					return false;
				}
				if (idAccion == 2){	
					map.getEnemigo(0).destruir();
					return false;
				}
			}			
			
//			PARA EL NIVEL 2
			if (i == 2){
				if (idAccion == 1){	
					ObjetoApoyo obj = (ObjetoApoyo)map.getObjeto(5);
					obj.allowWalk();
					return false;
				}
			}	
		}
		return false;		
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
		int idAccion = map.ejecutarAccionEspecial();
		
		
		Renderizador.updateMapa();	
		Stage.stage.repaint();
	}
	
}
