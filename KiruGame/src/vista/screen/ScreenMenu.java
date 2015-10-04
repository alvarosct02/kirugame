package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import javaAS3.ScreenAS3;
import javaAS3.StageAS3;
import vista.GestorImagenes;
import vista.Juego;

public class ScreenMenu extends ScreenAS3 {
	
	public ScreenMenu(){
		super();		
		img = GestorImagenes.imgFondo;
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
		StageAS3.stage.repaint();
	}
}
