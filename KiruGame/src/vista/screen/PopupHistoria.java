package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import actionscript3.Screen;
import actionscript3.SimpleButton;
import vista.AssetManager;
import vista.Juego;

public class PopupHistoria extends Screen {

	public PopupHistoria() {
		setImg(AssetManager.getImage("historia" + (Juego.currentLevel+1)));
			
		BufferedImage tmp;

		tmp = AssetManager.getImage("btnX");
		SimpleButton btnX = new SimpleButton(tmp,tmp) {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ScreenManager.closePopup();
			}
		};
		btnX.x = 955;
		btnX.y = 72;
		addChild(btnX);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}