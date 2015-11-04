package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import actionscript3.Screen;
import actionscript3.SimpleButton;
import actionscript3.Sprite;
import controlador.AssetManager;
import vista.Juego;

public class PopupConfirmacionSalir extends Screen {

	public PopupConfirmacionSalir(int idTipo) {
		setImg(AssetManager.getImage("confirmacionSalir"));			
		
		BufferedImage tmp;
		
		tmp = AssetManager.getImage("btnNo");
		SimpleButton btnNo = new SimpleButton(tmp,tmp) {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ScreenManager.closePopup();
			}
		};
		btnNo.x = 450;
		btnNo.y = 450;
		addChild(btnNo);

		tmp = AssetManager.getImage("btnSi");
		SimpleButton btnSi = new SimpleButton(tmp,tmp) {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				
				if (idTipo == 1){
					Juego.window.dispatchEvent(new WindowEvent(Juego.window, WindowEvent.WINDOW_CLOSING));
				} else if (idTipo == 0){
					ScreenManager.closePopup();
					ScreenManager.showScreen("menu");
				}
			}
		};
		btnSi.x = 720;
		btnSi.y = 450;
		addChild(btnSi);
		
	}
	
	
	@Override
	public void onEnterFrame() {
		// TODO Auto-generated method stub

	}

}
