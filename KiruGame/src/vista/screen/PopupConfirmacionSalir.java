package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import actionscript3.Screen;
import actionscript3.SimpleButton;
import actionscript3.SpriteAS3;
import vista.AssetManager;

public class PopupConfirmacionSalir extends Screen {

	public PopupConfirmacionSalir() {
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
				System.exit(1);
			}
		};
		btnSi.x = 720;
		btnSi.y = 450;
		addChild(btnSi);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
