package repoblacion.modelo;

public enum Especie {ALAMO("Álamo"), ENCINA("Encina"), CASTANO("Castaño"), 
	CIPRES("Ciprés"), PINO("Pino Piñonero"), ROBLE("Roble Mediterráneo"),
	OLIVO("Olivo"); 

	
	private String cadenaAMostrar; 
	
	private Especie(String cadenaAMostrar) {
		
		this.cadenaAMostrar=cadenaAMostrar; 
	}
	
	@Override
	public String toString() 
	{
		return this.cadenaAMostrar;
	}
}
