package vista;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import java.util.Scanner;

import javax.swing.*;

import actionscript3.Stage;
import controlador.AssetManager;
import controlador.GestorMapas;
import modelo.Jugador;
import modelo.Mapa;
import vista.screen.ScreenManager;


public class Juego extends JPanel{

	public static final int ANCHOTOTAL = 1324;
	public static final int ANCHO = 1024;
	public static final int ALTO = 768;
	public static final int GRIDSIZE = 64;
	public static JFrame window;
	
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
    	System.out.println("NO OLVIDES BORRAR LEVEL TEST EN MENUSCREEN!");
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
        window = new JFrame("KiruGame");
        window.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) {
        		ScreenManager.detener();
        		System.exit(0);
        	}
    	});
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(this);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true); 
        setFocusable(true);
        requestFocusInWindow();
        

//        f.createBufferStrategy(2);
//        bufferStrategy = f.getBufferStrategy();
    }
    

    public Juego() {
        super(true);
        this.setOpaque(false);

        Stage.stage = this;
		AssetManager.init();
		ScreenManager.init();
		
		GestorMapas.cargarAnimacionesJugadores();
        
        
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
		ScreenManager.renderGame(graph2D);
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
