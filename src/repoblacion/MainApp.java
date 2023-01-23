package repoblacion;

import repoblacion.modelo.*;
import repoblacion.utilidades.Consola;

public class MainApp {
	
	private Bosque bosque; 
	
	public static void main(String[] args) {
		
		try{
			
			int anchura=0;
			int altura=0; 
			int poblacion=0; 
				
			do {
				anchura=Consola.leerAnchura();
					
			}while(anchura<Bosque.MINIMO || anchura>Bosque.MAX_ANCHURA); 
				
			do {
				altura=Consola.leerAltura();
					
			}while(altura<Bosque.MINIMO || altura>Bosque.MAX_ALTURA); 
				
			do {
				poblacion=Consola.leerPoblacion();
					
			}while(poblacion<=0 || poblacion>(2*(anchura+altura)));
				
			Bosque bosque=new Bosque(anchura,altura,poblacion);
			System.out.println();	
			System.out.println("Árbol más cercano: " + bosque.getArbolMasCercano()); 
			System.out.println("Árbol más alejado: " + bosque.getArbolMasAlejado());
			System.out.println();
				
		}catch(Exception e) {
					
			System.out.println(e.getMessage()); 
		}
	}
}
