package vista.screen;

import java.awt.event.ActionEvent;

import actionscript3.Screen;
import actionscript3.Stage;
import modelo.Jugador;
import vista.AssetManager;

public class ScreenGameOver extends Screen {

	int countTime = 0;
	public ScreenGameOver(){
		setImg(AssetManager.getImage("gameOver"));		
		Jugador.resetVida();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		Stage.stage.repaint();
		countTime ++;
		if (countTime == Stage.FRAMERATE * 2){
			ScreenManager.showScreen("menu");
		}
	}

}
