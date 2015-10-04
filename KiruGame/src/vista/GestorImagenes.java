package vista;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GestorImagenes {
	public static BufferedImage imgFondo;
	public static BufferedImage imgFondo2;
	public static BufferedImage btn1;
	public static BufferedImage btn2;
	
	public GestorImagenes(){
		// Constructor vacio
	}
	
	public static void cargarImagenes(){
		try{
			imgFondo = ImageIO.read(new File("assets/img/background_menu.jpg"));
			imgFondo2 = ImageIO.read(new File("assets/img/Game-Back1.jpg"));
			btn1 = ImageIO.read(new File("assets/img/btn1.png"));
			btn2 = ImageIO.read(new File("assets/img/btn2.png"));
			
			
			
//			dibujoListo = true;
		}catch(Exception ex){
		
		}
	}
	
}
