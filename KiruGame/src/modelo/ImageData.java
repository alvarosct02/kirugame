package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageData {

	public int id;
	public String nombre;
	public BufferedImage img = null;
	
	public ImageData(int id, String nom, String path) {
		this.id = id;
		this.nombre = nom;
		try {
			this.img = ImageIO.read(new File("assets/img/" + path));
		} catch (IOException e) {
			System.out.println("No se pudo cargar la imagen: " + nombre);
//			e.printStackTrace();
		};
	}
}
