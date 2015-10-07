package vista.screen;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JTextField;

import actionscript3.Screen;
import actionscript3.SimpleButton;
import actionscript3.Stage;
import modelo.Mapa;
import vista.AssetManager;
import vista.Juego;

public class PopupNuevoJugador extends Screen {

	JTextField field;
	public PopupNuevoJugador() {
		
		
		setImg(AssetManager.getImage("nuevoJugador"));
			
		BufferedImage tmp;

		tmp = AssetManager.getImage("btnX");
		SimpleButton btnX = new SimpleButton(tmp,tmp) {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub

				Stage.stage.remove(field);
				ScreenManager.closePopup();
			}
		};
		btnX.x = 955;
		btnX.y = 72;
		addChild(btnX);
		
		
		tmp = AssetManager.getImage("btnContinuar");
		SimpleButton btnNext = new SimpleButton(tmp,tmp) {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Stage.stage.remove(field);
				
				Mapa.p1.setNombre(field.getText());				
				ScreenManager.closePopup();
				ScreenManager.showScreen("game");
			}
		};
		btnNext.x = 720;
		btnNext.y = 540;
		addChild(btnNext);
		
		field = new JTextField("Nombre Jugador");
//		field.setnew Font("SansSerif", Font.BOLD, 20);
		field.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
		field.setMargin(new Insets(5,20,5,20));;;
//		Dimension d = field.getPreferredSize();
		field.setBounds(345,390,655,85);
		Stage.stage.add(field);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
