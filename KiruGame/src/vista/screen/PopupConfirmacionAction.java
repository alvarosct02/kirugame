package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import actionscript3.Screen;
import actionscript3.SimpleButton;
import actionscript3.Sprite;
import controlador.AssetManager;
import controlador.Saver;
import vista.Juego;

public class PopupConfirmacionAction extends Screen {

	public PopupConfirmacionAction() {
		setImg(AssetManager.getImage("popupFeo"));			
		
		BufferedImage tmp;
		
		tmp = AssetManager.getImage("btnGuardarSmall");
		SimpleButton btnNo = new SimpleButton(tmp,tmp) {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				new Saver().guardar();
				ScreenManager.showPopup("action");
			}
		};
		btnNo.x = 470;
		btnNo.y = 300;
		addChild(btnNo);

		tmp = AssetManager.getImage("btnContinuar");
		SimpleButton btnSi = new SimpleButton(tmp,tmp) {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ScreenManager.showPopup("action");
			}
		};
		btnSi.x = 420;
		btnSi.y = 400;
		addChild(btnSi);
		
	}
	
	
	@Override
	public void onEnterFrame() {
		// TODO Auto-generated method stub

	}

}
