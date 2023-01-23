package repoblacion.modelo;

public class Arbol {
	
	private Posicion posicion; 
	private Especie especie;
	
	// Constructor normal con parámetros
	
	public Arbol(Especie especie, Posicion posicion) {
			
		setEspecie(especie); 
		setPosicion(posicion); 
	}
	
	// Constructor copia:
		
	public Arbol(Arbol a) {
			
		if(a==null) {
				
			throw new NullPointerException("ERROR: No se puede copiar un árbol nulo."); 
		} 
			
		setEspecie(a.getEspecie());
		setPosicion(a.getPosicion());
	}
		
	private void setEspecie(Especie especie) {
		
		if(especie==null) {
			
			throw new NullPointerException("ERROR: La especie no puede ser nula."); 
		} 
		
		this.especie = especie;
	}
	
	public Especie getEspecie() {
		return especie;
	}
	
	private void setPosicion(Posicion posicion) {
		
		if(posicion==null) {
			
			throw new NullPointerException("ERROR: La posición no puede ser nula."); 
		} 
		
		this.posicion = posicion; 
	}

	public Posicion getPosicion() {
		return posicion;
	}
	
	@Override
	public String toString() {
		return String.format("especie=%s, posicion=(%s)", especie, posicion);
	} 
}
