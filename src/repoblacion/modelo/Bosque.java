package repoblacion.modelo;

import java.util.Arrays;
import java.util.Random;

public class Bosque {
	
	public static final int MAX_ANCHURA=1000; 
	public static final int MAX_ALTURA=500; 
	public static final int MINIMO=10; 
	public static final int MAX_ESPECIES=4; 
	
	private Arbol arbolMasAlejado;
	private Arbol arbolMasCercano; 
	private Random generador; 
	private int ancho; 
	private int alto; 
	private Arbol[] arboles; 
	
	/* Constructor de la clase Bosque con parámetros, éstos se usan para crear el Array 
	 * de árboles*/ 
	
	public Bosque(int ancho, int alto, int poblacion) {
		
		setAncho(ancho);
		setAlto(alto);
		checkPoblacion(poblacion);
		
		arboles = new Arbol[poblacion];
		generador = new Random(); 
		repoblar();
		realizarCalculos(); 
	}
	
	/* Se crea el método duplicaBosque que devuelve una copia del bosque. En este caso se trata de 
	 * un nuevo objeto array de objetos de tipo árbol, por lo que si se variaran los objetos en 
	 * uno de los arrays los cambios no afectarían al otro, por lo que se evita así el aliasing */
	
	public Arbol[] duplicaBosque() {
		
		Arbol[] bosque2=new Arbol[arboles.length];
		
	return bosque2;
	}
	
