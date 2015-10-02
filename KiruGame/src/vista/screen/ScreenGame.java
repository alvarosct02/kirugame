package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javaAS3.StageAS3;
import vista.GestorImagenes;

public class ScreenGame extends Screen{
	
	Button btn;
	
	public ScreenGame(){
		super();
		btn = new Button();
		btn.x = 100;
		btn.y = 100;
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
