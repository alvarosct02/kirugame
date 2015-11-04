package actionscript3;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import vista.Juego;

public class TextField extends Sprite {
	
	private BufferedImage textArea = null;
	private String text;
	private int textWidth;
	private int textHeight;
	private Font fontFamily = null;
	
		
	public void setSize(float size){
		fontFamily = fontFamily.deriveFont(size);
	}
	
	public TextField(String cadena, String ff){
		try {
			switch (ff.toUpperCase()) {
			case "HOBO":
				fontFamily = Font.createFont(Font.TRUETYPE_FONT, new File("assets\\fonts\\HoboStd.ttf"));
				break;
			default:
				fontFamily = new Font ("Arial", Font.PLAIN, 10);
				break;
			}
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		init(cadena);	
	}
	
	public TextField(String cadena){
		fontFamily = new Font ("Arial", Font.PLAIN , 12);
		init(cadena);	
	}
	
	public void init(String cadena){
		setSize(12);
		setText(cadena);
		setWidth(Juego.ANCHO);	
		setHeight(Juego.ALTO);
		updateTextArea();		
	}
	
	
	public void setText(String cadena) {
		this.text = cadena;
	}
	
	public void setWidth(int width){
		this.textWidth = width;
	}
	
	public void setHeight(int height){
		this.textHeight = height;
	}
	
	private void updateTextArea(){
		textArea = new BufferedImage(textWidth,textHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics g = textArea.getGraphics();
		g.setFont(fontFamily);
		
		g.drawString(text,0,fontFamily.getSize());
		setImg(textArea);
	}
	
}
