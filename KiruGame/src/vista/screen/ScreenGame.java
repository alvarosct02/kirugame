package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javaAS3.ButtonAS3;
import javaAS3.ScreenAS3;
import javaAS3.StageAS3;
import vista.GestorImagenes;

public class ScreenGame extends ScreenAS3{
	
	ButtonAS3 btn;
	
	public ScreenGame(){
		super();
		
		btn = new ButtonAS3();
		btn.addScene("idle");
		btn.currentScene.addFrame(GestorImagenes.btn1,12);
		btn.currentScene.addFrame(GestorImagenes.btn2,12);	
		addChild(btn);				
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		btn.x += 10;
		this.y += 10;		
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		StageAS3.stage.repaint();
	}
	
}
