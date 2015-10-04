package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjetoData {
//	<nombre>Alfombra</nombre>
//	<width>15</width>
//	<height>2</height>
//	<sprite>a</sprite>
//	<layer>1</layer>
//	<tipo>0</tipo>
	
	int id;
	String nombre;
	int width;
	int height;
	char sprite;
	int layer;
	int tipo;
	public BufferedImage img = null;
	
	public ObjetoData(int id, String nom, int w, int h, char sprite, int tipo, String path) {
		this.id = id;
		this.nombre = nom;
		this.width = w;
		this.height = h;
		this.sprite = sprite;
		this.tipo = tipo;
		try {
			this.img = ImageIO.read(new File("assets/img/" + path));
		} catch (IOException e) {
			System.out.println("No se pudo cargar la imagen: " + nombre);
//			e.printStackTrace();
		};
	}
	
}
