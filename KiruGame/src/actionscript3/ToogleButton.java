package actionscript3;

import java.awt.image.BufferedImage;

public abstract class ToogleButton extends Button {
	
	public ToogleButton(	BufferedImage up,BufferedImage down,BufferedImage on){
		toggleable = true;
		defStates(up, down, on, null);	
	}
}
