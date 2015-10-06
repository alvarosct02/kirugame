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
		
//		stage.addKeyListener(this);		
			
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
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
		Renderizador.updateMapa();	
		Stage.stage.repaint();
	}
	
}
