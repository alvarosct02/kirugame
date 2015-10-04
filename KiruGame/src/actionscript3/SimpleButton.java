package actionscript3;

import java.awt.image.BufferedImage;

public abstract class SimpleButton extends Button {
	
	public SimpleButton(BufferedImage up,BufferedImage down){
		toggleable = false;
		defStates(up, down, null, null);
	}

	@Override
	public void onClickToogle() {
		// TODO Auto-generated method stub
		
	}
}