package vista.screen;

import java.awt.event.ActionEvent;

import actionscript3.Screen;
import actionscript3.Stage;
import controlador.AssetManager;
import modelo.Jugador;

public class ScreenGameOver extends Screen {

	int countTime = 0;
	public ScreenGameOver(){
		setImg(AssetManager.getImage("gameOver"));		
		Jugador.resetVida();
	}
	
	@Override
	public void onEnterFrame() {
		// TODO Auto-generated method stub

		Stage.stage.repaint();
		countTime ++;
		if (countTime == Stage.FRAMERATE * 2){
			ScreenManager.showScreen("menu");
		}
	}

}
