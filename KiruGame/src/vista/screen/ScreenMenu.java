package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import actionscript3.Screen;
import actionscript3.SimpleButton;
import actionscript3.Stage;
import vista.AssetManager;
import vista.Juego;
import controlador.Saver;
public class ScreenMenu extends Screen {
	
	public ScreenMenu(){
		super();		
		setImg(AssetManager.getImage("bgMenu"));
		
		SimpleButton btnGame = new SimpleButton(AssetManager.getImage("btnNuevo"), AssetManager.getImage("btnNuevo")) {			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ScreenManager.showScreen("game");				
			}
		};
		btnGame.x = 362;
		btnGame.y = 315;
		addChild(btnGame);
		
		SimpleButton btnCreditos = new SimpleButton(AssetManager.getImage("btnCargar"),AssetManager.getImage("btnCargar")) {			
			@Override
			public void onClick() {
				new Saver().guardar();
			}
		};			
		btnCreditos.x = 362;
		btnCreditos.y = 425;
		addChild(btnCreditos);
		
		SimpleButton btnSalir = new SimpleButton(AssetManager.getImage("btnSalir"),AssetManager.getImage("btnSalir")) {			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ScreenManager.showScreen("test");				
			}
		};			
		btnSalir.x = 362;
		btnSalir.y = 600;
		addChild(btnSalir);
		
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		super.actionPerformed(e);
		Stage.stage.repaint();
	}
}
