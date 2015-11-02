package modelo.dataHolder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import actionscript3.MovieClip;
import controlador.AssetManager;

public class ObjetoData extends ImageData {
	
	public int width;
	public int height;
	public char caracter;
	public int layer;
	public int tipo;
	
	public ObjetoData(int id, String nom, int w, int h, char sprite, int tipo, int animID) {
		super(id,nom,"" ,0,0);
		this.width = w;
		this.height = h;
		this.caracter = sprite;
		this.tipo = tipo;		

		mc = new MovieClip();
		mc.addScene(AssetManager.getSceneByID(animID),"idle");
	}
	
}