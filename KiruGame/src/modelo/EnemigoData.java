package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemigoData {

	int id;
	String nombre;
	int width;
	int height;
	char sprite;
	int layer;
	int rango;
	public BufferedImage img = null;
	
	public EnemigoData(int id, String nom, int w, int h, char sprite, int rango, String path) {
		this.id = id;
		this.nombre = nom;
		this.width = w;
		this.height = h;
		this.sprite = sprite;
		this.rango = rango;
		try {
			this.img = ImageIO.read(new File("assets/img/" + path));
		} catch (IOException e) {
			System.out.println("No se pudo cargar la imagen: " + nombre);
//			e.printStackTrace();
		};
	}
	
}
