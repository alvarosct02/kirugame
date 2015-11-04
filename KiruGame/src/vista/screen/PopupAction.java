package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import actionscript3.MovieClip;
import actionscript3.Screen;
import actionscript3.Sprite;
import actionscript3.TextField;
import controlador.AssetManager;
import modelo.AccionEspecial;
import modelo.Jugador;
import modelo.Mapa;

public class PopupAction extends Screen {

	public String sec = "";
	private int currentPos = 0;
	private AccionEspecial action;
	private Sprite spriteChar = new Sprite(); 
	private int run = -1;
	private int count;
	private boolean first = true;
	private TimerAction timer;
	public static boolean restartFlag = false; 
	public static TextField tf ;
	
	public PopupAction() {
		// TODO Auto-generated constructor stub
		setImg(AssetManager.getImage("popupFeo"));
		tf = new TextField("0","hobo");
		spriteChar.x = 450;
		spriteChar.y = 300;
		addChild(spriteChar);
		spriteChar.addChild(tf);
		tf.x = 0;
		tf.y = 0;
		tf.setSize(30);
		

		
	}
	
	public void definirAccion(AccionEspecial action){
		this.action = action;
		this.sec = action.getSec();
		restartFlag = true;
		
	}
	
	private void ejecutarAccion(){
		timer.detener();
		timer = null;
		
		removeChild(spriteChar);
		setImg(null);
		run = 0;
	}
	
	private void startShowSeq(){
		currentPos = 0;
		updateChar();
		if (timer == null){
			timer = new TimerAction(this.action.tiempo);
			timer.start();
		}
	}
	
	public void updateChar(){
		spriteChar.setImg(AssetManager.getImage( String.valueOf(sec.charAt(currentPos))  ));
	}	
	
	@Override
	public void onKeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.onKeyPressed(e);
		
		if (Character.toUpperCase(e.getKeyChar()) == sec.charAt(currentPos)){
			currentPos++;
			if (currentPos < sec.length()){
				updateChar();				
			} else {
				ejecutarAccion();				
			}			
		} else {
			Jugador.getTipoDano(2);
			restartFlag = true;
		}
	}
		
	@Override
	public void onEnterFrame() {
		// TODO Auto-generated method stub
//		int count = 0;
		
		
		
		
		if (Jugador.getVida() <= 0){
			timer.detener();
			ScreenManager.showScreen("gameOver");
		}
		
		if (restartFlag == true){
			restartFlag = false;
			startShowSeq();
		}
		
		
		if (count == 0 && run >= 0){
			if (first){
				action.hideAction();
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
						ScreenManager.getCurrentScreen().removeChild(player.sprite);
					} else if (action.cordArray.get(j)[run][2] == -1){
						count = 24;
					} else {
						((MovieClip)player.sprite).addScene(AssetManager.getSceneByID(action.cordArray.get(j)[run][2]));						
					}
				}
				
				run ++;
			} else {
//				ScreenManager.getCurrentScreen().addChild(Mapa.p1.mc);
				ScreenManager.getCurrentScreen().removeChild(Mapa.p1.sprite);
				ScreenManager.getCurrentScreen().addChild(Mapa.p1.sprite);
				ScreenManager.getCurrentScreen().removeChild(Mapa.p2.sprite);
				ScreenManager.getCurrentScreen().addChild(Mapa.p2.sprite);
				Mapa.p1.setIdle();
				Mapa.p2.setIdle();
				System.out.println("AQUI2");
//				action.hideAction();
				((ScreenGame)ScreenManager.getCurrentScreen()).onActionDone(action.idAccion);
				ScreenManager.closePopup();
			}
		}
		if (run >= 0)
			count ++;
		if (count >= 24) count = 0;
	}

	
//	Jugador player;
//	for (int j = 0; j<jugArray.size(); j++){
//		GestorMapas.map.getCelda(posArray.get(j)[0],posArray.get(j)[1]).showTerreno();
//	}
//	
}


//timer.detener();
//timer = null;

class TimerAction extends Thread{
	private int maxTime = 0;
	private int contador = -1;
	private boolean running = true;
	
	public TimerAction(int numSec){
		this.maxTime = numSec;
	}
	
	public void detener(){
		running = false;
	}
	
	public void run() {
		try {
			while (running){
				contador ++ ;
				System.out.println("Seconds:" + contador);
				
				if (Jugador.getVida() <= 0){
					break;
				}
				
				if (contador == maxTime){
					PopupAction.tf.setText("Tiempo: " + contador);
					contador = -1;	
					PopupAction.restartFlag = true;
					Jugador.getTipoDano(2);
					continue;
				}
				sleep(1000);
			}
			System.out.println("TimerAction Fuera");
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
