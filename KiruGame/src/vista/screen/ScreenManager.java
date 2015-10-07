package vista.screen;

import java.awt.Graphics2D;

import actionscript3.Screen;
import modelo.Jugador;

public class ScreenManager {
	
	private static Screen currentScreen;
	private static Screen currentPopup;
	
	public static Screen getCurrentScreen() {
		return currentScreen;
	}

	public static Screen getCurrentPopup() {
		return currentPopup;
	}
		
	public static void showScreen(String screen){
		Screen newScreen = null;
		
		closePopup();
		
		if (currentScreen != null){
			currentScreen.removerListeners();
		}
		
		switch(screen){
			case "menu": newScreen = new ScreenMenu(); break;
			case "game": newScreen = new ScreenGame(false); break;
			case "loadGame": newScreen = new ScreenGame(true); break;
			case "gameOver": newScreen = new ScreenGameOver(); break;
			case "gameWin": newScreen = new ScreenGameWin(); break;
		}
		
        currentScreen = newScreen;
	}
	
	public static void showPopup(String popup){
		Screen newPopup = null;		
		currentScreen.active = false;
//		currentScreen.pause();
		currentScreen.disable();
		switch(popup){
			case "action": newPopup = new PopupAction(); break;
			case "salirAlMenu": newPopup = new PopupConfirmacionSalir(0); break;
			case "salirTotal": newPopup = new PopupConfirmacionSalir(1); break;
			case "historia": newPopup = new PopupHistoria(); break;
			case "exitoGuardar": newPopup = new PopupExitoGuardar(); break;
			case "nuevoJugador": newPopup = new PopupNuevoJugador(); break;
			
//			case "game": newPopup = new ScreenGame(); break;
//			case "test": newPopup = new ScreenTest(); break;
		}
		
        currentPopup = newPopup;
	}
	
	public static void closePopup(){		
		if (currentPopup == null) return;
		
		currentScreen.active = true;
		currentScreen.enable();
//		currentScreen.restart();		
		currentPopup.removerListeners();
		currentPopup = null;
	}
	
	public static void renderScreen(Graphics2D canvas){
		currentScreen.renderAll(canvas);
		
		if (Jugador.getVida() <= 0){
//			Jugador.resetVida();
			showScreen("gameOver");
			return;
		}
		
		if (currentPopup != null)
			currentPopup.renderAll(canvas);
	}
	
}
