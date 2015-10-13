package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import actionscript3.MovieClip;
import vista.AssetManager;

public class EnemigoData extends ImageData {
	
	public int width;
	public int height;
	public char caracter;
	public int layer;
	public int rango;
	
	public EnemigoData(int id, String nom, int w, int h, char caracter, int rango) {
		super(id,nom,"",0,0);
		
		this.width = w;
		this.height = h;
		this.caracter = caracter;
		this.rango = rango;
		mc = new MovieClip();		
	}
	
	public void addAnim(int animID, String animNom){
		mc.addScene(AssetManager.getSceneByID(animID),animNom);
	}
	
}
