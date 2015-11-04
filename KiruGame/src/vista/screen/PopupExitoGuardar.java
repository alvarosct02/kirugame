package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import actionscript3.Screen;
import actionscript3.SimpleButton;
import controlador.AssetManager;
import vista.Juego;

public class PopupExitoGuardar extends Screen {

	public PopupExitoGuardar() {
		setImg(AssetManager.getImage("exitoGuardar"));
			
		BufferedImage tmp;

		tmp = AssetManager.getImage("btnX");
		SimpleButton btnX = new SimpleButton(tmp,tmp) {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ScreenManager.closePopup();
			}
		};
		btnX.x = 835;
		btnX.y = 256;
		addChild(btnX);

	}
	
	
	
	@Override
	public void onEnterFrame() {
		// TODO Auto-generated method stub

	}

}
