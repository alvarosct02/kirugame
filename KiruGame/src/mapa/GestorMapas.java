package mapa;

public class GestorMapas {
	

	private static char tutorial[][] = {
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'A','S','S','S','S','S','S','S','C','d','d','S','S','S','S','S'},
		{'S','S','S','m','m','S','S','S','S','d','d','S','S','S','S','S'},
		{'S','S','S','m','m','S','j','j','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','j','j','S','S','S','S','S','D','S','o'},
		{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','o'},
		{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','o'},
		{'N','N','N','N','m','m','N','N','N','N','N','N','N','D','N','o'},
		{'N','N','N','N','m','m','N','N','N','N','N','N','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','j','j','N','j','j','N','N','N'},
		{'B','N','N','N','N','N','N','N','j','j','N','j','j','N','N','N'}
	};
	private static char nivel1[][] ={
		{'B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B'},
		{'B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B'},
		{'B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','C','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','A'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p'},
		{'N','N','N','L','N','N','N','N','N','i','i','N','N','N','N','N'},
		{'N','N','N','L','C','N','N','N','N','i','i','N','N','N','N','B'},
		{'N','N','N','L','N','N','N','N','N','N','N','g','g','N','N','N'},
		{'B','N','N','L','N','N','N','N','N','N','N','g','g','N','N','N'}
	};
	private static char nivel2[][] ={
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'S','S','S','S','t','S','S','S','S','L','L','L','L','L','L','L'},
		{'S','S','S','S','t','S','S','S','S','L','L','L','L','L','L','L'},
		{'A','S','S','C','t','S','S','S','S','L','L','L','L','L','L','L'},
		{'S','S','S','S','t','S','S','S','D','L','L','L','o','o','o','o'},
		{'g','g','g','g','g','g','g','g','g','L','L','L','o','o','o','o'},
		{'N','N','N','m','N','N','N','N','D','L','L','L','L','L','L','L'},
		{'N','N','N','m','N','N','N','N','N','L','L','L','L','L','L','L'},
		{'B','N','N','m','N','h','h','N','N','L','L','L','L','L','L','L'},
		{'N','N','N','N','N','h','h','N','N','L','L','L','L','L','L','L'}
	};

	protected static char[][][] arrayMap = {tutorial,nivel1,nivel2};
	public static Mapa map;
//	public GestorMapas(){
//		
//	}
	
	public static void cargarNivel(int i){
		map = new Mapa(arrayMap[i]);
		
		
		
		
		
	}
	
	
}
