package actionscript3;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class TextField extends Sprite {
	
	private BufferedImage textArea = null;
	private char[] text;
	private int textWidth;
	private int textHeight;
	private String fontFamily = "HodoStdMedium_50";
	
	public TextField(String cadena, int width, int hegiht){
		setText(cadena);
		setSize(width, hegiht);	
		updateTextArea();		
	}
	
	public void setText(String cadena) {
		this.text = cadena.toCharArray();
	}
	
	public void setSize(int width, int height){
		this.textWidth = width;
		this.textHeight = height;
	}
	
	private void updateTextArea(){
		try {
			textArea = new BufferedImage(textWidth,textHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics g = textArea.getGraphics();
			int acumX = 0;
			for (char caracter: text) {
				BufferedImage tmp = ImageIO.read(new File(String.format("assets/fonts/%s/%s.png",fontFamily,Character.toString(caracter))));
				g.drawImage(tmp, acumX, 0, null);
				acumX += tmp.getWidth();
			}
			setImg(textArea);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
