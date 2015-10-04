package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import actionscript3.Screen;
import actionscript3.SimpleButton;
import actionscript3.Stage;
import vista.AssetManager;
import vista.Juego;

public class ScreenMenu extends Screen {
	
	public ScreenMenu(){
		super();		
		setImg(AssetManager.imgFondo);
		
		SimpleButton btnGame = new SimpleButton(AssetManager.btn1,AssetManager.btn3) {			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ScreenManager.showScreen("game");
				
			}
		};	
		btnGame.x = 400;
		btnGame.y = 400;
		addChild(btnGame);
		
		SimpleButton btnSalir = new SimpleButton(AssetManager.btn1,AssetManager.btn3) {			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ScreenManager.showScreen("game");
			}
		};	
		
		addChild(btnSalir);
		
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		super.actionPerformed(e);
		Stage.stage.repaint();
	}
}
