package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.Timer;

import actionscript3.Screen;
import actionscript3.SimpleButton;
import actionscript3.Stage;
import vista.Juego;
import controlador.AssetManager;
import controlador.Saver;
public class ScreenMenu extends Screen {
	
	public ScreenMenu(){
		super();
		
		setImg(AssetManager.getImage("bgMenu"));
		
		SimpleButton btnGame = new SimpleButton(AssetManager.getImage("btnNuevo"), AssetManager.getImage("btnNuevo")) {			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ScreenManager.showPopup("nuevoJugador");				
			}
		};
		btnGame.x = 515;
		btnGame.y = 315;
		addChild(btnGame);
		
		SimpleButton btnCargar = new SimpleButton(AssetManager.getImage("btnCargar"),AssetManager.getImage("btnCargar")) {			
			@Override
			public void onClick() {
				String path;
				JFileChooser fc=new JFileChooser("."+System.getProperty("file.separator")+"save"+System.getProperty("file.separator"));
				 
				int returnVal=fc.showOpenDialog(Stage.stage);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
				path = fc.getSelectedFile().getAbsolutePath();
				Saver.cargar(path);
				}
			}
		};			
		btnCargar.x = 515;
		btnCargar.y = 425;
		addChild(btnCargar);
		
		SimpleButton btnSalir = new SimpleButton(AssetManager.getImage("btnSalir"),AssetManager.getImage("btnSalir")) {			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ScreenManager.showPopup("salirTotal");				
			}
		};			
		btnSalir.x = 515;
		btnSalir.y = 600;
		addChild(btnSalir);
		
//		stage.add(comp);
		
    }
	
//	SOLO PARA TESTING!
//	BORRAR PARA VERSION FINAL
	@Override
	public void onKeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
		switch (e.getKeyChar()) {
		case '0':
		case '1':
		case '2':
			Juego.currentLevel = Integer.parseInt(Character.toString(e.getKeyChar()));
			break;

		default:
			break;
		}
	}

	@Override
	public void onEnterFrame(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
