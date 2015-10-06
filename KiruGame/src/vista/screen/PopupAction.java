package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import actionscript3.Screen;
import actionscript3.SpriteAS3;
import controlador.AccionEspecial;
import controlador.Mapa;
import modelo.Jugador;
import vista.AssetManager;

public class PopupAction extends Screen {

	public String sec = "";
	private int currentPos = 0;
	private AccionEspecial action;
	private SpriteAS3 spriteChar = new SpriteAS3(); 
	private int run = -1;
	private int count;
	private boolean first = true;
	
	public PopupAction() {
		// TODO Auto-generated constructor stub
		setImg(AssetManager.getImage("popupFeo"));
		
		spriteChar.x = 450;
		spriteChar.y = 300;
		addChild(spriteChar);
	}
	
	public void definirAccion(AccionEspecial action){
		this.action = action;
		this.sec = action.getSec();
		updateChar();

		System.out.println("AQUI1.2");
	}
	
	private void ejecutarAccion(){
		

		
		removeChild(spriteChar);
		setImg(null);
		run = 0;
		
		
		
		
	}
	

	
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
				stage.removeKeyListener(this);
//				ScreenManager.getCurrentScreen().removeChild(Mapa.p1.mc);
				
				ejecutarAccion();		
				System.out.println("AQUI1.1");		
				
			}
			
		} else {
			currentPos = 0;
//			Display Message
			updateChar();
			Jugador.getTipoDano(2);
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		int count = 0;
		if (count == 0 && run >= 0){
			if (first){
				((ScreenGame)ScreenManager.getCurrentScreen()).onActionStart(action.idAccion);
				first = false;
			}
			System.out.println("AQUI1.3");
			if (run < action.cordArray.get(0).length){
	//			addChild(AssetManager.getSceneByID());				
				Jugador player;
				for (int j = 0; j<action.jugArray.size(); j++){
					int[] vect = {action.cordArray.get(j)[run][0], action.cordArray.get(j)[run][1]};				
					player = (action.jugArray.get(j) == 1)? Mapa.p1: Mapa.p2;				
					player.setXY(player.gridX + vect[0], player.gridY + vect[1]);
					if (action.cordArray.get(j)[run][2] == -2){
						ScreenManager.getCurrentScreen().removeChild(player.mc);
					} else if (action.cordArray.get(j)[run][2] == -1){
						count = 24;
					} else {
						player.mc.addScene(AssetManager.getSceneByID(action.cordArray.get(j)[run][2]));						
					}
				}
				
				run ++;
			} else {
//				ScreenManager.getCurrentScreen().addChild(Mapa.p1.mc);
				ScreenManager.getCurrentScreen().removeChild(Mapa.p1.mc);
				ScreenManager.getCurrentScreen().addChild(Mapa.p1.mc);
				ScreenManager.getCurrentScreen().removeChild(Mapa.p2.mc);
				ScreenManager.getCurrentScreen().addChild(Mapa.p2.mc);
				Mapa.p1.mc.setScene("idle");
				Mapa.p2.mc.setScene("idle");
				System.out.println("AQUI2");
				action.hideAction();
				((ScreenGame)ScreenManager.getCurrentScreen()).onActionDone(action.idAccion);
				ScreenManager.closePopup();
			}
		}
		
		count ++;
		if (count >= 24) count = 0;
	}
	
//	Jugador player;
//	for (int j = 0; j<jugArray.size(); j++){
//		GestorMapas.map.getCelda(posArray.get(j)[0],posArray.get(j)[1]).showTerreno();
//	}
//	
	
	

}
