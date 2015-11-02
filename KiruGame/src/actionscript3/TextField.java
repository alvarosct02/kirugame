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

public class TextField extends Sprite {
	
	private BufferedImage textArea = null;
	private String text;
	private int textWidth;
	private int textHeight;
	private static Font fontFamily = null;
	
	static{
		try {
			Font fontFamily = Font.createFont(Font.TRUETYPE_FONT, new File("assets\\fonts\\impact.ttf")).deriveFont(12f);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public TextField(String cadena, int width, int hegiht){
		setText(cadena);
		setSize(width, hegiht);	
		updateTextArea();		
	}
	
	public void setText(String cadena) {
		this.text = cadena;
	}
	
	public void setSize(int width, int height){
		this.textWidth = width;
		this.textHeight = height;
	}
	
	private void updateTextArea(){
		textArea = new BufferedImage(textWidth,textHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics g = textArea.getGraphics();
//		g.setFont(fontFamily);
//		g.fillRect(0, 0, 400, 400);
		
		g.drawString("version 1.2",5,15);
		setImg(textArea);
	}
	
}
