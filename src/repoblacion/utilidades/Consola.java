package repoblacion.utilidades;

import org.iesalandalus.programacion.utilidades.*;

public class Consola {
	
	public static int leerAnchura() {
		
		int anchura = 0;
		
		System.out.println("Introduce la anchura del bosque: ");
    	anchura=Entrada.entero(); 
    			
        return anchura;
	}
		
	public static int leerAltura() {
		
		int altura = 0;
		
		System.out.println("Introduce la altura del bosque: ");
    	altura=Entrada.entero(); 
    			
        return altura;
	}
	
	public static int leerPoblacion() {
			
		int poblacion = 0; 
		
        System.out.println("Introduce la población de especies: ");
    	poblacion=Entrada.entero();
		
		return poblacion;
	}
	
	private Consola() {
		
	}
}
