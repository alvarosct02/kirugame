package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import actionscript3.Screen;
import actionscript3.Stage;
import vista.AssetManager;
import vista.Juego;

public class ScreenMenu extends Screen {
	
	public ScreenMenu(){
		super();		
		setImg(AssetManager.imgFondo);
    }

	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed" + e.getKeyCode());
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
			ScreenManager.showScreen("game");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		Stage.stage.repaint();
	}
}
