package vista.screen;

import java.awt.event.ActionEvent;

import actionscript3.Screen;
import actionscript3.Stage;
import controlador.AssetManager;
import vista.Juego;

public class ScreenGameWin extends Screen {

	int countTime = 0;
	public ScreenGameWin(){
		setImg(AssetManager.getImage("gameWin"));		
		
	}
	
	@Override
	public void onEnterFrame(ActionEvent arg0) {
		// TODO Auto-generated method stub
		countTime ++;
		if (countTime == Stage.FRAMERATE * 2){
			ScreenManager.showScreen("menu");
		}
	}

}
