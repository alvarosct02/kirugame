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

	private static final int ANCHOTOTAL = 1324;
	private static final int ANCHO = 1024;
    private static final int ALTO = 768;
	public static final int GRIDSIZE = 64;
	
	private BufferStrategy bufferStrategy;
    
	//	Nivel inicial a jugar   DEBERIA SER 0
	public static int currentLevel = 2;		
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

    public static int nextLevel(){
    	currentLevel++;
    	return currentLevel;
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
        
        this.setPreferredSize(new Dimension(ANCHOTOTAL, ALTO));
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
	
    

	
}