	private void setAncho(int ancho) {
		
		if(ancho<MINIMO || ancho>MAX_ANCHURA) {
			
			throw new IllegalArgumentException("ERROR: Anchura no válida."); 
		}
		
		this.ancho = ancho;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	private void setAlto(int alto) {
		
		if(alto<MINIMO || alto>MAX_ALTURA){
			
			throw new IllegalArgumentException("ERROR: Altura no válida."); 
		}
		
		this.alto=alto; 
	}
	
	public int getAlto() {
		return alto;
	}
	
	/* Se crea el método repoblar que para cada elemento del array de árboles, 
	 * creará un nuevo árbol de una especie aleatoria y en una posición aleatoria 
	 * dentro de los límites en x (-ancho/2, ancho/2) e y (-alto/2, alto/2) */
	
	private void repoblar(){
		
		// Se crean el array de especies y los arrays auxiliares para asegurar la compatibilidad
		// entre especies: 
			
			Especie[] especies=new Especie[arboles.length];
			
			int[] especies_random= new int[arboles.length];
			int[] alamoIncompatibles= new int[arboles.length];
			int[] castanoIncompatibles= new int[arboles.length];
			int[] cipresIncompatibles= new int[arboles.length];
			int[] encinaIncompatibles= new int[arboles.length];
			int[] olivoIncompatibles= new int[arboles.length];
			int[] primerArbolPinoORoble= new int[arboles.length];
			
			for(int i=0; i<arboles.length; i++) {
				
				especies_random[i]=generador.nextInt(0,7);	 
			} 
			
			if(especies_random[0]==0) {
				especies[0]=Especie.ALAMO;
			}else if(especies_random[0]==1) {
				especies[0]=Especie.CASTANO;
			}else if(especies_random[0]==2) {
				especies[0]=Especie.CIPRES;
			}else if(especies_random[0]==3) {
				especies[0]=Especie.ENCINA;
			}else if(especies_random[0]==4) {
				especies[0]=Especie.OLIVO;
			}else if(especies_random[0]==5) {
				especies[0]=Especie.PINO;
			}else if(especies_random[0]==6) {
				especies[0]=Especie.ROBLE;
			} 
			
			/* Se rellena el array de especies teniendo en cuenta la especie de la primera posición 
			 * especies[0], con lo que todas las demás especies del array se crearán en función de 
			 * esa y de las incompatibolidades entre especies: */
			
			for(int i=0; i<arboles.length; i++) {
				
				alamoIncompatibles[i]=generador.nextInt(0,4);
				castanoIncompatibles[i]=generador.nextInt(0,4);
				cipresIncompatibles[i]=generador.nextInt(0,4);
				encinaIncompatibles[i]=generador.nextInt(0,4);
				olivoIncompatibles[i]=generador.nextInt(0,4);
				primerArbolPinoORoble[i]=generador.nextInt(0,4); 
				
				
				if(especies[0]==Especie.ALAMO) {
					
					if(alamoIncompatibles[i]==0) {
						
						especies[i]=Especie.ALAMO;
					}else if(alamoIncompatibles[i]==1) {
						especies[i]=Especie.ENCINA;
						
					}else if(alamoIncompatibles[i]==2) {
						especies[i]=Especie.PINO;
						
					}else if(alamoIncompatibles[i]==3) {
						especies[i]=Especie.ROBLE;
					}
				}else if(especies[0]==Especie.CASTANO) {
						
					if(castanoIncompatibles[i]==0) {
						especies[i]=Especie.CASTANO;
					}else if(castanoIncompatibles[i]==1) {
						especies[i]=Especie.CIPRES;
					}else if(castanoIncompatibles[i]==2) {
						especies[i]=Especie.OLIVO;	
					}else if(castanoIncompatibles[i]==3) {
						especies[i]=Especie.PINO;
					}
					
				}else if(especies[0]==Especie.CIPRES) {
					
					if(cipresIncompatibles[i]==0) {
						especies[i]=Especie.CASTANO;
					}else if(cipresIncompatibles[i]==1) {
						especies[i]=Especie.CIPRES;
					}else if(cipresIncompatibles[i]==2) {
						especies[i]=Especie.ENCINA;	
					}else if(cipresIncompatibles[i]==3) {
						especies[i]=Especie.ROBLE;
					}
				}else if(especies[0]==Especie.ENCINA) {		
					if(encinaIncompatibles[i]==0) {
						especies[i]=Especie.ALAMO;
					}else if(encinaIncompatibles[i]==1) {
						especies[i]=Especie.ENCINA;
					}else if(encinaIncompatibles[i]==2) {
						especies[i]=Especie.PINO;
					}else if(encinaIncompatibles[i]==3) {
						especies[i]=Especie.ROBLE;
					}		
				}else if(especies[0]==Especie.OLIVO) {				
					if(olivoIncompatibles[i]==0) {
						especies[i]=Especie.CASTANO;
					}else if(olivoIncompatibles[i]==1) {
						especies[i]=Especie.CIPRES;
					}else if(olivoIncompatibles[i]==2) {
						especies[i]=Especie.OLIVO;
					}else if(olivoIncompatibles[i]==3) {
						especies[i]=Especie.ROBLE;
					}	
				}else if(especies[0]==Especie.PINO || especies[0]==Especie.ROBLE) {
					if(primerArbolPinoORoble[i]==0) {
						especies[i]=Especie.ALAMO;
					}else if(primerArbolPinoORoble[i]==1) {
						especies[i]=Especie.ENCINA;
					}else if(primerArbolPinoORoble[i]==2) {
						especies[i]=Especie.PINO;
					}else if(primerArbolPinoORoble[i]==3) {
						especies[i]=Especie.ROBLE;
					}
				}
			}
		//////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////
			
		// CREAMOS ARRAY DE POSICIONES Y ÁRBOLES Y LO IMPRIMIMOS: 
			
			// CREAMOS ARRAY DE POSICIONES: 
			
			Posicion[] posiciones=new Posicion[arboles.length]; 
			Posicion centro=new Posicion(0,0); 
			
			for(int i=0; i<arboles.length; i++) {
				
				posiciones[i]=new Posicion(generador.nextDouble(-ancho/2, ancho/2), generador.nextDouble(-alto/2, alto/2));
				arboles[i]=new Arbol(especies[i],posiciones[i]); 
				
				System.out.println(arboles[i]); 
				System.out.println("Distancia respecto al centro del bosque (0,0): " + arboles[i].getPosicion().distancia(centro));
				
				System.out.println();
			}
		}
			
	/* Se crea el método checkPoblacion que comprueba si el parámetro población pasado 
	 * al constructor es válido. En caso de no serlo, lanzará la excepción adecuada con 
	 * el mensaje adecuado */
	
	public void checkPoblacion(int poblacion) {
		
		/* Como mínimo se debe plantar un árbol, por lo que la población no puede
		* ser nula o negativa */
		
		if(poblacion<=0) {
			
			throw new IllegalArgumentException("ERROR: La población debe ser mayor que cero."); 
		}
		
		/* La cantidad de árboles a plantar no podrá superar el perímetro del bosque 
		 * (2*(ancho+alto)) */ 
		
		if(poblacion>(2*(this.ancho+this.alto))) {
			
			throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque."); 
		}
	}
	
	/* Se crea el método realizarCalculos que recorrerá el array de árboles y 
	 * calculará cuál es el más centrado y el más alejado del centro (punto (0, 0)) */
	
	public void realizarCalculos() {
		
		Posicion centro=new Posicion(0,0); 
		
		double distanciaMasLejana=arboles[0].getPosicion().distancia(centro);
		double distanciaMasCercana=arboles[0].getPosicion().distancia(centro);
		 
		for(int i=1; i<arboles.length; i++) {
			
			if(arboles[i].getPosicion().distancia(centro)>distanciaMasLejana) {
				
				distanciaMasLejana=arboles[i].getPosicion().distancia(centro);
			}
			
			if(arboles[i].getPosicion().distancia(centro)<distanciaMasCercana) {
				
				distanciaMasCercana=arboles[i].getPosicion().distancia(centro);
			}
		}	
		
		for(int j=0; j<arboles.length; j++) {
			
			if(arboles[j].getPosicion().distancia(centro)==distanciaMasLejana) {
				this.arbolMasAlejado=arboles[j];
				if(arboles.length==1) {
					
					this.arbolMasCercano=arboles[j];
				}
			}else if(arboles[j].getPosicion().distancia(centro)==distanciaMasCercana) {
				this.arbolMasCercano=arboles[j];
			}
		}
		System.out.println("La distancia más cercana respecto al centro del bosque (0,0) es: " + distanciaMasCercana);
		System.out.println("La distancia más lejana respecto al centro del bosque (0,0) es: " + distanciaMasLejana);
	}
		
	public Arbol getArbolMasAlejado() {
		return arbolMasAlejado;
	}
	
	public Arbol getArbolMasCercano() {
		return arbolMasCercano;
	}

	@Override
	public String toString() {
		return "Bosque [ancho=" + ancho + ", alto=" + alto + ", arboles=" + Arrays.toString(arboles) + "]";
	}
}
