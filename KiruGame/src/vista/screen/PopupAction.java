package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import actionscript3.Screen;
import actionscript3.SpriteAS3;
import modelo.Jugador;
import vista.AssetManager;

public class PopupAction extends Screen {

	public String sec = "";
	private int currentPos = 0;
	private SpriteAS3 spriteChar = new SpriteAS3(); 
	
	public PopupAction() {
		// TODO Auto-generated constructor stub
		setImg(AssetManager.getImage("popupFeo"));
		
		spriteChar.x = 450;
		spriteChar.y = 300;
		addChild(spriteChar);
	}
	
	public void definirSecuencia(String sec){
		this.sec = sec;
		updateChar();
	}
	
	private void ejecutarAccion(){
		
	}
	
//	Jugador player;
//	for (int j = 0; j<jugArray.size(); j++){
//		GestorMapas.map.getCelda(posArray.get(j)[0],posArray.get(j)[1]).showTerreno();
//	}
//	for (int i = 0; i< cordArray.get(0).length; i++){
//		for (int j = 0; j<jugArray.size(); j++){
//			int[] vect = {cordArray.get(j)[i][0], cordArray.get(j)[i][1]};
//			
//			if (jugArray.get(j) == 1)
//				player = Mapa.p1;
//			else
//				player = Mapa.p2;
//			
//			player.setXY(player.gridX + vect[0], player.gridY + vect[1]);
//			
//		}
//		Renderizador.pressToMove(sprite);
//		sc.nextLine();
//		Renderizador.mostrarMapa();
//		
//	}
	
	public void updateChar(){
		spriteChar.setImg(AssetManager.getImage( String.valueOf(sec.charAt(currentPos))  ));
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		
		if (Character.toUpperCase(e.getKeyChar()) == sec.charAt(currentPos)){
			currentPos++;
			if (currentPos < sec.length()){
				updateChar();				
			} else {
//				Correcto
//				ejecutarAccion
				
				ejecutarAccion();				
				
			}
			
		} else {
			currentPos = 0;
//			Display Message
			Jugador.getTipoDano(2);
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
