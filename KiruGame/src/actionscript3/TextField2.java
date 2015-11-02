package actionscript3;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class TextField2 extends Sprite {
	private JLabel label = new JLabel();
	private boolean addedToScreen = false;
	
	public TextField2(String text){
		label.setText(text);
		label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
		label.setBounds(345,500,655,85);
		Stage.stage.add(label);		
	}
	
	protected void render(Graphics2D canvas){
		if (active && !addedToScreen){
			addedToScreen = true;
			Stage.stage.add(label);
		}
	}
	
	
	@Override
	public void disable(){
		Stage.stage.remove(label);
		addedToScreen = false;
		active = false;
		for (Sprite spriteAS3 : displayList) {
			spriteAS3.disable();
		}
	}

	@Override
	public void enable(){
		active = true;
		for (Sprite spriteAS3 : displayList) {
			spriteAS3.enable();
		}
	}
}
