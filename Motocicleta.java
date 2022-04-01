
public class Motocicleta extends Vehiculo implements Combustible {
	private Persona acompaniante;
	private double combustible;
	private double combustibleMaximo = 12;

	public Motocicleta(Persona chofer) {
		super(chofer);

		combustible = 0;
	}

	/**
	 *@pre: Una persona no puede ser chofer y acompañante al mismo tiempo
	 **/
	@Override
	public void cambiarChofer(Persona choferNuevo) {
		if (acompaniante != null)
			throw new Error("Todavia hay acompañantes");
		
		super.cambiarChofer(choferNuevo);
			
	}
	
	/**
	 *@pre: Una persona no puede ser chofer y acompañante al mismo tiempo
	 **/
	@Override
	public void agregarPersona(Persona nuevaPersona) {
		if (acompaniante != null)
			throw new Error("Ya hay un acompañante");
		
		this.acompaniante = nuevaPersona;	
	}

	@Override
	public void bajarPersona() {
		this.acompaniante = null;
	}

	@Override
	public void cargarCombustible(double combustible) {
		if (this.combustible + combustible > combustibleMaximo)
			throw new Error("No se puede exceder del combustible maximo: " + this.combustibleMaximo + " litros");
		else
			this.combustible += combustible;
	}

	@Override
	public void consumirCombustible(double kilometros) {
		if(kilometros*2 > this.combustible)
			throw new Error("No hay suficiente combustible");
		else		
			this.combustible -= kilometros*2;
	}
	
	@Override
	public void recorrerDistancia(double distancia) {
		consumirCombustible(distancia);
		super.recorrerDistancia(distancia);
		
	}

	public String toString() {
		return "Motocicleta\n" + super.toString() + "\n Combustible: " + this.combustible + "\n Acompañante: "
				+ this.acompaniante;
	}

}
