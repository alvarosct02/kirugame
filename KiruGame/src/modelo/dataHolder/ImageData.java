package modelo.dataHolder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import actionscript3.MovieClip;

public class ImageData {

	public int id;
	public String nombre;
	public BufferedImage img = null;
	public MovieClip mc = null;
	public int offsetX;
	public int offsetY;
	
	public ImageData(int id, String nom, String path, int offsetX, int offsetY) {
		this.id = id;
		this.nombre = nom;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		
		if (!path.equals("")){
			try {
				this.img = ImageIO.read(new File("assets/img/" + path));
			} catch (IOException e) {
				System.out.println("No se pudo cargar la imagen: " + nombre);
//				e.printStackTrace();
			}
		}
		
	}
}
