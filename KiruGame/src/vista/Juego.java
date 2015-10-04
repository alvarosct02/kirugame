package vista;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import actionscript3.Stage;
import controlador.GestorMapas;
import controlador.InterpreteComandos;
import controlador.Mapa;
import modelo.Jugador;
import modelo.ObjetoApoyo;
import vista.screen.ScreenManager;


public class Juego extends JFrame{
	
	
	//	Nivel inicial a jugar   DEBERIA SER 0
	private final int firstLevel = 0;
	
	public static final int cantNivel = 2;
	
	public Jugador p1;
	public Jugador p2;
	public static Mapa map;
	
	private static boolean salir = false;
	
	
	public static int renderMode = 0;
	private String cmd = ""; 
	public Scanner sc = new Scanner(System.in);
	
	private BufferStrategy bufferStrategy;
	
	public Juego(){	
		Stage.stage = this;
		
		setTitle("KiruGame");
		setSize(1024, 768);
		setVisible(true);
		setResizable(false);		
		addGlobalListener();
		createBufferStrategy(2);
        bufferStrategy = getBufferStrategy();
		
		ScreenManager.showScreen("menu");
		
//		p1 = Mapa.p1;
//		p2 = Mapa.p2;		
//		Renderizador.mostrarWelcome();		
//		sc.nextLine();		
//		menuLoop();		
		
	}
	
	private void addGlobalListener(){
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
        		System.out.println("El juego ha terminado");
				dispose();
                System.exit(0);
            }
        });
	}
	
	public void paint(Graphics g) {
		super.paint(g);	
		try{
			Graphics2D graph2D = (Graphics2D)bufferStrategy.getDrawGraphics();
			graph2D.clearRect(0, 0, getWidth(), getHeight());
			ScreenManager.renderScreen(graph2D);
			graph2D.dispose();
			bufferStrategy.show();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void initGame(){
		Renderizador.beginPedirDatos();
		Renderizador.pedirDatos(1);		
		Jugador.resetVida();
		String nom1 = sc.next();
		p1.addData(nom1, "WASDQE",1,1,'A','S');
		Renderizador.pedirDatos(2);	
		String nom2 = sc.next();
		p2.addData(nom2, "IJKLUO",1,1,'B','N');
		Renderizador.endPedirDatos();
		gameLoop();
		if (Jugador.getVida()<= 0){
			gameOver();
		} else {
			gameWin();
		}
	}

	public void menuLoop(){
		Renderizador.mostrarMenuIncial();
		int act1;
		while (true){
			cmd = sc.next();
			act1 = InterpreteComandos.cmdInicial(cmd);
			if (act1 == 1){
				initGame();
				break;
			} else if (act1 == -1) {
				Renderizador.confirmacionSalir();
				int act2; 
				while (true){
					cmd = sc.next();
					act2 = InterpreteComandos.cmdSalir(cmd);
					if (act2 == 1){
						Renderizador.endGame();
						break;
					} else if (act2 == -1) {
						Renderizador.mostrarMenuIncial();
						break;						
					} else {
						Renderizador.errorCmd();
					}
				}
				if (act2 == 1) break;
			} else {
				Renderizador.errorCmd();				
			}
		}
	}
	

	public void gameLoop(){
		
		for (int i=firstLevel; i<=cantNivel; i++){	
			if (Jugador.getVida() <= 0) return;
			
//			Mostrar MENSAJE NUEVO NIVEL			
			Renderizador.nuevoNivel(i);
			
//			Mostrar Historia
			Renderizador.mostrarHistoria(i+1);
			
			if (i==0){
				Renderizador.dialogo1();
			}
			
//			Cargar el nivel correspondiente
			GestorMapas.cargarNivel(i);
			map = GestorMapas.map;
			int act1,act2 = 0;
			int[] resp;
			while (true){
				Renderizador.mostrarPantalla(map);
				Renderizador.ingreseComandoGame();
				cmd = sc.next();
				resp = InterpreteComandos.cmdJuego1(cmd);
				act1 = resp[0];
				
				if (act1 == -2)
					Renderizador.logNoMover();
					
				
				
				if (act1 >= 1){
					Jugador player = resp[1]==1? Mapa.p1: Mapa.p2;
					player.moverDir(resp[2]);
					Renderizador.logMover(player.getNombre(), player.dir);
					if (onEnterFrame(i)){						
						break;
					}
				} else if (act1 == -1) {
					Renderizador.confirmacionSalirGame();
					while (true){
						cmd = sc.next();
						act2 = InterpreteComandos.cmdSalir(cmd);
						if (act2 == 1){
							break;
						} else if (act2 == -1) {							
							break;						
						} else {
							Renderizador.errorCmd();
						}
					}
					if (act2 == 1) break;
				} else {
					Renderizador.errorCmd();				
				}				
			}
			if (act2 == 1){
				menuLoop();
				break;				
			}
		}			
		
	}
	
	private boolean onEnterFrame(int i) {
		if (Jugador.getVida() <= 0)
			return true;			
		
		if (map.checkEnemigos())
			return false;
		
		int idAccion = map.ejecutarAccionEspecial();
		
//		CONDICION ESPECIAL NIVEL 1
		if (i==1 && p1.gridX == 0 && p2.gridX == 0)
			return true;		

		if (i==2 && p1.gridX == 15 && p2.gridX == 15)
			return true;
		
//		SE ACABO LA VIDA
		if (idAccion == -2)
			return true;
		
//		NO PASO NADA
		else if (idAccion == -1)		
			return false;
		else {
//			PARA EL NIVEL 0
			if (i == 0){
				if (idAccion == 1){			
					Renderizador.dialogo2();
					return true;
				}
			}
			
//			PARA EL NIVEL 1
			if (i == 1){
				if (idAccion == 0){	
					map.getObjeto(2).quitarMapa();
					return false;
				}
				if (idAccion == 2){	
					map.getEnemigo(0).destruir();
					return false;
				}
			}			
			
//			PARA EL NIVEL 2
			if (i == 2){
				if (idAccion == 1){	
					ObjetoApoyo obj = (ObjetoApoyo)map.getObjeto(5);
					obj.allowWalk();
					return false;
				}
			}	
		}
		return false;		
	}

	private void gameOver() {
		Renderizador.pantallaGameOver();
		menuLoop();
	}
	
	private void gameWin() {
		Renderizador.pantallaJuegoCompletado();
		menuLoop();
	}


	
}
