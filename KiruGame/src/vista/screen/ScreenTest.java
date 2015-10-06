package vista.screen;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import actionscript3.MovieClip;
import actionscript3.Screen;
import actionscript3.Stage;
import vista.AssetManager;
import vista.Renderizador;

public class ScreenTest extends Screen {

	
	public ScreenTest(){
		super();
		
		MovieClip mc = new MovieClip();  // Inicializacion
		mc.addScene(AssetManager.getScene("perroRespirando"));
		mc.x = 100;
		mc.y = 100;		
		addChild(mc); // Agrega la animacion a la pantalla
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		Renderizador.updateMapa();	
		Stage.stage.repaint();
	}
}
