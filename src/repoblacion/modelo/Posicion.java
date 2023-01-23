package repoblacion.modelo;

public class Posicion {

	private double x; 
	private double y; 
	
	// Constructor normal con parámetros
	
	public Posicion(double x, double y) {
		
		setX(x); 
		setY(y); 
	}
	
	// Constructor copia, recibe como parámetro un objeto de la misma clase posición
	
	public Posicion(Posicion p) {
		
		if(p==null) {
			
			throw new NullPointerException("ERROR: No se puede copiar una posición nula."); 
		}	
		
		setX(p.getX());
		setY(p.getY());
	}
	
	private void setX(double x) {
		this.x = x;
	}
	
	public double getX() {
		return x;
	}
	
	private void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}
	
	/* Se crea el método distancia que aceptará otra posición como parámetro y si es 
	 * distinta de null devolverá la distancia entre la posición en cuestión y la 
	 * pasada por parámetro y en caso contrario lanzará la excepción 
	 * NullPointerException. Se ha usado la fórmula matemática del teorema de Euclides para
	 * el cálculo: d = √ [(x2-x1) ^ + (y2-y1) ^ 2] */
	
	public double distancia(Posicion posicion) {
		
		if(posicion==null) {
			
			throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula."); 
		}
		
		double distancia=Math.sqrt(Math.pow(posicion.getX()-x,2) + Math.pow(posicion.getY()-y,2));
		
		return distancia;
	}

	@Override
	
	/* Se crea el método toString que devolverá un String y será la representación de 
	 * la posición (x=valorX, y=valorY). Se restringirán los decimales a tres */
	
	public String toString() {
		
		return String.format("x=%5.3f, y=%5.3f", x,y);
	}
}
