package vista;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import java.util.Scanner;

import javax.swing.*;

//import DemoComponents.MouseHandler;
import actionscript3.Stage;
import controlador.GestorMapas;
import controlador.InterpreteComandos;
import controlador.Mapa;
import modelo.Jugador;
import modelo.ObjetoApoyo;
import vista.screen.ScreenManager;


public class Juego extends JPanel{

	private static final int ANCHO = 1024;
    private static final int ALTO = 768;
	public static final int GRIDSIZE = 64;
	
	private BufferStrategy bufferStrategy;		
    
	//	Nivel inicial a jugar   DEBERIA SER 0
	public static int currentLevel = 0;		
	public static final int cantNivel = 2;
	
	public Jugador p1;
	public Jugador p2;
	public static Mapa map;
	public static int renderMode = 0;
	private String cmd = ""; 
	public Scanner sc = new Scanner(System.in);
	

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Juego().create();
            }
        });
    }

    private void create() {
        JFrame f = new JFrame("KiruGame");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.setResizable(false);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true); 
        setFocusable(true);
        requestFocusInWindow();
        

//        f.createBufferStrategy(2);
//        bufferStrategy = f.getBufferStrategy();
    }

    public Juego() {
        super(true);
        this.setOpaque(false);

		AssetManager.cargarImagenes();
		AssetManager.cargarObjetos();
		AssetManager.cargarEnemigos();
		AssetManager.cargarAnimaciones();
		
		GestorMapas.cargarAnimacionesJugadores();
        
        Stage.stage = this;
        ScreenManager.showScreen("menu");
        
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
//        this.addMouseListener(new MouseHandler());
    }

    @Override
    protected void paintComponent(Graphics g) { 
    	super.paintComponent(g);   
//        Graphics2D graph2D = (Graphics2D)bufferStrategy.getDrawGraphics();
        Graphics2D graph2D = (Graphics2D) g;
		graph2D.clearRect(0, 0, getWidth(), getHeight());
		ScreenManager.renderScreen(graph2D);
//		update(graph2D);
//		graph2D.dispose();
        
//		bufferStrategy.show();
    }
//    
//    private class MouseHandler extends MouseAdapter {
//        @Override
//        public void mousePressed(MouseEvent e) {
//            super.mousePressed(e);
//            JTextField field = new JTextField("test");
//            Dimension d = field.getPreferredSize();
//            field.setBounds(e.getX(), e.getY(), d.width, d.height);
//            add(field);
//        }
//    }
	
    
    
//  JUEGO ANITGUOOOOO
//  JUEGO ANITGUOOOOO
//  JUEGO ANITGUOOOOO
//  JUEGO ANITGUOOOOO
//  JUEGO ANITGUOOOOO
//  JUEGO ANITGUOOOOO
//  JUEGO ANITGUOOOOO
//  JUEGO ANITGUOOOOO
//  JUEGO ANITGUOOOOO
    
	
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
//		gameLoop();
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
	

//	public void gameLoop(){
//		
//		for (int i=currentLevel; i<=cantNivel; i++){	
//			if (Jugador.getVida() <= 0) return;
//			
////			Mostrar MENSAJE NUEVO NIVEL			
//			Renderizador.nuevoNivel(i);
//			
////			Mostrar Historia
//			Renderizador.mostrarHistoria(i+1);
//			
//			if (i==0){
//				Renderizador.dialogo1();
//			}
//			
////			Cargar el nivel correspondiente
//			GestorMapas.cargarNivel(i);
//			map = GestorMapas.map;
//			int act1,act2 = 0;
//			int[] resp;
//			while (true){
//				Renderizador.mostrarPantalla(map);
//				Renderizador.ingreseComandoGame();
//				cmd = sc.next();
//				resp = InterpreteComandos.cmdJuego1(cmd);
//				act1 = resp[0];
//				
//				if (act1 == -2)
//					Renderizador.logNoMover();
//					
//				
//				
//				if (act1 >= 1){
//					Jugador player = resp[1]==1? Mapa.p1: Mapa.p2;
//					player.moverDir(resp[2]);
//					Renderizador.logMover(player.getNombre(), player.dir);
//					if (onEnterFrame(i)){						
//						break;
//					}
//				} else if (act1 == -1) {
//					Renderizador.confirmacionSalirGame();
//					while (true){
//						cmd = sc.next();
//						act2 = InterpreteComandos.cmdSalir(cmd);
//						if (act2 == 1){
//							break;
//						} else if (act2 == -1) {							
//							break;						
//						} else {
//							Renderizador.errorCmd();
//						}
//					}
//					if (act2 == 1) break;
//				} else {
//					Renderizador.errorCmd();				
//				}				
//			}
//			if (act2 == 1){
//				menuLoop();
//				break;				
//			}
//		}			
//		
//	}
	
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
