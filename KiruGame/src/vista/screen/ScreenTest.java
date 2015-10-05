package vista.screen;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import actionscript3.MovieClip;
import actionscript3.Screen;
import actionscript3.Stage;
import vista.Renderizador;

public class ScreenTest extends Screen {

	
	public ScreenTest(){
		super();
		
		MovieClip mc = new MovieClip();
		mc.addScene("perro");
		try {
			mc.currentScene.addFrame(ImageIO.read(new File("assets/img/perroRespirando/img1.png")));
			mc.currentScene.addFrame(ImageIO.read(new File("assets/img/perroRespirando/img2.png")));
			mc.currentScene.addFrame(ImageIO.read(new File("assets/img/perroRespirando/img3.png")));
			mc.currentScene.addFrame(ImageIO.read(new File("assets/img/perroRespirando/img4.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		addChild(mc);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		Renderizador.updateMapa();	
		Stage.stage.repaint();
	}
}
